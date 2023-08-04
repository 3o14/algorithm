import java.util.*;
import java.io.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			Stack<String> stack = new Stack<String>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String arr[] = new String[N];
			st = new StringTokenizer(br.readLine());
			String datas = st.nextToken();
			arr = datas.split("");
			// split() vs for 어느게 더 빠르지?
			
			for (int i = 0; i < arr.length; i++) {
				String op = "", op2 = "";
				if(stack.empty()) {
					stack.push(arr[i]);
				} else if(!stack.empty()) {
					op = stack.peek();
					
					switch(op) {
					case "{":
						op2 = "}";
						break;
					case "[":
						op2 = "]";
						break;
					case "(":
						op2 = ")";
						break;
					case "<":
						op2 = ">";
						break;
					}
					
					if(op2.equals(arr[i])) {
						stack.pop();
					} else {
						stack.push(arr[i]);
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			if(stack.isEmpty()) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
