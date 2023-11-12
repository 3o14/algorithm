/*
 * 
 * 	1. N은 map의 가로 세로 길이
 * 	2. 입력
 * 		블록 종류: 1,2,3,4,5
 * 		웜홀: 6~10의 쌍
 * 		블랙홀: -1
 * 	3. 종료 조건: 핀볼이 출발 위치로 돌아오거나, 블랙홀에 빠질 경우
 * 	4. 점수: 벽이나 블록에 부딪힌 횟수
 * 	5. map의 모든 장소를 순회하며 게임을 실행해본다.
 * 	6. 모든 출발위치에서 게임을 해 보았을 때 가장 높게 나온 점수를 출력하기
 * 	7. 출발 방향은 네 가지 모두 다 반복문으로 실행해보기
 * 
 * */

import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, ans;
	static int startR, startC;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 }; // 0: 상, 1: 우, 2: 하, 3: 좌
	static ArrayList<Hole> wormholes;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
//		StringTokenizer st;

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = sc.nextInt();
			map = new int[N][N];
			wormholes = new ArrayList<>();
			ans = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > 5 && map[i][j] < 11) {
						wormholes.add(new Hole(i, j, map[i][j]));
					}
				}
			}
			
//			for(Hole hole: wormholes) {
//				System.out.println(hole.toString());
//			}

			// Input End

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int dir = 0; dir < 4; dir++) {
							startR = i;
							startC = j;
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

	private static int solving(int i, int j, int startDir) {
		Pin pin = new Pin(i, j, startDir, 0);

		int c = 0;
		while (true) {
			// 다음칸 좌표 얻기
			int nr = pin.r + dr[pin.dir];
			int nc = pin.c + dc[pin.dir];

			// 6. 맵의 벽에 부딪힐 때
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

				// 5. 출발위치로 돌아갔을때
				if (nr == startR && nc == startC) {
					break;
				}

				// 1. 아무것도 없을때 -> 그냥 통과하기
				if (nextBlock == 0) {
					pin.r = nr;
					pin.c = nc;
				}

				// 2. 블럭이 있을때
				if (nextBlock > 0 && nextBlock < 6) {
					pin = goBlocks(nextBlock, nr, nc, pin.dir, pin.score);
				}

				// 3. 웜홀이 있을때
				if (nextBlock > 5 && nextBlock < 11) {
					pin = goWormhole(nextBlock, nr, nc, pin.dir, pin.score);
				}

				// 4. 블랙홀이 있을때
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
//			System.out.println(hole.holeNum + " " + hole.r + " " + hole.r);
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
