import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			int temp = queue.poll();
			queue.add(temp);
		}
		
		Iterator iter = queue.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
	}
}
