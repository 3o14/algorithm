import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] visited = new boolean[101][101];
	static int[] dx = {1, 0, -1, 0}; //오른쪽, 위, 왼쪽, 아래
	static int[] dy = {0, 1, 0, -1};
	static int[][] white;
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		white = new int[101][101];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//white[x][y] = 1;
			for (int j = 1; j <= 10; j++) { //영역을 전부 1로 처리하기!
				for(int k = 1; k <=10; k++) {
					white[x+k][y+j] = 1;
					//white[x+k][y] = 1;
				}
			}
		}
		
		for(int i = 1; i<101; i++) {
			for(int j = 1; j<101; j++) {
//				System.out.print(white[j][i]);
//				dfs(i,j);
				if(white[j][i] == 1) {
					count++;
				}
			}
//			System.out.println();
		}
		
//		for(int i = 1; i< 101; i++ ) {
//			for(int j = 0; j<101; j++) {
//				if(white[i][j] == 1 && !visited[i][j]) {
//					dfs()
//				}
//			}
//		}
		
		//count++;
		//dfs(1,1);
		
		System.out.println(count);
		
	}
	
//	public static void dfs(int x, int y) {
//		visited[x][y] = true;
//		for(int i = 0; i<4; i++) {
//			int cX = x + dx[i];
//			int cY = y + dy[i];
//			
//			if(cX < 1 || cY < 1 || cX > 101 || cY > 101) continue;
//			if(white[cX][cY] == 1 && !visited[cX][cY]) {
//				count++;
//				dfs(cX, cY);
//			}
//		}
//	}
}
