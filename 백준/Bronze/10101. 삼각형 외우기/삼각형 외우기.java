import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        String ans = "";
        
        if(A+B+C == 180) {
        	if (A==B && B==C) {
        		ans = "Equilateral";
        	} else if(A==B || B==C || C==A) {
        		ans = "Isosceles";
        	} else {
        		ans = "Scalene";
        	}
        } else {
        	ans = "Error";
        }
        
        System.out.println(ans);
	}
}	