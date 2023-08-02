import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int[] numbers;
	static boolean[] isCheck;

	static void perm(int cnt) {
		if (cnt == m) {
			for (int num:numbers) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isCheck[i]) {
				numbers[cnt] = i + 1;
				isCheck[i] = true;
				perm(cnt + 1);
				isCheck[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		isCheck = new boolean[n];
		numbers = new int[m];

		perm(0);
	}
}