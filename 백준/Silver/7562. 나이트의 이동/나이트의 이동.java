import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int graph[][];
	static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2}, dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
	static Queue<int[]> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			queue = new LinkedList<>();
			
			graph = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			bfs(startX, startY);

			st = new StringTokenizer(br.readLine());
			int endA = Integer.parseInt(st.nextToken());
			int endB = Integer.parseInt(st.nextToken());
	
			if(startX == endA && startY == endB) {
				sb.append(0).append("\n");
			} else {
				sb.append(graph[endA][endB]).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void bfs(int a, int b) {
		
		queue.add(new int[] {a, b});
		
		while(!queue.isEmpty()) {
			int pos[] = queue.poll();
			int curX = pos[0];
			int curY = pos[1];
			
			for (int i = 0; i < 8; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if(nextX >= N || nextX < 0 || nextY >= N || nextY < 0) continue;
				if(graph[nextX][nextY] == 0) {
					graph[nextX][nextY] = graph[curX][curY] + 1;
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
	}
}
