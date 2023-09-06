import java.io.*;
import java.util.*;

public class Main {

	static char graph[][];
	static boolean visit[][];
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static int N, M;
	
	public static class Node {
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine(); 
			for (int j = 0; j < M; j++) {
				graph[i][j] = s.charAt(j);;
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(graph[i][j] == 'L') {
					visit = new boolean[N][M];
					int len = bfs(i, j);
					max = Math.max(len, max);
				}
			}
		}

		System.out.println(max);
	}
	
	static int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0));
		visit[x][y] = true;
		
		int len = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nextA = node.x + dx[i];
				int nextB = node.y + dy[i];
				
				if(nextA >= N || nextA < 0 || nextB >= M || nextB < 0) continue;
				if(graph[nextA][nextB] == 'L' && visit[nextA][nextB] == false) {
					queue.offer(new Node(nextA, nextB, node.cost + 1));
					len = Math.max(len, node.cost+1);
					visit[nextA][nextB] = true;
				}
			}
		}
		
		return len;
	}
}
