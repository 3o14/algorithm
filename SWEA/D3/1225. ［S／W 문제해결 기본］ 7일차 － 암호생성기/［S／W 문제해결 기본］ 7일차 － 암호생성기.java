import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			int N = 8;
			
			st = new StringTokenizer(br.readLine());
			while(N-- > 0) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			int i = 0;
			while(true) {
				int temp = queue.poll();
				int minus = (i++ % 5)+1;
				int next = temp-minus;
				if(next <= 0) {
					queue.add(0);
					break;
				}
				queue.add(next);
			}
	
			sb.append("#").append(tc).append(" ");
			Iterator iter = queue.iterator();
			while(iter.hasNext())
				sb.append(iter.next()).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
