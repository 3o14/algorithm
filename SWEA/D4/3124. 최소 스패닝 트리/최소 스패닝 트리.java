import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight){
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static int parents[];
	static Edge edgeList[];
	
	
	/**
	 * 내가 속한 집합의 루트노드 반환
	 */
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	/**
	 * 두 노드의 부모를 합치는 함수
	 * @param a 부모를 합치고자 하는 노드 A
	 * @param b 부모를 합치고자 하는 노드 B
	 * @return 이미 같은 집합일 경우(사이클 생성시) false <br/> 다른 집합일 경우 true 
	 */
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1];
			
			// 부모 노드 정보 담을 배열 초기 세팅
			for (int i = 0; i < V; i++) {
				parents[i] = i;
			}
			
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			
			
			long totalWeight = 0;
			int edgeCnt = 0;
			
			Arrays.sort(edgeList);
			
			for(Edge e: edgeList) {
				if(union(e.from, e.to)) {
					totalWeight += e.weight;
					if(++edgeCnt >= V-1) break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(totalWeight).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
