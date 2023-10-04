import java.util.*;
import java.io.*;

public class Main {

	static int N, dx[] = {1, 0, -1, 0}, dy[] = {0, -1, 0, 1};
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		kubetsu();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] >= 2 && check(i, j)) { // 테두리일 경우
					visit = new boolean[N][N];
					int ans = bfs(i, j, 0);
					if(ans == -1) continue;
					min = Math.min(min, ans);
				}
			}
		}
		
		System.out.println(min-1);
	}

	private static void kubetsu() {
		visit = new boolean[N][N];
		int idx = 2;
	
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(visit[i][j] == false && map[i][j] == 1) {
					map[i][j] = idx;
					visit[i][j] = true;
					
					Queue<int[]> que = new LinkedList<>();
					que.offer(new int[] {i, j});
					while(!que.isEmpty()) {
						int[] pos = que.poll();
						int curA = pos[0];
						int curB = pos[1];
						
						for (int k = 0; k < dx.length; k++) {
							int nx = curA + dx[k];
							int ny = curB + dy[k];
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if(visit[nx][ny] == false && map[nx][ny] == 1) {
								que.offer(new int[] {nx, ny});
								visit[nx][ny] = true;
								map[nx][ny] = idx;
							}
						}
					}
					idx++;
				}
			}
		}
	}
	
	private static int bfs(int i, int j, int cnt) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(i, j, cnt));
		visit[i][j] = true;
		int curIdx = map[i][j];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(map[cur.x][cur.y] != 0 && map[cur.x][cur.y] != curIdx) {
				return cur.cnt;
			}
			
			for (int k = 0; k < dx.length; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy[k];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // outofindex
				if(map[nx][ny] == curIdx || visit[nx][ny]) continue; // 같은 섬일 경우 or 기방문소
				visit[nx][ny] = true;
				q.offer(new Node(nx, ny, cur.cnt+1));
			}
		}
		
		return -1;
	}


	private static boolean check(int i, int j) {
		for (int j2 = 0; j2 < dx.length; j2++) {
			int nx = i + dx[j2];
			int ny = j + dy[j2];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == 0) {
				return true;
			}
		}
		
		return false;
	}

	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
