import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int N, M;
	static boolean[] isChecked;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		isChecked = new boolean[N];
		numbers = new int[M];

		combination(0, 1);

	}

	/*
	 * index: 1~M까지 start: 시작하는 숫자
	 */
	private static void combination(int index, int start) {

		if (index == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : numbers)
				sb.append(num + " ");
			System.out.println(sb);
			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[index] = i;
			combination(index + 1, i + 1);
		}
	}
}
