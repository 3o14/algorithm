import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 좌석 개수
		int n = Integer.parseInt(br.readLine());
		//
		int[] dp = new int[n + 1];

		int vip_n = Integer.parseInt(br.readLine());
		int[] vip = new int[vip_n];
		for (int i = 0; i < vip_n; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int count = 0;
		int result = 1;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (index < vip_n) {
				if (i == vip[index]) {
					result *= dp[count];
					count = 0;
					index++;
				}
				else
					count++;
			} else
				count++;
		}
		result *= dp[count];

		System.out.println(result);
	}
}