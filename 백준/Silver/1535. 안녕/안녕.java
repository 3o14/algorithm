import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int W[] = new int[N+1]; // 물건의 무게들 저장한 배열
		int V[] = new int[N+1]; // 물건의 가치들 저장한 배열
		int K[][] = new int[N+1][101]; // 최적해 저장할 이차원 배열
		
		st = new StringTokenizer(br.readLine()); 
		for (int i = 1; i <= N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 물건 i
			for (int w = 1; w <= 100; w++) { // 용량 w 1부터 100
				if(W[i] > w) { // 물건 i의 용량이 현재 용량보다 클 경우 (담을수 없는 경우) 
					K[i][w] = K[i-1][w];
				} else { // (담을수 있는 경우)
					K[i][w] = Math.max(V[i] + K[i-1][w-W[i]], K[i-1][w]);
				}
			}
		}
		
		System.out.println(K[N][99]);
	}

}
