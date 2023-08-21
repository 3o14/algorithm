import java.io.*;
import java.util.*;


public class Main {
	static int cnt = 0, N;
	static int dy[] = {1, 0, -1, 0}, dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		int graph[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(graph[i][j] != 0) {
					cnt = 0;
					dfs(graph, new int[] {i, j}); // 현재 위치가 0이 아닐 경우 탐색 시작
					list.add(cnt);
				}
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(Integer i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int graph[][], int[] pos) {
		int x = pos[0];
		int y = pos[1];
		graph[x][y] = 0; // 방문한 곳은 0으로 바꿔주기
		cnt++; // 현재 단지의 집의 수 + 1
		
		for (int i = 0; i < dx.length; i++) {
			int a = x+dx[i];
			int b = y+dy[i];
			
			if(a < 0 || b < 0 || a >= N || b >= N) continue;
			if(graph[a][b] != 0) {
				dfs(graph, new int[] {a, b});
			}
		}
		
	}
}
