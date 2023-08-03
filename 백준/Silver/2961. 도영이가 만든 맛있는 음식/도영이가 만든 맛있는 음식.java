import java.util.*;
import java.io.*;

public class Main {
	static int[] meal1; // 곱
	static int[] meal2; // 합
	static int res = 1000000000;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		meal1 = new int[n];
		meal2 = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			meal1[i] = Integer.parseInt(st.nextToken());
			meal2[i] = Integer.parseInt(st.nextToken());
			
		}
		making_food(0, 0, 1, 0);
		System.out.println(res);
	}
	public static void making_food(int input_cnt, int cnt, int meal1_sum, int meal2_sum) {
		if(cnt == n) {
			if(input_cnt !=0) {
				res = Math.min(res, Math.abs(meal1_sum-meal2_sum));
			}
			return;
		}
		making_food(input_cnt, cnt+1, meal1_sum, meal2_sum);
		making_food(input_cnt+1, cnt+1, meal1_sum*meal1[cnt], meal2_sum+meal2[cnt]);
		
	}
}