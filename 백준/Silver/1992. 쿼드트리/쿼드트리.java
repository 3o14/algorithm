
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] video;
	static String result = "";
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		video = new int[n][n];
		boolean flag = false;
		for(int i = 0; i<n; i++) {
			String[] token = br.readLine().split("");
			for(int j = 0; j<n; j++) {
				video[i][j] = Integer.parseInt(token[j]);
				if(video[i][j] == 1) flag = true;
			}
		}
		
		if(!flag) System.out.println(0);
		else {
			//분할~~
//			result = "(";
			division(0, 0, n);
//			result += ")";
		}
		System.out.println(result);
	}
	public static void division(int r, int c, int size) {
		int sum = 0;
		for(int i = r; i<r+size; i++) {
			for(int j = c; j<c+size; j++) {
				sum += video[i][j];
			}
		}
		
		if(sum == 0) { // 0으로 같음 굿 (기저조검)
			result += 0;
		}
		else if(sum == size*size) { // 모두 1로 같음 굿
			result += 1;
		}
		else { // 다름
			result += "(";
			division(r, c, size/2); // 제1사분면
			division(r, c + size/2, size/2); // 제2사분면
			division(r+size/2, c, size/2); //제3사분면
			division(r+size/2, c+size/2, size/2); //제4사분면
			result += ")";
		}
	}
}
