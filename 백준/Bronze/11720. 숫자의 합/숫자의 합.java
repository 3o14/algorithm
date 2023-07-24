import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String []arr = new String[n];
		arr = st.nextToken().split("");
		int sum = 0;
		for(String i: arr)
			sum += Integer.parseInt(i);
		System.out.println(sum);
	}
}