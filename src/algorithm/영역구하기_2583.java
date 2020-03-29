package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class rect{
	int y;
	int x;
	rect(int y,int x){
		this.y=y;
		this.x=x;
	}
}

public class 영역구하기_2583 {
	int a=0;
	static int[][] map;
	static boolean[][] visited;
	static int M,N,K;
	static int cnt;
	static int[] sum;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		sum=new int[N*M];
		cnt=0;
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1= Integer.parseInt(st.nextToken());
			
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			for(int x=x1;x<x2;x++) {
				for(int y=y1;y<y2;y++) {
					map[x][y]=1;
				}
			}
		}
		int c=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					bfs(i,j,c);
					cnt++;
					c++;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(sum,0,cnt);
		for(int i=0;i<cnt;i++) {
			System.out.print(sum[i] + " ");
		}
		
	}
	static public void bfs(int y,int x,int c) {
		Queue<rect> q = new LinkedList<>();
		rect r1 = new rect(y,x);
		q.add(r1);
		
		while(!q.isEmpty()) {
			rect r2 = q.poll();
			visited[r2.y][r2.x]=true;
			sum[c]+=1;
			
			for(int i=0;i<4;i++) {
				int ny = r2.y + dy[i];
				int nx = r2.x + dx[i];
				
				if(ny >=0 && nx >=0 && ny<N && nx<M) {
					if(map[ny][nx]==0 && !visited[ny][nx]) {
						rect r3 = new rect(ny,nx);
						q.add(r3);
						visited[r3.y][r3.x]=true;
					}
				}
			}
			
		}
	}

}
