import java.io.*;
import java.util.*;


public class Main {
	static int T, N, M, D;
	static int dy[] = {1, 0, -1, 0}, dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			// 그래프 정보 입력받기
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			int graph[][] = new int[N][M];
			
			// 간선 정보 입력받기
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[b][a] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(graph[i][j] != 0) {
						dfs(graph, new int[] {i, j});
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
	
	private static void dfs(int graph[][], int[] pos) {
		int x = pos[0];
		int y = pos[1];
		graph[x][y] = 0; // 방문한 곳은 0으로 바꿔주기
		
		for (int i = 0; i < dx.length; i++) {
			int a = x+dx[i];
			int b = y+dy[i];
			
			if(a < 0 || b < 0 || a >= N || b >= M) continue;
			if(graph[a][b] != 0) {
				dfs(graph, new int[] {a, b});
			}
		}
	}
}
