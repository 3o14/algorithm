import java.io.*;
import java.util.*;

public class Main {

	static int N, A, B, C;
	static long cnt;
	static int rooms[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		rooms = new int[N];
		cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		solving();
		
		System.out.println(cnt+rooms.length);
	}
	
	private static void solving() {
		for (int i = 0; i < N; i++) {
			rooms[i] -= B;
		}
        
		for (int i = 0; i < rooms.length; i++) {
			if(rooms[i] <= 0) continue;
			cnt += rooms[i] % C == 0 ? rooms[i] / C : rooms[i] / C + 1;
		}
	}
}
