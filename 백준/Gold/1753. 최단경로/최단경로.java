import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	static class Node {
		int idx;
		int cost;
		
		Node(int idx, int cost) {
	 		this.idx = idx;
	 		this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		int []dis = new int[V+1];
		boolean []visit = new boolean[V+1];
		
		
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < V+1; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, c));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		q.offer(new Node(start, 0));
		dis[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(dis[cur.idx] < cur.cost) {
				continue;
			}
			
			for (int i = 0; i < graph.get(cur.idx).size(); i++) {
				Node next = graph.get(cur.idx).get(i);
				if(dis[next.idx] > cur.cost+next.cost) {
					dis[next.idx] = cur.cost+next.cost;
					q.offer(new Node(next.idx, dis[next.idx]));
				}
			}
		}
		
		for(int i = 1; i<dis.length; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(dis[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
}
