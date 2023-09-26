import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, ans;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static int map[][];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Node robot = new Node(x, y, d);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(map[robot.x][robot.y] == 0) {
				map[robot.x][robot.y] = -1;
				ans++;
			}
			
			
			if(check(robot.x, robot.y)) {
				for (int j2 = 5; j2 > 0; j2--) {
					
					int nd = robot.d == 0 ? 3 : robot.d - 1;
					robot.d = nd;
					int nx = robot.x + dx[nd];
					int ny = robot.y + dy[nd];
					
					if(map[nx][ny] == -1) {
						continue;
					}
					if(map[nx][ny] == 0) {
						robot.x = nx;
						robot.y = ny;
						robot.d = nd;
						break;
					}
					
				}
			} else {
				int nd = (robot.d + 2) % 4; // 후진
				
				int nx = robot.x+dx[nd];
				int ny = robot.y+dy[nd];
				if(nx >= N || nx < 0 || ny >= M || ny < 0) break;
				if(map[nx][ny] == 1) break;
				if(map[nx][ny] == 0 || map[nx][ny] == -1) {
					robot.x = nx;
					robot.y = ny;
				}
				
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int x, int y) {
		for (int j = dx.length-1; j >= 0; j--) {
			int nx = x + dx[j];
			int ny = y + dy[j];
			
			if(nx >= N || nx < 0 || ny >= M || ny < 0) break;
			if(map[nx][ny] == 0) {
				return true;
			}
		}
		
		return false;
	}

	static private class Node {
		int x, y;
		int d;
		
		Node(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.d = direction;
		}
	}
}
