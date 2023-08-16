import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M, arr[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		backtrack(0, 1);
		
		System.out.println(sb);
	}
	
	private static void backtrack(int cnt, int idx) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			arr[cnt] = i; 
			backtrack(cnt+1, i);
		}
	}
}	