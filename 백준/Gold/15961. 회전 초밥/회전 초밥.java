import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list = new int[N+k-1];
		int[] check = new int[d+1];
	
		check[c] = 1; // 쿠폰 초밥 이미 먹음
		
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k-1; i++) {
			list[N++] = list[i];
		}
		
		// 입력 완료
		
		int cnt = 1; // 초밥 종류 세기
		int start = 0;
		for (int i = 0; i < k; i++) {
			if(check[list[i]] == 0) cnt++;
			check[list[i]] += 1;
		}
		
		int end = k;
		int result = cnt;
		
		for (int i = end; i < list.length; i++) {
			check[list[start]] -= 1;
			
			if(check[list[start]] == 0) {
				result--;
			}
			
			if(check[list[i]] == 0) {
				result++;
			}
			check[list[i]] += 1;
			
			cnt = Math.max(result, cnt);
			start++;
		}
		
		System.out.println(cnt);
	}
	
}
