import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R;
    static int[] input, sel;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        sel = new int[R];

        for(int i = 0; i < N; i++) {
        	input[i] = i+1;
        }
        combi(0,0);

    }
    static void combi(int cnt, int start) {
        if(cnt == R) {
            for(int i=0; i<R; i++) {
            	System.out.print(sel[i] +" ");
            	if((i+1)%R == 0)
            		System.out.println();
            }
            return;
        }
        
        for(int i = start ; i <  N; i++) {
            sel[cnt]  = input[i];
            combi(cnt + 1, i+1);
        }
    }
}
