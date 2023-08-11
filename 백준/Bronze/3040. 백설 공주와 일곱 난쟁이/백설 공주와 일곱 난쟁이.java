import java.util.*;
import java.io.*;

public class Main {
	public static int arr[] = new int[9];
	public static int nums[] = new int[7];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int cnt, int start) {
		
		if (cnt == 7) { 
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += nums[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(nums[i]).append("\n");
				}
				return;
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			nums[cnt] = arr[i];
			dfs(cnt + 1, i + 1);
		}
	}
}	