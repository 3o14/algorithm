import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] input;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	input[i] = i == 0 ? Integer.parseInt(st.nextToken()) : input[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken())-1;
        	int end = Integer.parseInt(st.nextToken())-1;
        	
        	if(start == 0) {
        		System.out.println(input[end]);
        	} else {
        		System.out.println(input[end] - input[start-1]);
        	}
        }
        
    }
}
