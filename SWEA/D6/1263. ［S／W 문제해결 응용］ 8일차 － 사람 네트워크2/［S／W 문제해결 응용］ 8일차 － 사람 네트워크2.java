import java.util.*;
import java.io.*;

class Solution {

	static int D[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			D = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(i == j) {
						st.nextToken();
						D[i][j] = 0;
					} else {
						int temp = Integer.parseInt(st.nextToken());
						D[i][j] = temp == 0 ? N*(N+1)/2 : temp;
					}
				}
			}
			
			floyd(D);

			int min = N*(N-1)/2 ;
			
			for (int i = 0; i < D.length; i++) {
				int cc = 0;
				for (int j = 0; j < D.length; j++) {
					if(i == j) continue;
					cc += D[i][j];
				}
				min = Math.min(cc, min);
			}
			
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void floyd(int[][] D) {
		// TODO Auto-generated method stub
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i == k) continue;
				for (int j = 0; j < N; j++) {
					D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
				}
			}
		}
	}

}
