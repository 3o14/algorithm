import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][2];
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
        
 		Arrays.sort(arr, (o1, o2) -> {
			return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
 		});

        int prevEnd = 0;
        for (int i = 0; i < N; i++) {
        	if(prevEnd <= arr[i][0]) {
        		prevEnd = arr[i][1];
        		cnt++;
        	}
		}
        System.out.println(cnt);
	}
}	