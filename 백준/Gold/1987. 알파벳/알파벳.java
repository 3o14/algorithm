import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] alphabet;
	static boolean[] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r, c;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		alphabet = new char[r][c];
		for (int i = 0; i < r; i++) {
			alphabet[i] = br.readLine().toCharArray();
		}

		visited = new boolean[26]; // 알파벳 개수~

		dfs(0,0);
		System.out.println(max);
	}

	public static void dfs(int x, int y) {

		visited[alphabet[x][y] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c || visited[alphabet[nextX][nextY] - 'A'])
				continue;

			dfs(nextX, nextY);
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (visited[i])
				count++;
		}
		max = Math.max(count, max);
		
		visited[alphabet[x][y]-'A'] = false;
		return;
	}
}
