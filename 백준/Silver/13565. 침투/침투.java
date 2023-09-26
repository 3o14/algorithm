import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N, ans;
	static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visit = new boolean[M][N];
		ans = -1;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(map[0][i] == 0) {
				dfs(0, i);
			}
		}
		if(ans >= 0) {
			System.out.println("YES");
 		} else if(ans == -1) {
 			System.out.println("NO");
 		}
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		if(x == M-1 && map[x][y] == 0) {
			ans += 1;
			return;
		}
		
		for (int i = 0; i < dx.length; i++) {
			int nextA = x + dx[i];
			int nextB = y + dy[i];
			
			if(nextA >= M || nextA < 0 || nextB >= N || nextB < 0) continue;
			if(visit[nextA][nextB] == true) continue;
			if(visit[nextA][nextB] == false && map[nextA][nextB] == 0) {
				dfs(nextA, nextB);
			}
		}
	}
}
