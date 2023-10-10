import java.util.*;
import java.io.*;

class Solution {

	static int N, max, min;
	static boolean visit[];
	static int nums[], op[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			op = new int[4];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			// input end
			
			recur(0, 0);
			
			sb.append(max-min).append("\n");
		}

		System.out.println(sb);
	}
	private static void recur(int idx, int res) {
		if(idx >= N-1) {
			min = Math.min(min, res);
			max = Math.max(max, res);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				recur(idx+1, calc(idx, i, res));
				op[i]++;
			}
		}		
	}
	
	private static int calc(int idx, int op, int res) {
		if(idx == 0) {
			res = nums[idx];
		}
		
		switch(op) {
			case 0:
				res += nums[idx+1];
				break;
			case 1:
				res -= nums[idx+1];
				break;
			case 2:
				res *= nums[idx+1];
				break;
			case 3:
				res /= nums[idx+1];
				break;
		}
		return res;
	}

}
