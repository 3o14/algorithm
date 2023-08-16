import java.util.*;
import java.io.*;

public class Main {
	
	static int map[][];
	static int N, size;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb);
	}
	
	private static void quadTree(int x, int y, int size) {
		if(check(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		
		int newSize = size/2;
		
		sb.append("(");
		quadTree(x, y, newSize);
		quadTree(x, y+newSize, newSize);
		quadTree(x+newSize, y, newSize);
		quadTree(x+newSize, y+newSize, newSize);
		
		sb.append(")");
	}
	
	private static boolean check(int x, int y, int size) {
		int temp = map[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(map[i][j]!=temp)
					return false;
			}
		}
		return true;
	}
}