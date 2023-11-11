
/*
 * 	1. N, M, R, C, L
 *	2. (R, C)에서 출발하여 L만큼 bfs 반복
 *	3. bfs 내부에서 해당 칸의 숫자(구조물 타입)에 따라 탐색 방향이 결정된다.
 *	4. 1:상하좌우, 2:상하, 3:좌우, 4:상우, 5:우하, 6:좌하, 7:좌상
 *	5. 탐색은 0이 아닌 곳만 가능하며 방문체크는 새로운 map에(footprint) 표시한다.
 *	5. 방문한 장소(탈주범이 있을 수 있는 위치)는 +1을 해서 표시한다.
 *
 *	구조물이 있어도 구조물 형태상 갈 수 없는 곳 예외처리하기
 *	갈 수 없는 경우	
 *	
 *	
 * */

import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, M, R, C, L;
	static int map[][], footprint[][];
	static int dirsR[][] = { {}, { -1, 0, 1, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 0, 1 }, { 0, 1 }, { 0, -1 } };
	static int dirsC[][] = { {}, { 0, 1, 0, -1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { -1, 0 } };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			footprint = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// input end

			solving(R, C);
//
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(footprint[i]));
//			}
//			
			ans = check();
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);

	}

	private static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(footprint[i][j] > 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static void solving(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		footprint[r][c]++;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
//			if(cnt > L) break;
			
			int[] pos = q.poll();
			int cr = pos[0];
			int cc = pos[1];
			int dirType = map[cr][cc]; // 구조물 타입
			
			if(footprint[cr][cc] >= L) break;
			
			for (int i = 0; i < dirsR[dirType].length; i++) {
				int nr = cr + dirsR[dirType][i]; // - -> 상, + -> 하 
				int nc = cc + dirsC[dirType][i]; // - -> 좌, + -> 우
				
				
				if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
				int nextType = map[nr][nc];
				if(map[nr][nc] == 0) continue;
				if(footprint[nr][nc] != 0) continue;
				
				/*
				 * dirsR[dirType][i] 가 음의 정수이면 위로 움직이고 양의 정수이면 아래로 움직인다
				 * dirsC[dirType][i] 가 음의 정수이면 좌로 움직이고 양의 정수이면 우로 움직인다
				 * 위로 움직일때 못가는 곳 -> 3, 4, 7
				 * 아래로 움직일때 못가는 곳 -> 3, 5, 6
				 * 좌로 움직일때 못가는 곳 -> 2, 6, 7 
				 * 우로 움직일때 못가는 곳 -> 2, 4, 5
				 * */
				
				if(dirsR[dirType][i] < 0) {
					if(nextType == 3 || nextType == 4 || nextType == 7) continue;
				}
				if(dirsR[dirType][i] > 0) {
					if(nextType == 3 || nextType == 5 || nextType == 6) continue;
				}
				if(dirsC[dirType][i] < 0) {
					if(nextType == 2 || nextType == 6 || nextType == 7) continue;
				}
				if(dirsC[dirType][i] > 0) {
					if(nextType == 2 || nextType == 4 || nextType == 5) continue;
				}
				
				if(map[nr][nc] > 0 || map[nr][nc] < 8) {
					footprint[nr][nc] = footprint[cr][cc] + 1;
					
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}

}
