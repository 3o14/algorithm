# [D3] 재미있는 오셀로 게임 - 4615 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQmA4uK8ygDFAXj) 

### 성능 요약

메모리: 20,556 KB, 시간: 114 ms, 코드길이: 2,128 Bytes

### 제출 일자

2023-11-14 17:25

## 문제
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQmA4uK8ygDFAXj

![[Pasted image 20231114171824.png]]

오셀로 게임은 새로 돌을 놓았을때 사이(가로, 세로, 대각선)에 상대 돌이 있으면 자신의 돌로 바꾸며 자기 색깔의 돌을 늘려가는 게임이다. 주어진 입력대로 오셀로 게임을 끝냈을 경우 남은 흑돌과 백돌의 개수를 구하는 문제이다.

## 초기 아이디어
* 돌 색을 바꾸는 조건
* 1. 방금 놓은 돌을 기준으로 팔방 탐색을 해서 내 돌이 있을 경우
* 2. 그 사이에 있던 상대 돌을 전부 내 돌로 바꿈
돌을 놓을 곳을 입력받을 때마다 조건에 해당하는 돌들이 있는지 확인하고 반전시킨다.


## 전역 변수
* `N` - map의 크기
* `M` - 돌을 놓는 횟수
* `blackCnt`, `whiteCnt` - 흑돌의 개수와 백돌의 개수를 담을 변수
* `map` - map 정보를 담을 이차원 배열
* `dr`, `dc`, `BLACK`, `WHITE` - 팔방탐색 변수와 흑돌, 백돌을 구분할 상수

## 메소드
#### ⚡️ void main 
1. `map` 정보를 입력받는다.
2. `map`의 크기에 따라 중앙에 초기 세팅을 한다.
3. 돌을 두는 위치와 어떤 돌인지 입력받는다.
4. 입력받을 때마다 해당 위치에 돌을 두고 `change()` 함수를 호출한다.
5. 게임이 끝나면 `count()` 함수를 호출해서 각 돌의 개수를 센다.
6. 각 돌의 개수를 출력한다.

#### ⚡️ void change
1. 인자로 돌을 둔 위치와 돌의 색을 전달받는다.
2. 돌을 둔 위치를 기준으로 팔방 탐색을 한다.
3. 팔방 탐색에서 같은 방향으로 계속 탐색하면서 자기 돌이 또 있는지 검사한다.
	1. 종료 조건
		1. `map` 범위를 벗어날 경우
		2. 빈칸을 만난 경우
		3. 자기 색을 만난 경우 (`true` 저장하고 종료)
4. 위에서 true일 경우 다시 제자리로 돌아오면서 상대 돌이 있는지 검사한다.
	1. 종료 조건
		1. 원래 자리로 다 돌아왔을 경우
	2. 상대 돌을 만나면 자기 돌로 색을 바꾼다.

#### ⚡️ void count
1. `map`을 순회하며 흑돌과 백돌의 개수를 센다.

## 코드

```java
package swea;

/*
 *	돌 색을 바꾸는 조건
 *		1. 방금 놓은 돌을 기준으로 팔방 탐색을 해서 내 돌이 있을 경우
 *		2. 그 사이에 있던 상대 돌을 전부 내 돌로 바꿈
 * 
 * */

import java.io.*;
import java.util.*;

public class SWEA_4615_재미있는오셀로게임 {

	static int T, N, M, blackCnt, whiteCnt;
	static int map[][];
	static final int BLACK = 1, WHITE = 2;
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 }, dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

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

			map = new int[N + 1][N + 1];

			// 초기 세팅
			map[N / 2][N / 2] = WHITE;
			map[N / 2 + 1][N / 2] = BLACK;
			map[N / 2][N / 2 + 1] = BLACK;
			map[N / 2 + 1][N / 2 + 1] = WHITE;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());

				map[r][c] = color;
				change(r, c, color);
			}

			blackCnt = 0;
			whiteCnt = 0;
			count();

			sb.append(blackCnt).append(" ").append(whiteCnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void count() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == BLACK) {
					blackCnt++;
				} else if (map[i][j] == WHITE) {
					whiteCnt++;
				}

			}
		}

	}

	private static void change(int r, int c, int color) {
		int atomy = color == BLACK ? WHITE : BLACK;
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r;
			int nc = c;

			boolean thereIs = false;
			
			// 1. 방금 놓은 돌을 기준으로 팔방 탐색을 해서 내 돌이 있을 경우
			while (true) {
				nr += dr[i];
				nc += dc[i];

				if (nr > N || nr < 0 || nc > N || nc < 0)
					break;
				if(map[nr][nc] == 0) break;

				if (map[nr][nc] == color) {
					thereIs = true;
					break;
				}
			}
			// 2. 그 사이에 있던 상대 돌을 전부 내 돌로 바꿈
			while(thereIs) {
				if(nr == r && nc == c) break;
				if(map[nr][nc] == atomy) {
					map[nr][nc] = color;
				}
				nr -= dr[i];
				nc -= dc[i];
			}

		}
	}

}
```


> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do