import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N = 9;
	static int[] nanjang = new int[N];
	static int[] answer = new int[7];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i<N; i++) {
			nanjang[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0, 0); //count, start;
	}

	private static void combination(int count, int start, int sum) {
		
		if(count == 7) {
			if(sum == 100) {
				for(int num:answer) {
					System.out.println(num);
				}
			}
			return;
		}
		
		for(int i = start; i<N; i++) {
			answer[count] = nanjang[i];
			combination(count+1, i+1, sum+answer[count]);
		}
		
	}

}
