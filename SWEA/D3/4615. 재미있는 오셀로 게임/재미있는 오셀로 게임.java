import java.io.*;
import java.util.*;

public class Solution {

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
