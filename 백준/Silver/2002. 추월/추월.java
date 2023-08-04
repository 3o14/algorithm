import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Map<String, Integer> inTunnel = new HashMap<>(); // 대근이!!
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inTunnel.put(st.nextToken(), i + 1); // 차량번호, 순서
        }

        //영식이!!
        int[] outTunnel = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            outTunnel[i] = inTunnel.get(st.nextToken()); //
        }

        // Queue로 풀려고 했었다...
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            queue.add(i + 1);
//        }
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for(int j = i+1; j<n; j++) {
                if(outTunnel[i] > outTunnel[j]) {
                    count++;
                    break;
                }

                // Queue로 풀려고 한 부분..
//                if (inTunnel.get(carNumbers) != queue.peek()) {
//                    count++;
//                    queue.remove(inTunnel.get(carNumbers));
//                } else {
//                    queue.poll();
//                }
            }
        }
        System.out.println(count);
    }
}
