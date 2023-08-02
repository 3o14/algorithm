import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int t = Integer.parseInt(st.nextToken());
    	for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int num = 1;
			int [][]arr = new int[N][N];
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			int x = 0, y = 0;
			int dir = 0; // 사방 탐색 인덱스 저장 변수
			while(num <= N*N) {
				arr[x][y] = num++;
				if(x+dx[dir] >= N || y+dy[dir] >= N || x+dx[dir] < 0 || y+dy[dir] < 0 || arr[x+dx[dir]][y+dy[dir]] != 0) {
					dir = (dir+1)%4;
				}
				x += dx[dir];
				y += dy[dir];
			}
			System.out.printf("#%d\n", tc+1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
    	}
	}
}