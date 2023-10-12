import java.io.*;
import java.util.*;

class Solution {

	static int D, W, K, ans;
	static int map[][], arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			arr = new int[D];

			Arrays.fill(arr, -1);
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			solving(0, 0);
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void solving(int idx, int cnt) {
		if(cnt >= ans) {
			return;
		}
		
		if(idx == D) {
			if(check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		arr[idx] = -1;
		solving(idx+1, cnt);
		
		arr[idx] = 1;
		solving(idx+1, cnt+1);
		
		arr[idx] = 0;
		solving(idx+1, cnt+1);
	}
	
	private static boolean check() {
		int cnt = 0, a, b;
		for (int i = 0; i < W; i++) {
			cnt = 1;
			for (int j = 0; j < D-1; j++) {
				a = map[j][i];
				b = map[j+1][i];
				
				if(arr[j] != -1) {
					a = arr[j];
				}
				
				if(arr[j+1] != -1) {
					b = arr[j+1];
				}
				
				if(a == b) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if(cnt >= K) break;
			}
			
			if( cnt < K ) return false; 
		}
		return true;
	}

}
