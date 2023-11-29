import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, ans, sumA, sumB;
	static int map[][];
	static boolean arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());

			map = new int[N + 1][N + 1];
			arr = new boolean[N+1];

			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			combi(0, 1);
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static void combi(int cnt, int start) {
		if (cnt == N / 2) {
			solving();
			return;
		}

		for (int i = start; i < N + 1; i++) {
			arr[i] = true;
			combi(cnt + 1, i + 1);
			arr[i] = false;
		}
	}

	private static void solving() {
		sumA = 0;
		sumB = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N+1; j++) {
				if(arr[i] && arr[j]) {
					sumA += map[i][j];
					sumA += map[j][i];
				} else if(!arr[i] && !arr[j]) {
					sumB += map[i][j];
					sumB += map[j][i];
				}
			}
		}
		
		int res = Math.abs(sumA - sumB);
		ans = Math.min(ans, res);
	}
}
