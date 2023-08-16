import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, ans;
	public static int col[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		ans = 0;
		col = new int[N+1];
		
		queen(1);
		
		System.out.println(ans);
	}
	
	private static void queen(int row) {
		if(!isAvailable(row-1)) return;
		
		if(row > N) {
			ans++;
			return; 
		}
		
		for (int c = 1; c <= N; c++) {
			col[row] = c;
			queen(row+1);
		}
	}
	
	private static boolean isAvailable(int row) {
		for (int i = 1; i < row; i++) {
			if(col[row] == col[i] || row-i == Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		
		return true;
	}
}	