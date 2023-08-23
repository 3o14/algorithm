import java.util.*;
import java.io.*;


public class Solution {

	static boolean visit[];
	static int last, depth[];
	static ArrayList<ArrayList<Integer>> listGraph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			listGraph = new ArrayList<ArrayList<Integer>>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			visit = new boolean[101];
			depth = new int[101]; // 단계별 마지막값 저장 배열
			int max = Integer.MIN_VALUE;
			int result = 0;
			
			for (int i = 0; i < 101; i++) {
				listGraph.add(new ArrayList<Integer>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (listGraph.get(from).contains(to)) {
					continue;
				}
				listGraph.get(from).add(to);
			}
			// 입력 완료
	
			bfs(start);
			
			for (int i = 0; i < 101; i++) {
				if(max<=depth[i]) {
					max=depth[i]; 
					if (result<i) result=i;
				} // 마지막값 중에서 가장 큰 값 찾기
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			
			for (int i = 0; i < listGraph.get(next).size(); i++) {
				int idx = listGraph.get(next).get(i);
				if(visit[idx] == false) {
					queue.offer(idx);
					visit[idx] = true;
					depth[idx] = depth[next] + 1; // 단계 표시
				}
			}
		}
	}
}
