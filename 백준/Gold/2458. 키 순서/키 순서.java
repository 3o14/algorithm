import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//boj 2458 주요 아이디어 : 나보다 작은애가 있으면 걔보다 작은애들은 다 나보다 작다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[][] related=new int[N][N];
        for(int i=0;i<N;i++)
        {
            related[i][i]=2;
        }
        for (int i = 0; i < M; i++) {
            tmp = br.readLine().split(" ");
            int A = Integer.parseInt(tmp[0])-1;
            int B = Integer.parseInt(tmp[1])-1;
            
            related[A][B]=1;
            related[B][A]=-1;
        }
        
        Queue<Integer> q=new LinkedList();
        
        
        
        for(int cur=0;cur<N;cur++)
        {

            ArrayList<Integer> shorter=new ArrayList();
            ArrayList<Integer> taller=new ArrayList();
            
            for(int i=0;i<N;i++)
            {
                if(related[cur][i]==-1)
                {
                    shorter.add(i);
                }
                if(related[cur][i]==1)
                {
                    taller.add(i);
                }
            }
            for(int sho:shorter)
            {
                for(int tal:taller)
                {
                    related[sho][tal]=1;
                    related[tal][sho]=-1;
                }
            }
        }
        
//        for(int[] rel:related)
//        {
//            System.out.println(Arrays.toString(rel));
//        }
        
        int cnt=0;
        for(int i=0;i<N;i++)
        {
            int j=0;
            for(;j<N;j++)
            {
                if(related[i][j]==0)
                {
                    break;
                }
            }
            if(j==N)
            {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}