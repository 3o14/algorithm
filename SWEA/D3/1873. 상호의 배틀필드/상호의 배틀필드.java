import java.io.*;
import java.util.*;

class Solution {
	public static int h;
	public static int w;
	public static char[][] array;
	public static int[] dxs= {-1,1,0,0};
	public static int[] dys= {0,0,-1,1};
	
	public static boolean can_go(int x,int y) { // 전차가 이동할 수 있는지 판별하는 함수
		if (x>=0 && x<h && y>=0 && y<w && array[x][y]=='.' ) { // 격자 내에 있고 평지일 경우 이동 가능
			return true;
		}
		return false; // 그 외에는 이동 불가
	}
	
	public static void can_shot(int x,int y,int dir) {
		// 이때는 전차 위치는 그대로, 포탄 위치만 움직임.
		while (x>=0 && x<h && y>=0 && y<w) { // 격자 내에 있을때까지만 shot
			if (array[x][y]=='#') { 
				break; // 강철벽 = 막힘, 발사 종료
			} else if(array[x][y]=='*') {
				array[x][y]='.'; // 평지로 변경 후, 발사 종료
				break;
			} else if(array[x][y]=='.' || array[x][y]=='-') { // 평지 만나면 계속 진행
				x+=dxs[dir];
				y+=dys[dir];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			array= new char[h][w];
			
			for(int i=0; i<h; i++) {
				array[i]=br.readLine().toCharArray();
			}
			
			int n=Integer.parseInt(br.readLine()); 
			char[] userTemp=new char[n]; // 사용자 입력 배열
			userTemp=br.readLine().toCharArray();

			Map<Character, Integer> map= new HashMap<>(); // 방향 담고 있는 딕셔너리
			map.put('^', 0);
			map.put('v', 1);
			map.put('<', 2);
			map.put('>', 3);
			
			int x=0;
			int y=0;
			int dir=0;
			
			// 1. 전차 초기 위치 파악하기
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(array[i][j]=='^'){
						x=i;
						y=j;
						dir=map.get('^');
					}else if( array[i][j]=='v') {
						x=i;
						y=j;
						dir=map.get('v');
					}else if( array[i][j]=='<') {
						x=i;
						y=j;
						dir=map.get('<');
					}else if( array[i][j]=='>') {
						x=i;
						y=j;
						dir=map.get('>');	
					}
				}
			}
			
			// 2. 사용자 입력에 따라 행동하기
			for (char c : userTemp) {
				if(c=='U') { // 위
					dir=map.get('^'); // 방향 변경
					array[x][y]='^'; // 방향 전환
					int nx=x+dxs[dir];
					int ny=y+dys[dir];
					if(can_go(nx,ny)) { // 이동 가능
						array[x][y]='.'; // 전차 있던 곳은 평지로
						array[nx][ny]='^';
						x=nx;
						y=ny;
					}
				}else if(c=='D') { // 아래
					dir=map.get('v');
					array[x][y]='v';
					int nx=x+dxs[dir];
					int ny=y+dys[dir];
					if(can_go(nx,ny)) { // 이동 가능
						array[x][y]='.'; // 전차 있던 곳은 평지로
						array[nx][ny]='v';
						x=nx;
						y=ny;
					}
				}else if(c=='L') { // 왼쪽
					dir=map.get('<');
					array[x][y]='<';
					int nx=x+dxs[dir];
					int ny=y+dys[dir];
					if(can_go(nx,ny)) { // 이동 가능
						array[x][y]='.'; // 전차 있던 곳은 평지로
						array[nx][ny]='<';
						x=nx;
						y=ny;
					}
				}else if(c=='R') { // 오른쪽
					dir=map.get('>');	
					array[x][y]='>';
					int nx=x+dxs[dir];
					int ny=y+dys[dir];
					if(can_go(nx,ny)) { // 이동 가능
						array[x][y]='.'; // 전차 있던 곳은 평지로
						array[nx][ny]='>';
						x=nx;
						y=ny;
					}
				}else { // 포탄 발사
					int nx=x+dxs[dir];
					int ny=y+dys[dir];
					can_shot(nx,ny,dir);
				}
			}
			System.out.printf("#%d ",t);
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
			}
		}
	}
}