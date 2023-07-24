import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		
		int [] arr = new int[26];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		String [] chArr = str.split("");
		
		for(String s: chArr) {
			if(arr[(int)s.charAt(0)-97] == -1) {
				arr[(int)s.charAt(0)-97] = str.indexOf(s);
			}
		}
		
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}
}