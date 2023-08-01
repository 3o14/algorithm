import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().toUpperCase().split("");
		
		String[] str2 = Arrays.stream(str).distinct().toArray(String[]::new);
		// 배열 -> stream -> distinct(중복 제거) -> 배열
		
		int max = 0;
		String ans = null;
		for(String s:str2) {
			int cnt = Collections.frequency(Arrays.asList(str), s);
			if(cnt > max) {
				max = cnt;
				ans = s;
			}
			else if(cnt == max)
				ans = "?";
		}
		
		System.out.println(ans);
	}
}