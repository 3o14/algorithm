import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int price = Integer.parseInt(br.readLine());
			int Q = 0, D = 0, N = 0, P = 0;
			
			while(price >= 25) {
				price -= 25;
				Q++;
			}
			while(price >= 10) {
				price -= 10;
				D++;
			}
			while(price >= 5) {
				price -= 5;
				N++;
			}
			while(price >= 1) {
				price -= 1;
				P++;
			}
			
			sb.append(Q).append(" ").append(D).append(" ").append(N).append(" ").append(P).append("\n");
		}
		System.out.println(sb);
	}
}
