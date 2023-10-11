import java.util.*;
import java.io.*;

class Solution {

	static class Charger implements Comparable<Charger>{
		int r, c, cover, power;
		Charger(int r, int c, int cover, int power){
			this.r=r;
			this.c=c;
			this.cover=cover;
			this.power=power;
		}
		@Override
		public String toString() {
			return "Charger [r=" + r + ", c=" + c + ", cover=" + cover + ", power=" + power + "]";
		}
		@Override
		public int compareTo(Charger o) {
			// TODO Auto-generated method stub
			return this.power - o.power;
		}
		
	}
	static int M,A;
	static int[][] person;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M=sc.nextInt();
			A=sc.nextInt();
			person = new int[2][M];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < M; j++) {
					person[i][j]=sc.nextInt();
				}
			}
			//System.out.println(Arrays.toString(person[0]));
			Charger[] charger = new Charger[A];
			for (int i = 0; i < A; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				charger[i]=new Charger(r, c, sc.nextInt(), sc.nextInt());
			}
			//System.out.println(Arrays.toString(charger));
			// A B 의 위치를 정해준다
			int personA_r = 1;
			int personA_c = 1;
			int personB_r = 10;
			int personB_c = 10;
			int sum = 0;
			// A B 를 M만큼 한칸씩 이동하면서 충전량을 저장한다
			for (int i = 0; i <= M; i++) {
				// A 사람이 충전할수 있는 충전기를 모두 찾습니다
				List<Charger> chargerA = getCharger(personA_r,personA_c,charger);
				// B 사람이 충전할수 있는 충전기를 모두 찾습니다
				List<Charger> chargerB = getCharger(personB_r,personB_c,charger);
				
				// chargerA 만 충전가능하면 최대값을 충전합니다
				if(chargerA.size()>0 && chargerB.size()==0) {
					sum += Collections.max(chargerA).power;
				}
				// chargerB 만 충전가능하면 최대값을 충전합니다
				if(chargerA.size()==0 && chargerB.size()>0) {
					sum += Collections.max(chargerB).power;
				}
				// 둘 다 가능하다면 모든 경우의 수에 대해 최대 충전량을 구한다
				if(chargerA.size()>0 && chargerB.size()>0) {
					int max = 0;
					for (int j = 0; j < chargerA.size(); j++) {
						for (int k = 0; k < chargerB.size(); k++) {
							int tmp = chargerA.get(j).power + chargerB.get(k).power;
							// 두 충전기가 같다면 /2 한다
							if(chargerA.get(j) == chargerB.get(k)) {
								tmp /= 2;
							}
							max = Math.max(max, tmp);
						}
					}
					sum += max;
				}
				// 마지막은 이동하지 안고 충전만 한다
				if(i==M) break;
				
				// 이동
				personA_r += dr[person[0][i]];
				personA_c += dc[person[0][i]];
				personB_r += dr[person[1][i]];
				personB_c += dc[person[1][i]];
				
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	static int[] dr = {0,-1,0,1, 0};
	static int[] dc = {0, 0,1,0,-1};
	private static List<Charger> getCharger(int r, int c, Charger[] charger) {
		List<Charger> list = new ArrayList();
		for (int i = 0; i < charger.length; i++) {
			if( Math.abs(r-charger[i].r) + Math.abs(c-charger[i].c) <= charger[i].cover) {
				list.add(charger[i]);
			}
		}
		return list;
	}
}
