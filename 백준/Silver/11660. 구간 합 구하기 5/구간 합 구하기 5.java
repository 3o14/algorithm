import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][N];

        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = j == 0 ? Integer.parseInt(st.nextToken()) : map[i][j-1] + Integer.parseInt(st.nextToken());
        	}
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<M; i++) {
        	int sum = 0;
        	st = new StringTokenizer(br.readLine());
        	int start[] = {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        	int end[] = {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        	
        	for(int j=end[0]; j>start[0]-1; j--) {
        		if(start[1] == 0) {
        			sum += map[j][end[1]];
        		} else {
        		sum += map[j][end[1]] - map[j][start[1]-1];
        		}
        	}
        	sb.append(sum);
        	sb.append("\n");
        }
        System.out.print(sb);
    }
}
