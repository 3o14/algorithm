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

		int c = 0;
		while (true) {
			int nr = pin.r + dr[pin.dir];
			int nc = pin.c + dc[pin.dir];

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

				int nextBlock = map[nr][nc];

				if (nr == startR && nc == startC) {
					break;
				}

				if (nextBlock == 0) {
					pin.r = nr;
					pin.c = nc;
				}

				if (nextBlock > 0 && nextBlock < 6) {
					pin = goBlocks(nextBlock, nr, nc, pin.dir, pin.score);
				}

				if (nextBlock > 5 && nextBlock < 11) {
					pin = goWormhole(nextBlock, nr, nc, pin.dir, pin.score);
				}

				if (nextBlock == -1) {
					break;
				}

			}

		}

		return pin.score;
	}

	private static Pin goWormhole(int wormholeNum, int nr, int nc, int dir, int score) {
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
