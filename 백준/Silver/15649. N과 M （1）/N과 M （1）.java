import java.util.Scanner;

public class Main {
	
	static int N, R;
	static int[] map;
	static int[] nums;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		map = new int[N];
		nums = new int[R];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) {
			map[i] = i+1;
		}
		// input end
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		// 종료
		if(cnt == R) {
			// 시뮬레이션 구현
			for(int i=0; i<R; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
	
		// 실행 & 재귀 호출
		for(int i=0; i<N; i++) {
			if(v[i]) {
				continue;
			}
			nums[cnt] = map[i];
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}
}