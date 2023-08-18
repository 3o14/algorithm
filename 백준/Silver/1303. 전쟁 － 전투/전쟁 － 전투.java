import java.util.*;
import java.io.*;
 
public class Main{
 
    static int w,h,cnt,white,blue;
    static char[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]); h = Integer.parseInt(input[1]);
        map = new char[h][w]; visit = new boolean[h][w];
        for(int i=0;i<h;i++)
            map[i] = br.readLine().toCharArray();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(!visit[i][j]) {
                    char cur=map[i][j];
                    cnt = 0;
                    dfs(j, i);
                    if(cur=='W')
                        white+=cnt*cnt;
                    else
                        blue+=cnt*cnt;
                }
            }
        }
        System.out.println(white+" "+blue);
    }
 
    private static void dfs(int x, int y) {
        visit[y][x] = true;
        cnt++; //dfs가 호출될 때 마다 카운트 수 증가
        for(int i=0;i< dx.length;i++){
            int nextX = dx[i]+x;
            int nextY = dy[i]+y;
            
            if(!isRange(nextX,nextY)|| visit[nextY][nextX] )
                continue;
            if(map[y][x] == map[nextY][nextX]){ //같은 진영인것끼리만 dfs탐색
                visit[nextY][nextX]=true;
                dfs(nextX,nextY);
            }
        }
    }
 
    private static boolean isRange(int x, int y) {
        return x>=0&&y>=0&&x<w&&y<h;
    }
 
}
 