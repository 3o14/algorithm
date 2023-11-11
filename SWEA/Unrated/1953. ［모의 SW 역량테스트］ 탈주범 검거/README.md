# [Unrated] [모의 SW 역량테스트] 탈주범 검거 - 1953 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq) 

### 성능 요약

메모리: 24,252 KB, 시간: 148 ms, 코드길이: 3,731 Bytes

### 제출 일자

2023-11-11 15:54



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do

## 문제 설명
위의 구조물로 이루어진 지하터널에서 탈주범이 도망칠 수 있는 위치의 개수를 세는 문제

## 초기 아이디어
1. N, M, R, C, L
2. (R, C)에서 출발하여 L만큼 bfs 반복
3. bfs 내부에서 해당 칸의 숫자(구조물 타입)에 따라 탐색 방향이 결정된다.
4. 1:상하좌우, 2:상하, 3:좌우, 4:상우, 5:우하, 6:좌하, 7:좌상
5. 탐색은 0이 아닌 곳만 가능하며 방문체크는 새로운 map에(footprint) 표시한다.
6. 방문한 장소(탈주범이 있을 수 있는 위치)는 +1을 해서 표시한다.

구조물이 있어도 구조물 형태상 갈 수 없는 곳 예외처리하기

## 전역 변수
* `N`, `M` : map의 가로, 세로 크기
* `R`, `C` : 탈주범의 탈주 시작 위치
* `L` : 탈주한 시간
* `map` : 지하 터널 정보를 담을 이차원 배열
* `footprint` : 탈주범이 이동한 위치를 저장할 이차원 배열
* `dirsR`, `dirsC` : 1부터 7까지의 구조물의 이동 방향을 저장할 이차원 배열
* `ans` : 답을 저장할 변수

## 메소드

#### ⚡️ void main 
1. 주어진 정보를 입력받는다.
2. map과 footprint를 생성하고 지하터널 지하 정보를 입력받는다.
3. `solving()` 함수를 호출하여 bfs를 수행한다.
4. `check()` 함수를 호출하여 정답을 ans에 저장한다.
5. 답을 출력한다.

#### ⚡️ void solving
1. 시작 위치를 큐에 넣는다.
2. 현재 위치를 footprint 배열에 표시한다.
3. 큐의 요소를 하나씩 꺼내며 bfs를 수행한다.
4. 예외처리
	1. 구조물이 없는 곳
	2. map의 범위(N, M)를 벗어나는 곳
	3. 이미 방문한 곳
	4. 구조물이 있지만 형태상 갈 수 없는 곳
		* dirsR[dirType][i] 가 음의 정수이면 위로 움직이고 양의 정수이면 아래로 움직인다
		* dirsC[dirType][i] 가 음의 정수이면 좌로 움직이고 양의 정수이면 우로 움직인다
		* 위로 움직일때 못가는 곳 -> 3, 4, 7
		* 아래로 움직일때 못가는 곳 -> 3, 5, 6
		* 좌로 움직일때 못가는 곳 -> 2, 6, 7
		* 우로 움직일때 못가는 곳 -> 2, 4, 5

#### ⚡️ void check
1. footprint를 순회하며 0보다 큰 값이 있는 곳의 개수를 센다


## 코드
```java
package swea;

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

public class SWEA_1953_탈주범검거 {

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
		while(!q.isEmpty()) {
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

```