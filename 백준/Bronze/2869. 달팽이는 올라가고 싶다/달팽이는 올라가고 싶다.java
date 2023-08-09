import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int goal = V-B;
		int climb = A-B;
		int ans = goal/climb; //남은 거리가 climb일때 예외처리하기

		if(goal%climb != 0) ans++;
		sb.append(ans);
		System.out.println(sb);
		br.close();
	}
}
