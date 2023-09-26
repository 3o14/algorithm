//조합으로 모든 경우의 수 구함

//B보다 클 경우 ans에 저장
//Math.min(min, ans)로 최솟값 찾기

import java.io.*;
import java.util.*;

class Solution {

	static int N, B, min, arr[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			setTower(0, 0);
			int ans = min - B;

			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

	private static void setTower(int idx, int sum) {
		if (sum >= B) {
			min = Math.min(sum, min);
			return;
		}
		if (idx >= N) {
			// 부분집합으로 만들 수 있는 키 중에서 선반의 높이 이상이면서
			// 그 중에서 가장 작은 높이를 구한다.
			if (sum >= B) {
				min = Math.min(min, sum);
			}
			return;
		}

		setTower(idx + 1, sum + arr[idx]);
		setTower(idx + 1, sum);
	}
}
