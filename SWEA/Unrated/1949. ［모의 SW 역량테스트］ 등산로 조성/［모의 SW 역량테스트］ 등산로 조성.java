import java.util.*;
import java.io.*;

public class Solution {

	static int T, N, K, top, max;
	static int dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 };
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			top = Integer.MIN_VALUE;

			map = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]);
				}
			}

			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (top != map[i][j])
						continue;

					visit[i][j] = true;
					dfs(i, j, 1, map[i][j], K);
					visit[i][j] = false;
				}
			}

			sb.append(max).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int r, int c, int length, int height, int k) {
        max = Math.max(length, max);
 
        for (int i = 0; i < 4; i++) {
            int nowR = dr[i] + r;
            int nowC = dc[i] + c;
 
            if (nowR >= N || nowR < 0 || nowC >= N || nowC < 0) continue;
            if (visit[nowR][nowC]) continue;
 
            if (k == 0) {
                if (map[nowR][nowC] < height) {
                    visit[nowR][nowC] = true;
                    dfs(nowR, nowC, length + 1, map[nowR][nowC], k);
                    visit[nowR][nowC] = false;
                }
            } else {
                if (map[nowR][nowC] < height) {
                    visit[nowR][nowC] = true;
                    dfs(nowR, nowC, length + 1, map[nowR][nowC], k);
                    visit[nowR][nowC] = false;
                } else if ((map[nowR][nowC] - k) < height) {
                    visit[nowR][nowC] = true;
                    dfs(nowR, nowC, length + 1, height - 1, 0);
                    visit[nowR][nowC] = false;
                }
            }
 
        }
 
    }

}
