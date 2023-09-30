import java.util.*;
import java.io.*;

public class Main {	
	
	static int R, C, ans = Integer.MAX_VALUE;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static Character map[][];
	static Queue<Node> sQue = new LinkedList<>(); // 고슴도치 큐
	static Queue<Node> wQue = new LinkedList<>(); // 물 큐
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new Character[R][C];
		
		int sR = 0, sC = 0;
		int wR = 0, wC = 0;
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				
				// 지도 정보를 입력받을 때 고슴도치나 물을 만나면 바로 큐에 넣어주기
				if(map[i][j].equals('S')) {
					sQue.add(new Node(i, j, 0));
				} else if(map[i][j].equals('*')) {
					wQue.add(new Node(i, j, 0));
				}
			}
		}
		// input end

		bfs();
		
		System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
	}
	
	private static void bfs() {

		while(!sQue.isEmpty()) { // 고슴도치 큐가 빌 때까지 반복
			
			// 물 사방 탐색
			
			int w_size = wQue.size();
			for (int i = 0; i < w_size; i++) {
				Node cur = wQue.poll();
				
				for (int j = 0; j < dx.length; j++) {
					int nA = cur.x + dx[j];
					int nB = cur.y + dy[j];
					
					if(nA >= R || nA < 0 || nB >= C || nB < 0) continue;
					if(map[nA][nB] == '.') {
						map[nA][nB] = '*';
						wQue.add(new Node(nA, nB, 0));
					}
				}
			}
			
			
			// 고슴도치 사방 탐색
			int s_size = sQue.size();
			for (int i = 0; i < s_size; i++) {
				Node cur = sQue.poll();
				
				for (int j = 0; j < dx.length; j++) {
					int nA = cur.x + dx[j];
					int nB = cur.y + dy[j];
					
					if(nA >= R || nA < 0 || nB >= C || nB < 0) continue;
					if(map[nA][nB] == '.') {
						map[nA][nB] = 'S';
						sQue.add(new Node(nA, nB, cur.cnt+1));
					}
					if(map[nA][nB] == 'D') {
						ans = Math.min(ans, cur.cnt+1);
						return;
					}
				}
			}
			
			
		}
		
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
