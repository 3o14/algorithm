import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
				
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = -1;
			for (int i = N-1; i >= 0; i--) {
				int max = arr[i];
				if(max > limit) continue;
				for (int j = 0; j < i; j++) {
					int min = arr[j];
					int temp = max + min;
					if( temp > ans && temp <= limit) ans = temp;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
