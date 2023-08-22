import java.io.*;
import java.util.*;

/*
 1. 문자 정렬
 2. 기존에 선택한 알파벳보다 큰 알파벳을 선택하며 암호 생성
 3. 암호 생성 후 한개 이상의 모음과 두개 이상의 자음으로 구성된지 확인
 */

public class Main {
	
	public static int L, C;
	public static char[] list;
	public static char[] ans;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		ans = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		
		//
		Arrays.sort(list);
		
		func(0, 0);
		System.out.println(sb);
	}
	
	public static void func(int x, int idx) {
		if( idx == L) { // 코드를 모두 생성했을 때
			// 최소 한개의 모음, 최소 2개의 자음인지 확인
			if (isValid()) {
				sb.append(ans).append("\n");
			}
			return;
		}
		
		for (int i = x; i < C; i++) {
			ans[idx] = list[i];
			func(i+1, idx+1);
		}
	}
	
	// 모음과 자음의 개수가 조건을 만족하는지 확인하는 함수
	public static boolean isValid() {
		int m = 0; // 모음
		int j = 0; // 자음
		
		for ( char x: ans) {
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                m++;
            } else {
                j++;
            }
		}
		
		if (m >= 1 && j >= 2) {
            return true;
        }
        return false;
	}
}
