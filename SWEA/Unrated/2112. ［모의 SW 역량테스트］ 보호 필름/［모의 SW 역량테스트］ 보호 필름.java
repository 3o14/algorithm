import java.io.*;
import java.util.*;

class Solution {

	static int D, K, W;
	static int arr[];
	static int res;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			res = D;
			
			map = new int[D][W];
			arr = new int[D];
			
			Arrays.fill(arr, -1);
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			
			dfs(0, 0);
			
			sb.append(" ").append(res).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void dfs(int idx, int cnt) {
		if(cnt >= res) {
			return;
		}
		
		if(idx == D) {
			if(check()) {
				res = Math.min(res, cnt);				
			}
			return;
		}
        
		arr[idx] = -1;
		dfs(idx+1, cnt);
		
		arr[idx] = 1;
		dfs(idx+1, cnt+1);

		arr[idx] = 0;
		dfs(idx+1, cnt+1);
	}
	
	private static boolean check() {
		int cnt = 0;
		int a, b;
		for (int j = 0; j < W; j++) {
			cnt = 1;
			for (int i = 0; i < D-1; i++) {
				a = map[i][j];
				b = map[i+1][j];
				
				if(arr[i] != -1) {
					a = arr[i];
				}
				if(arr[i+1] != -1) {
					b = arr[i+1];
				}
				
				if(a == b) {
					cnt++;
				} else {
					cnt = 1;
				}
				
				if(cnt >= K) {
					break;
				}
			}
			
			if(cnt < K) {
				return false;
			}
		}
		
		return true;
	}
}
