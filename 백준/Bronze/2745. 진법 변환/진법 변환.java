import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String n = stk.nextToken();
        int b = Integer.parseInt(stk.nextToken());

        int ans = 0;
        for (int i = 0; i < n.length(); i++){
            if ('0' <= n.charAt(i) && n.charAt(i) <= '9'){
                ans = ans*b + ((int)n.charAt(i) - (int)'0');
            }
            else{
                ans = ans*b + ((int)n.charAt(i) - (int)'A' + 10);
            }
        }
        System.out.println(ans);
    }
}