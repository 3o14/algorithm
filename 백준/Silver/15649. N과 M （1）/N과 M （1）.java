
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] visited;
    static int[] nums;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = i+1;
        }

        visited = new boolean[N];
        arr = new int[M];

        combination(N, M, 0);


    }

    public static void combination(int N, int M, int index){
        if(index == M){
            //printNums(N);
            for(int n:arr){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i] == false) {
                visited[i] = true;
                arr[index] = i + 1;
                combination(N, M, index + 1);
                visited[i] = false;
            }
        }
    }

    private static void printNums(int N) {
        for(int i = 0; i< N; i++){
            if(visited[i]) System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
