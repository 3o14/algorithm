import java.io.*;
import java.util.*;

class Solution {

	static int N, M, C, ans;
	static int map[][], honey[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			honey = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// input end
			
			ans = 0;
			solving();
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void solving() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				makeSet(i, j, 0, 0, 0);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				combi(i, j+M, 1, honey[i][j]);
			}
		}
		
	}
	
	private static void combi(int i, int j, int cnt, int max) {
		if(cnt == 2) {
			ans = Math.max(max, ans);
			return;
		}
		
		for (int k = i; k < N; k++) {
			for (int k2 = j; k2 <= N-M; k2++) {
				combi(k, k2, cnt+1, max+honey[k][k2]);
			}
			j = 0;
		}
	}

	private static void makeSet(int i, int j, int cnt, int sum, int total) {
		if(sum > C) return;
		if(cnt == M) {
			honey[i][j-M] = Math.max(honey[i][j-M], total);
			return;
		}
		
		makeSet(i, j+1, cnt+1, sum+map[i][j], total+map[i][j]*map[i][j]);
		makeSet(i, j+1, cnt+1, sum, total);
	}

}
