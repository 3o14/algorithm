import java.io.*;
import java.util.*;

public class Main {
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight); // 비교할 두 값의 부호가 다른 경우의 오류 방지를 위함
		} 
	}
	
	static Edge[] edgeList;
	static int V, E;
	static int[] parents;
	
	// 간선 리스트 생성 함수
	static void make() {
		parents = new int[V+1];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	// 부모 노드를 찾는 find 함수
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 두 부모 노드를 합치는 union 함수
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 사이클 발생!!
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드와 간선의 개수 각각 입력받기
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 간선 리스트
		edgeList = new Edge[E];
		
		// 간선 리스트에 간선 정보(출발노드, 도착노드, 가중치) 저장
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// 간선리스트를 가중치 기준으로 오름차순 정렬
		Arrays.sort(edgeList);
		
		// V개의 정점으로 make set 작업
		make();
		
		long result = 0; // MST 비용
		int count = 0; // 연결된 간선 개수
		
		// 간선리스트를 순회하면서 비용이 작은 간선 순으로 꺼내서 처리
		// 사이클 생성시 union함수에서 false를 반환함
		for (Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
