import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int prev = 1;
		int current = prev, i = 1;
		int ans = 0;
		while (true) {
			if(N == 1) {
				ans = 1;
				break;
			}
			if(prev < N && N <= current) {
				ans = i;
				break;
			}
			prev = current;
			current += 6*i;
			i++;
		}
		System.out.println(ans);
		br.close();
	}
}
