import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int map[][];
	static int N = 0, M = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        map = new int[N>M?N:M][N>M?N:M];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        st = new StringTokenizer(br.readLine());
        int option[] = new int[R];
        for (int i = 0; i < R; i++) {
			option[i] = Integer.parseInt(st.nextToken());
		}
        
        // input end
        
        for (int i = 0; i < R; i++) {
        	switch(option[i]) {
        	case 1:
        		one();
        		break;
        	case 2:
        		two();
        		break;
        	case 3:
        		three();
        		break;
        	case 4:
        		four();
        		break;
        	case 5:
        		five();
        		break;
        	case 6:
        		six();
        		break;
        	}
        }
        
        print();
    }
    
    public static void one() {
    	int temp[] = new int[N];
    	for (int i = 0; i < N/2; i++) {
    		int switchIndex = Math.abs(i - N) - 1;
    		temp = map[i];
    		map[i] =  map[switchIndex];
    		map[switchIndex] = temp;
		}
    }
    
    public static void two() {
    	int temp = 0;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M/2; j++) {
        		int switchIndex = Math.abs(j - M) - 1;
        		temp = map[i][j];
        		map[i][j] =  map[i][switchIndex];
        		map[i][switchIndex] = temp;
    		}
		}
    }
    
    public static void three() {
    	int threeMap[][] = new int[M][N];

    	int c = N-1;
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
				threeMap[j][c] = map[i][j];
			}
    		c--;
		}
    	
    	//크기 변환
		int temp = N;
		N = M;
		M = temp;
        
        map = threeMap;
    }
    
    public static void four() {
    	int fourMap[][] = new int[M][N];

    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			fourMap[M-j-1][i] = map[i][j];
			}
		}
    	//크기 변환
		int temp = N;
		N = M;
		M = temp;
		
        map = fourMap;
    }
    
    public static void five() {
    	int tempMap[][] = new int[N][M];
    	
    	int nMid = N/2;
    	int mMid = M/2;
    	
    	// 그룹 1
    	for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tempMap[i][Math.abs(j+M/2)] = map[i][j];
			}
		}
    	
    	// 그룹 2
    	for (int i = 0; i < nMid; i++) {
			for (int j = mMid; j < M; j++) {
				tempMap[Math.abs(i+N/2)][j] = map[i][j];
			}
		}
    	
    	// 그룹 3
    	for (int i = nMid; i < N; i++) {
    		int c = 0;
			for (int j = mMid; j < M; j++, c++) {
				tempMap[i][c] = map[i][j];
			}
		}
    	
    	// 그룹 4
    	int r = 0;
    	for (int i = nMid; i < N; i++, r++) {
			for (int j = 0; j < mMid; j++) {
				tempMap[r][j] = map[i][j];
			}
		}
    	
    	map = tempMap;
    }
    
    public static void six() {
    	int tempMap[][] = new int[N][M];
    	
    	int nMid = N/2;
    	int mMid = M/2;
    	
    	// 그룹 1
    	for (int i = 0; i < nMid; i++) {
			for (int j = 0; j < mMid; j++) {
				tempMap[i+nMid][j] = map[i][j];
			}
		}
    	
    	// 그룹 2
    	for (int i = 0; i < nMid; i++) {
			for (int j = mMid; j < M; j++) {
				tempMap[i][j-mMid] = map[i][j];
			}
		}
    	
    	// 그룹 3
    	int r = 0;
    	for (int i = nMid; i < N; i++, r++) {
			for (int j = mMid; j < M; j++) {
				tempMap[r][j] = map[i][j];
			}
		}
    	
    	// 그룹 4
    	for (int i = nMid; i < N; i++) {
			for (int j = 0; j < mMid; j++) {
				tempMap[i][j+mMid] = map[i][j];
			}
		}
    	
    	map = tempMap;
    }
    public static void print() {
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if(map[i][j] != 0)
    				sb.append(map[i][j]).append(" ");
			}
    		sb.append("\n");
		}
    	System.out.println(sb);
    }
}	