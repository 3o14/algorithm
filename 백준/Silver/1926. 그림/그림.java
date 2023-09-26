import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static int [][] map;
	
	static private class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					int sum = bfs(i, j);
					if(sum == 1) {
						max = Math.max(max, sum);						
					} else {
						max = Math.max(max, sum-1);
					}
					cnt++;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
			System.out.println(0);
		} else {
			System.out.println(cnt);
			System.out.println(max);
		}
	}
	
	static int bfs(int x, int y) {
		int sum = 1;
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y));
		
		while(!que.isEmpty()) {
			Node curNode = que.poll();
	
			for (int i = 0; i < dx.length; i++) {
				int nextA = curNode.x + dx[i];
				int nextB = curNode.y + dy[i];
				
				if(nextA >= N || nextA < 0 || nextB >= M || nextB < 0) continue;
				if(map[nextA][nextB] == 0) continue;
				if(map[nextA][nextB] == 1) {
					map[nextA][nextB] = map[curNode.x][curNode.y] + 1;
					sum++;
					que.offer(new Node(nextA, nextB));
				}
					
			}
		}
		
		return sum;
	}
}
