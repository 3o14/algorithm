import java.io.*;
import java.util.*;

class Solution {
	
	static class Virus implements Comparable<Virus>{
		int r, c, n, d;

		public Virus(int r, int c, int n, int d) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(Virus o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.n, this.n);
		}
		
	}
	
	static int N, M, K;
	static int dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
	static List<Virus> vs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			vs = new ArrayList<>();
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				vs.add(new Virus(r, c, n, d));
			}
			
			for (int j = 0; j < M; j++) {
				solving();
			}
			
			int sum = 0;
			
			for (int j = 0; j < vs.size(); j++) {
				sum += vs.get(j).n;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void solving() {

		for (int i = 0; i < vs.size(); i++) {
			Virus v = vs.get(i);
			v.r += dr[v.d-1];
			v.c += dc[v.d-1];
			
			if(v.r == 0 || v.c == 0 || v.r == N-1 || v.c == N-1) {
				v.n /= 2;
	
				if(v.d % 2 == 1) {
					v.d += 1;
				} else {
					v.d -= 1;
				}
				
			}
			
			if(v.n < 1) {
				vs.remove(i--);
			}
			
		}
		
		Collections.sort(vs);
		for (int i = 0; i < vs.size()-1; i++) {
			Virus v1 = vs.get(i);
			for (int j = i+1; j < vs.size(); j++) {
				Virus v2 = vs.get(j);
				
				if(v1.r == v2.r && v1.c == v2.c) {
					v1.n += v2.n;
					
					vs.remove(j);
					j--;
				}
			}
		}

	}

}
