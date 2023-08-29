import java.util.*;
import java.io.*;

public class Main {

	static int []dp;
	private static int func(int n, int cnt) {
		if(n < 2) return cnt;
		
		return Math.min(func(n/2, cnt+1 + (n%2)), func(n/3, cnt+1 + (n%3)));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(func(N, 0));
	}
}
