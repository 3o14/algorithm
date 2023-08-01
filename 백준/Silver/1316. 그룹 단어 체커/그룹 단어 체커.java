import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			String[] groupStr = new String[100];
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			String [] strArr = st.nextToken().split("");
			groupStr[idx++] = strArr[0];
			for(int j=1; j<strArr.length; j++) {
				if(strArr[j].equals(strArr[j-1])) {
					continue;
				} else if(!strArr[j].equals(strArr[j-1])) {
					if(Arrays.asList(groupStr).contains(strArr[j])) {
						ans--;
						break;
					} else {
						groupStr[idx++] = strArr[j];
					}
				}
			}
		}
		
		System.out.println(n+ans);
				
	}
}