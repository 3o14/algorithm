import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, visit[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		visit = new int[N+1];
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
			
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		int x, y;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// 그래프 저장
			graph.get(y).add(x);
			graph.get(x).add(y);
		}
		
		dfs(a);
		
		System.out.println(visit[b] > 0 ? visit[b] : -1);
	}
	
	static void dfs(int target) {
		for(int x: graph.get(target)) {
			if(visit[x] == 0) {
				visit[x] = visit[target] + 1;
				dfs(x);
			}
		}
	}
}