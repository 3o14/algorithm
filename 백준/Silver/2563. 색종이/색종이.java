import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[][] = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        for (int r = 100-(10+b); r < 100-b; r++) {
				for (int c = a; c < 10+a; c++) {
					map[r][c] = 1;
				}	
			}
        }
        
        int ans = 0;
        for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					ans += 1;
				}
			}
		}
        
        System.out.println(ans);
    }
}