import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        while(n > 0) {
        	if (n%b < 10) {
        		sb.append((char)(n%b + '0'));
        	} else {
        		sb.append((char)(n%b - 10 + 'A'));
        	}
        	
        	n/=b;
        }
        System.out.println(sb.reverse());
    }
}