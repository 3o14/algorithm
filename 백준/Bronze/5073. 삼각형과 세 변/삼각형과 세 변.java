import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	
        	int lengs[] = new int[3];
        	
        	for (int i = 0; i < 3; i++) {
				lengs[i] = Integer.parseInt(st.nextToken());
			}
        	Arrays.sort(lengs);
        	int x = lengs[0];
        	int y = lengs[1];
        	int z = lengs[2];
        	
        	if(x == y && y == z && z == x) {
        		if(x == 0) break;
        		else sb.append("Equilateral").append("\n");
        	} else if(z >= x+y) {
        		sb.append("Invalid").append("\n");
        	} else {
        		if(x == y || y == z || z == x) {
            		sb.append("Isosceles").append("\n");
            	} else {
            		sb.append("Scalene").append("\n");
            	}
        	}
        }
        
        System.out.println(sb);
	}
}	