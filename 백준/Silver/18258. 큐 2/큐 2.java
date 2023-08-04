import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
				break;
			case "pop":
				int popOne = deque.isEmpty() ? -1 : deque.removeLast();
				sb.append(popOne).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				int TF = deque.isEmpty() ? 1 : 0;
				sb.append(TF).append("\n");
				break;
			case "front":
				int numFirst = deque.isEmpty() ? -1 : deque.getLast();
				sb.append(numFirst).append("\n");
				break;
			case "back":
				int numLast = deque.isEmpty() ? -1 : deque.getFirst();
				sb.append(numLast).append("\n");
				break;
			
			}
		}
		System.out.println(sb);
	}

}
