import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//치킨 TOP N
public class Main {
	static int k;
	static ArrayList<Integer> chickens = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // 치킨집의 개수
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=n; i++) {
			chickens.add(Integer.parseInt(st.nextToken()));
		}
		
		k = Integer.parseInt(br.readLine());
		
		int div = n/k;
		
		for(int i = 0; i<n; i+=div) {
			chickens.subList(i, i+div).sort(Comparator.naturalOrder());;
			
		}
		
		for(int tmp : chickens) {
			sb.append(tmp).append(" ");
		}
		
		System.out.println(sb);
	}
}
