import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] white;
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		white = new int[101][101];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			

			for (int j = 1; j <= 10; j++) { //영역을 전부 1로 처리하기!
				for(int k = 1; k <=10; k++) {
					if(white[x+k][y+j] == 1) continue;
					white[x+k][y+j] = 1;
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
}
