import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    카드 합체 놀이
    문제 요약: 카드 합체를 k번 한 후 카드에 적힌 수의 합을 최소로 만들기
    
    1. 우선순위 큐를 사용해서 가장 적은 카드 두 장을 뽑아 더한 후 덮어쓰기 해준다.
    2. 마지막에 모든 카드의 숫자를 합한 값을 출력한다.
*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드 개수
        int m = Integer.parseInt(st.nextToken());// 합체 수

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();

            long sum = a + b;
            pq.add(sum);
            pq.add(sum);
        }


        long result = 0;
        while (!pq.isEmpty()) result += pq.poll();
        System.out.println(result);
    }

}