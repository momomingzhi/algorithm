package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//https://developer-mac.tistory.com/67
/*
 * 최소 비용 문제
 * 간선의 가중치가 1
 * 정점과 간선의 개수가 적다(시간 제한 메모리 제한 내에 만족)
 * */
class Pair2{
	int x;
	int y;
	Pair2(int x,int y){
		this.x = x;
		this.y = y; 
	}
}


public class 토마토_7576 {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		
		int m = Integer.parseInt(str1[0]);
		int n = Integer.parseInt(str1[0]);
		
		int[][] arr = new int[n][m];
		int[][] visited = new int[n][m];
		
		Queue<Pair2> q = new LinkedList<>();
		for(int i = 0 ;i < n ; i++) {
			String[] str2 = br.readLine().split(" ");
			for(int j = 0; j<n;j++) {
				arr[i][j] = str2[j].charAt(0) - '0';
				if(arr[i][j] == 1) {
					q.add(new Pair2(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Pair2 p = q.remove();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny < m) {
					if(arr[nx][ny]==0 && visited[nx][ny] == 0 ) {
						q.add(new Pair2(nx,ny));
						visited[nx][ny] +=1; 
					}
				}
			}
		}
		
		int res=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				res= Math.max(res, visited[i][j]);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0 && visited[i][j] == 0 ) {
					res = -1;
				}
			}
		}
		
	}

}
