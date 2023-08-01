import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=0; tc<10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int dump = Integer.parseInt(st.nextToken());
			int []arr = new int[100];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());			
			}
			// input end
	
			arr = recu(dump, 0, arr);
			Arrays.sort(arr);
			System.out.printf("#%d %d", tc+1, arr[arr.length-1] - arr[0]);
			System.out.println();
		}
	}
	
	public static int[] recu(int dump, int i, int[] arr) {
		if(i >= dump) {
			return arr;
		}
		
		Arrays.sort(arr);
		if(arr[0] < arr[arr.length-1]) {
			arr[0]++;
			arr[arr.length-1]--;
		}
		
		return recu(dump, i+1 , arr);
	}
}