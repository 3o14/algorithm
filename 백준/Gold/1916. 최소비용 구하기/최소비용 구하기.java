import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int idx, cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	
	static int V, E, start, end;
	public static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, c));
		}

		int []dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		q.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(dist[cur.idx] < cur.cost ) {
				continue;
			}
			
			for (int i = 0; i < graph.get(cur.idx).size(); i++) {
				Node next = graph.get(cur.idx).get(i);
				
				if(dist[next.idx] > next.cost + cur.cost ) {
					dist[next.idx] =  next.cost + cur.cost;
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		System.out.println(dist[end]);
	}
}
