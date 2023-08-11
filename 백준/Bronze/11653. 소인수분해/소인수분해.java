import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                n/= i;
                sb.append(i + "\n");
            } else {
                i++;
            }
        }
        System.out.print(sb);
        br.close();
	}
}	