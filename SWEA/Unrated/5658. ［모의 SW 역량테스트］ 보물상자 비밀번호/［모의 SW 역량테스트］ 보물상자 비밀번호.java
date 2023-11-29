import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, K, ans;
	static String s;
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			s = br.readLine();
			s += s;
			set = new HashSet<>();
			
			solving();
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void solving() {
		int turn =  N/4;
		
		StringBuilder str;
		for (int i = 0; i < turn; i++) {
			for (int j = i; j < s.length(); j+=turn) {
				str = new StringBuilder();
				if(j > s.length() - turn) {
					break;
				}
				set.add(s.substring(j, j+turn));
			}
		}
		
		transfer();
	}

	private static void transfer() {
		List<Integer> list = new ArrayList<>();
		
		for(String str: set) {
			list.add(Integer.parseInt(str, 16));
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		ans = list.get(K-1);
	}

}
