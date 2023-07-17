import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] networks;
	static int count = 0;
	static boolean[] check = new boolean[101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int nums = Integer.parseInt(br.readLine());
		networks = new ArrayList[m+1];

		for (int i = 0; i <= m; i++) {
			networks[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < nums; i++) {
			String[] line = br.readLine().split(" ");

			networks[Integer.parseInt(line[0])].add(Integer.parseInt(line[1]));
			networks[Integer.parseInt(line[1])].add(Integer.parseInt(line[0]));
		}

		dfs(1);
		System.out.println(count-1);
	}

	public static void dfs(int index) {

		int n = networks[index].size();

		if (!check[index]) {
			check[index] = true;
			count++;
			for (int i = 0; i < n; i++) {
				dfs(networks[index].get(i));
			}
		}
		return;
	}
}