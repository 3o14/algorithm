
import java.io.*;
import java.util.*;

public class Main {
	static int[][] ingredients;
	static int n;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		ingredients = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(SubSetSum(0, 0, 1 , 0, 0));
	}

	public static int SubSetSum(int count, int sumB, int sumS, int start, int selectedCount) {
		if (count == n) {
			if (selectedCount > 0) {
				min =  Math.min(Math.abs(sumB - sumS), min);
				return min;
			}
			return min; //아무것도 뽑지 않았을 경우는 제외하기 위함
		}

		return Math.min(SubSetSum(count + 1, sumB, sumS, start + 1, selectedCount),
				
				SubSetSum(count + 1, sumB + ingredients[start][1], sumS * ingredients[start][0], start + 1, selectedCount+1));
	}
}
