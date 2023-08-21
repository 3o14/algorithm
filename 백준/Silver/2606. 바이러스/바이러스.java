import java.io.*;
import java.util.*;


public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int graph[][] = new int[N+1][N+1];
		boolean visit[] = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		dfs(graph, 1, visit);
		
		System.out.println(cnt-1);
	}
	
	private static void dfs(int graph[][], int node, boolean visit[]) {
		visit[node] = true;
		cnt++;
		
		for (int i = 1; i < graph.length; i++) {
			if (graph[node][i] != 0 && visit[i] == false) {
				dfs(graph, i, visit);
			}
		}
		
	}
}
