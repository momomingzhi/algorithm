package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int[] dy= {-1,0,0,0};
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
		
	}

}
