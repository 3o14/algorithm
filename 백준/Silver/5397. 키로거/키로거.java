import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringBuilder sb = new StringBuilder();
			String[] array = br.readLine().split("");
			Stack<String> left = new Stack<>();
			Stack<String> right = new Stack<>();
			
			for(int i = 0; i<array.length; i++) {
				String current = array[i];
				
				switch(current) {
				case "<":
					if(!left.isEmpty())
						right.add(left.pop());
					break;
				
				case ">":
					if(!right.isEmpty())
						left.add(right.pop());
					break;
			
				case "-":
					if(!left.isEmpty())
						left.pop();
					break;
		
				default: // 문자 or 숫자 삽입
					left.add(current);
					break;
				}
	
			}
			
			while(!right.isEmpty()) {
				left.add(right.pop());
			}
			
			while(!left.isEmpty()) {
				sb.append(left.pop());
			}
			sb.reverse();
			System.out.println(sb);
		}
	}

}
