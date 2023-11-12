# [Unrated] [모의 SW 역량테스트] 핀볼 게임 - 5650 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo) 

### 성능 요약

메모리: 104,200 KB, 시간: 1,406 ms, 코드길이: 3,857 Bytes

### 제출 일자

2023-11-12 16:30


## 문제
위의 핀볼 게임판에서 블록과 부딪히거나 맵의 벽에 부딪힐 때마다 점수를 더한다. 맵의 모든 장소에서 시작해 보았을 때 가장 큰 점수를 구하는 문제이다. 게임은 블랙홀을 만나거나 출발했던 자리로 돌아오면 끝이 나고, 웜홀을 통과하여 다른 웜홀로 나올 때는 점수가 더해지지 않으며 방향은 유지된다.


## 초기 아이디어
 1. N은 map의 가로 세로 길이
 2. 입력
	 1. 블록 종류: 1,2,3,4,5
	 2. 웜홀: 6~10의 쌍
	 3. 블랙홀: -1
 3. 종료 조건: 핀볼이 출발 위치로 돌아오거나, 블랙홀에 빠질 경우
 4. 점수: 벽이나 블록에 부딪힌 횟수
 5. map의 모든 장소를 순회하며 게임을 실행해본다.
 6. 모든 출발위치에서 게임을 해 보았을 때 가장 높게 나온 점수를 출력하기
 7. 출발 방향은 네 가지 모두 다 반복문으로 실행해보기


## 전역 변수
* `T`, `N` - 테스트케이스 개수, map의 크기
* `ans` - 정답을 담을 변수
* `map` - map 정보를 담을 이차원 배열
* `dr`, `dc` - 방향 정보가 담긴 이차원 배열
* `wormholes` - 웜홀 정보를 담을 리스트

## 클래스
#### 🗑️ Pin
* `r`, `c` - 핀의 위치
* `dir` - 핀의 방향
* `score` - 점수

#### 🗑️ Hole
* `r`, `c` - 웜홀의 위치
* `holeNum` - 웜홀에 적힌 숫자


## 메소드
#### ⚡️ void main()
1. `N`의 크기만큼 `map`을 생성하고 `map`에 정보를 입력한다.
2. `wormholes` 리스트를 생성하고 웜홀을 발견할 때마다 입력한다.
3. 모든 위치에서 게임을 시작해 보았을 때 점수가 가장 높은 값을 출력해야 하므로 2중 for문으로 반복하며 `solving()` 함수를 호출한다.
5. `solving()`의 반환값인 `score` 중에서 `max`값을 찾아 `ans` 변수에 담고 출력한다.

#### ⚡️ int solving()
1. 매개 변수로 출발 위치와 방향을 입력받는다.
2. 게임을 진행할 `pin`을 생성하고 while문으로 반복하며 핀볼 게임을 진행한다.
3. while문
	1. `nr`, `nc`에 `pin`의 `dir`을 토대로 다음 칸의 위치를 받는다.
	2. 다음 칸이
		1. 벽에 부딪힐 경우 방향을 반대로 바꾸고 `score`에 1을 더한다.
		2. 출발 위치로 되돌아갈 경우 `break` 한다.
		3. 0일 경우 다음 칸으로 넘어간다.
		4. 블럭이 있을 경우 `goBlocks()` 함수를 호출한다.
		5. 웜홀이 있을 경우 `goWormhole()` 함수를 호출한다.
		6. 블랙홀이 있을 경우 `break` 한다.
	
#### ⚡️ Pin goWormhole()
1. `wormholes` 리스트 안에서 지금 만난 웜홀 숫자와 같은 웜홀을 찾는다.
2. 숫자는 같으면서 위치는 다른 웜홀을 만나면 그곳으로 이동한다.

#### ⚡️ Pin goBlocks()
1. 블럭 종류에 따라 `dir` 방향을 적절히 바꿔준다.
2. 적절히 바꾼 `dir`을 담은 새 `pin` 객체를 반환한다.
3. 이때 블럭에 부딪혔으므로 `score`에 1을 더해서 반환한다.

## 코드
```java
import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, ans;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 }; // 0: 상, 1: 우, 2: 하, 3: 좌
	static ArrayList<Hole> wormholes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = sc.nextInt();
			map = new int[N][N];
			wormholes = new ArrayList<>();
			ans = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > 5 && map[i][j] < 11) {
						wormholes.add(new Hole(i, j, map[i][j]));
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int dir = 0; dir < 4; dir++) {
							int score = solving(i, j, dir);
							ans = Math.max(ans, score);
						}
					}
				}
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);

	}

	private static int solving(int startR, int startC, int startDir) {
		Pin pin = new Pin(startR, startC, startDir, 0);
		
		while (true) {
			// 다음칸 좌표 얻기
			int nr = pin.r + dr[pin.dir];
			int nc = pin.c + dc[pin.dir];

			// 맵의 벽에 부딪힐 때
			if (nr >= N || nr < 0 || nc >= N || nc < 0) {
				int dir = pin.dir;
				if (dir == 0 || dir == 1) {
					dir += 2;
				} else if (dir == 2 || dir == 3) {
					dir -= 2;
				}
				pin.dir = dir;
				pin.r = nr;
				pin.c = nc;
				pin.score++;
			} else {

				// 다음칸이 무엇인지에 따라서 행동요령이 달라짐
				int nextBlock = map[nr][nc];

				// 1. 출발위치로 돌아갔을때
				if (nr == startR && nc == startC) {
					break;
				}

				// 2. 아무것도 없을때 -> 그냥 통과하기
				if (nextBlock == 0) {
					pin.r = nr;
					pin.c = nc;
				}

				// 3. 블럭이 있을때
				if (nextBlock > 0 && nextBlock < 6) {
					pin = goBlocks(nextBlock, nr, nc, pin.dir, pin.score);
				}

				// 4. 웜홀이 있을때
				if (nextBlock > 5 && nextBlock < 11) {
					pin = goWormhole(nextBlock, nr, nc, pin.dir, pin.score);
				}

				// 5. 블랙홀이 있을때
				if (nextBlock == -1) {
					break;
				}

			}

		}

		return pin.score;
	}

	private static Pin goWormhole(int wormholeNum, int nr, int nc, int dir, int score) {
		// wormholes리스트에서 womeholeNum과 같은 번호이면서 다른 좌표의 hole을 얻어온다.
		// 그 좌표로 이동하기
		for (Hole hole : wormholes) {
			if (hole.holeNum == wormholeNum) {
				if (hole.r != nr || hole.c != nc) {
					nr = hole.r;
					nc = hole.c;
					break;
				}
			}
		}
		return new Pin(nr, nc, dir, score);
	}

	private static Pin goBlocks(int nextBlockNum, int nr, int nc, int dir, int score) {
		// [dir 방향] 0-상, 1-오른, 2-아래, 3-왼
		switch (nextBlockNum) {
		case 1:
			if (dir == 0 || dir == 1) {
				dir += 2;
			} else if (dir == 2 || dir == 3) {
				dir = dir == 2 ? 1 : 0;
			}
			break;
		case 2:
			if (dir == 0 || dir == 3) {
				dir = dir == 0 ? 1 : 2;
			} else if (dir == 1 || dir == 2) {
				dir = dir == 1 ? 3 : 0;
			}
			break;
		case 3:
			if (dir == 0 || dir == 1) {
				dir = dir == 0 ? 3 : 2;
			} else if (dir == 2 || dir == 3) {
				dir -= 2;
			}
			break;
		case 4:
			if (dir == 0 || dir == 1) {
				dir = dir == 0 ? 2 : 0;
			} else if (dir == 2 || dir == 3) {
				dir = dir == 2 ? 3 : 1;
			}
			break;
		case 5:
			if (dir == 0 || dir == 1) {
				dir += 2;
			} else if (dir == 2 || dir == 3) {
				dir -= 2;
			}
			break;
		}

		return new Pin(nr, nc, dir, score + 1);
	}

	private static class Pin {
		int r;
		int c;
		int dir;
		int score;

		public Pin(int r, int c, int dir, int score) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Pin [r=" + r + ", c=" + c + ", dir=" + dir + ", score=" + score + "]";
		}
	}

	private static class Hole {
		int r;
		int c;
		int holeNum;

		public Hole(int r, int c, int holeNum) {
			super();
			this.r = r;
			this.c = c;
			this.holeNum = holeNum;
		}

		@Override
		public String toString() {
			return "Hole [r=" + r + ", c=" + c + ", holeNum=" + holeNum + "]";
		}

	}

}
```


> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do