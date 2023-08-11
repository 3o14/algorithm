import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0, first = 0;
		
		for (int i = N; i <= M; i++) {
			int check = 0;
			
			if(i == 1) continue;

			for (int j = 2; j < i; j++) {
				if(i % j == 0) continue;
				check++;
			}
			if(check == i-2) {
				sum += i;
				if(first == 0) {
					first = i;
				}
			}
		}
		
		if(sum != 0 && first != 0) {
			sb.append(sum).append("\n").append(first);
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
		br.close();
	}
}	