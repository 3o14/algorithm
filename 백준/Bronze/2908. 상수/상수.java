import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 0, b = 0;
		
		StringBuffer sbA = new StringBuffer(st.nextToken());
		StringBuffer sbB = new StringBuffer(st.nextToken());
		
		a = Integer.parseInt(sbA.reverse().toString());
		b = Integer.parseInt(sbB.reverse().toString());
		
		System.out.println(a>b ? a :b);
	}
}