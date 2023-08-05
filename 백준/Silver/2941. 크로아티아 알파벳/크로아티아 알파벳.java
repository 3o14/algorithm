import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String[] str = st.nextToken().split("");
		int cnt = 0;
		
		int i = 0;
		while(i < str.length) {
			int idx = i;
			for (int j = 3; j >= 2; j--) {
				String[] temp = Arrays.copyOfRange(str, i, i+j);
				String s = String.join("", temp);
				
				if(Arrays.asList(arr).contains(s)) {
					i += s.length();
					cnt++;
				}
			}
			
			if(idx == i) {
				i++;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}