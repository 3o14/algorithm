import java.io.*;
import java.util.*;

public class Main {
	
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static int graph[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		visit = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		
		visit = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}

	// dfs -> 재귀
	private static void dfs(int v) {
		visit[v] = true;
		sb.append(v).append(" ");
		
		for (int i = 1; i < graph.length; i++) {
			if(graph[v][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
	
	// bfs -> 큐
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visit[v] = true;
		queue.offer(v);
		sb.append(v).append(" ");
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 1; i < graph.length; i++) {
				if(graph[n][i] == 1 && visit[i] == false) {
					visit[i] = true;
					queue.offer(i);
					sb.append(i).append(" ");
				}
			}
		}
		
	}
}
