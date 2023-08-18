import java.io.*;
import java.util.*;

public class Main {
	
	static boolean visit[][];
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int graph[][];
	static int dx[] = {1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < graph.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		
		bfs(0, 0);
		visit[0][0] = true;

		System.out.println(graph[N-1][M-1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int pos[] = queue.poll();
			int curA = pos[0];
			int curB = pos[1];
			
			for (int i = 0; i < dx.length; i++) {
				int a = pos[0] + dx[i];
				int b = pos[1] + dy[i];
				
				if(a >= N || b >= M || a < 0 || b < 0) continue;
				if(graph[a][b] != 0 && visit[a][b] == false) {
					graph[a][b] = graph[curA][curB] + 1;
					visit[a][b] = true;
					queue.offer(new int[] {a, b});
				}
			}
			
		}
		
	}
}
