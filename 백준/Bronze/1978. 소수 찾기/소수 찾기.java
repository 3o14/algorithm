import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int check = 0;
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) continue;
			for (int j = 2; j < num; j++) {
				if(num % j == 0) continue;
				check++;
			}
			
			if(check == num-2) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}
}	