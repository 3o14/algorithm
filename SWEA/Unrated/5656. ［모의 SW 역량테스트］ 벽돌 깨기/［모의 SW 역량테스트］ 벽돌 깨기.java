import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, W, H, min;
	static int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
	static Stack<Integer> stack = new Stack<Integer>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int [][] map = new int[H][W];
			int remainCount = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) remainCount++;
				}
			}
			
			min = Integer.MAX_VALUE;

			go(0, remainCount, map);
			
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean go(int count, int remainCount, int[][] map) {
		if(remainCount == 0) {
			min = 0;
			return true;
			
		}
		if(count == N) {
			min = Math.min(min, remainCount);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		
		for (int c = 0; c < W; c++) {
			int r = 0;
			while(r<H && map[r][c] == 0) r++;
			if(r==H) continue;
			
			copy(map, newMap);
			int bCnt = boom(newMap, r, c);
			down(newMap);
			if(go(count+1, remainCount-bCnt, newMap)) return true;
		}

		return false;
	}
	
	private static int boom(int[][] map, int r, int c) {
		int count = 0;
		Queue<Point> q = new ArrayDeque<Point>();
		
		if(map[r][c] > 1) {
			q.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;
		++count;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < dc.length; i++) {
				int nr = p.r;
				int nc = p.c;
				
				for (int j = 1; j < p.cnt; j++) {
					nr += dr[i];
					nc += dc[i];
					
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) {
							q.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
						++count;
					}
				}
			}
		}
		
		return count;
	}

	private static void down(int[][] map) {
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(map[j][i] > 0) {
					stack.push(map[j][i]);
					map[j][i] = 0;
				}
			}
			int r = H-1;
			while(!stack.isEmpty()) map[r--][i] = stack.pop();
		}
	}
	
	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
	
	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
