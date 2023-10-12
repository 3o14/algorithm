import java.util.*;
import java.io.*;

class Solution {

	static class Charger implements Comparable<Charger> {
		int r, c, cover, power;
		
		public Charger(int r, int c, int cover, int power) {
			this.r = r;
			this.c = c;
			this.cover = cover;
			this.power = power;
		}

		@Override
		public int compareTo(Charger o) {
			return this.power - o.power;
		}
		
	}
	
	static int M, A, person[][];
	static int dx[] = {0, -1, 0, 1, 0}, dy[] = {0, 0, 1, 0, -1};
	static Charger chargers[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			person = new int[2][M];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					person[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			chargers = new Charger[A];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				chargers[i] = new Charger(r, c, cover, power);
			}
			// input end
			
			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;
			int sum = 0;
			
			for (int i = 0; i <= M; i++) {
				List<Charger> a = getChargeInfo(ax, ay);
				List<Charger> b = getChargeInfo(bx, by);
				
				if(a.size() > 0 && b.size() == 0) {
					sum += Collections.max(a).power;
				}
				
				if(b.size() > 0 && a.size() == 0) {
					sum += Collections.max(b).power;
				}
				
				if(a.size() > 0 && b.size() > 0) {
					int max = 0;
					for (int j = 0; j < a.size(); j++) {
						for (int j2 = 0; j2 < b.size(); j2++) {
							int temp = a.get(j).power + b.get(j2).power;
							
							if(a.get(j) == b.get(j2)) {
								temp /= 2;
							}
							
							max = Math.max(temp, max);
						}
					}
					sum += max;
				}
				
				if(i == M) break;
				
				ax += dx[person[0][i]];
				ay += dy[person[0][i]];
				bx += dx[person[1][i]];
				by += dy[person[1][i]];
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
	private static List<Charger> getChargeInfo(int r, int c) {
		List<Charger> list = new ArrayList<>();
		for (int i = 0; i < chargers.length; i++) {
			if(Math.abs(r - chargers[i].r)+Math.abs(c - chargers[i].c) <= chargers[i].cover) {
				list.add(chargers[i]);
			}
		}
		return list;
	}

}
