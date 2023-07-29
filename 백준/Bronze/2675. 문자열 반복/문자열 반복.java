import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // Test 횟수

		String[] arr = new String[T];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // Repeat 횟수
			
			arr[i] = st.nextToken();
			
			for(int j=0; j<arr[i].length(); j++) {
				for(int k=0; k<R; k++)
					System.out.print(arr[i].charAt(j));
			}
			System.out.println();
			
		}
	}
}