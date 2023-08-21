import java.io.*;
import java.util.*;


class Solution {
	static int T, N, M, K, start, size_N, size_M;
	static int graph[][];
	static boolean visited[][];
	static PriorityQueue<int[]> pq;
	static int dr[] = {1, 0, -1, 0}, dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			start = K/2+1;
			size_N = N+K+1;
			size_M = M+K+1;
			visited = new boolean[size_N][size_M];
			pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o2[2], o1[2]));
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int x = Integer.parseInt(st.nextToken());
					if(x != 0) {
						visited[i+start][j+start] = true;
						pq.offer(new int[] {i+start, j+start, x, x});
					}
				}
			}
			
			bfs();
			sb.append("#"+tc+" ").append(pq.size()).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	private static void bfs() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		while(K--> 0) {
			int ny, nx;
			
			while(!pq.isEmpty()) {
				int[] cell = pq.poll();
				cell[3]--;
				
				if(cell[3] < 0) {
					for(int d=0; d<4; d++) {
						ny = cell[0] + dr[d];
						nx = cell[1] + dc[d];
						
						if(visited[ny][nx]) continue;
						
						visited[ny][nx] = true;
						
						queue.offer(new int[] {ny, nx, cell[2], cell[2]});
					}
				}
		
				if(cell[2]+cell[3] == 0) continue;
				queue.offer(cell);
			}
			
			while(!queue.isEmpty()) pq.offer(queue.poll());
		}
	}
}
