import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, ans, diff, sumA, sumB;
	static int map[][], arrA[], arrB[], nums[];
	static boolean visit[][], select[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			visit = new boolean[N+1][N+1];
			
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			arrA = new int[N/2];
			arrB = new int[N/2];
			ans = Integer.MAX_VALUE;
			combi(0, 1);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void combi(int cnt, int start) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(arr)); // arr:A의 재료 조합
			solving();
			return;
		}
		
		for (int i = start; i < N+1; i++) {
			arrA[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	private static void solving() {
		
		// arrA로 순열 구해서 나온 맛 전부 합하기 -> sumA
		nums = new int[2];
		select = new boolean[N/2];
		sumA = 0;
		permA(0);
		
		boolean temp[] = new boolean[N+1];
		for (int i = 0; i < arrA.length; i++) {
			temp[arrA[i]] = true;
		}
		
		int idx = 0;
		for (int i = 1; i < N+1; i++) {
			if(!temp[i]) {
				arrB[idx++] = i;
			}
		}
		sumB = 0;
		permB(0);

		diff = Math.abs(sumA - sumB);
		ans = Math.min(ans, diff);
	}
	
	private static void permA(int cnt) {
		if(cnt == 2) {
			sumA += map[nums[0]][nums[1]];
			return;
		}
		
		for (int i = 0; i < arrA.length; i++) {
			if(select[i]) continue;
			nums[cnt] = arrA[i];
			
			select[i] = true;
			permA(cnt+1);
			select[i] = false;
		}
	}

	private static void permB(int cnt) {
		if(cnt == 2) {
			sumB += map[nums[0]][nums[1]];
			return;
		}
		
		for (int i = 0; i < arrB.length; i++) {
			if(select[i]) continue;
			nums[cnt] = arrB[i];
			
			select[i] = true;
			permB(cnt+1);
			select[i] = false;
		}
	}
}
