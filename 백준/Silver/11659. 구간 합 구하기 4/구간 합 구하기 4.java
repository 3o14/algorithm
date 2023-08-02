import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N+1];
		int[] sum = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + numbers[i];
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken());
			
			int subSum = sum[end] - sum[start];
			System.out.println(subSum);
		}
		
	}

}
