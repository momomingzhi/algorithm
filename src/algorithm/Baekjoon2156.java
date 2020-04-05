package algorithm;

import java.util.Scanner;

public class Baekjoon2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] p= new int[100011];
		int[] dp=new int[100011];
		
		for(int i=1;i<=num;i++) {
			p[i]=sc.nextInt();
		}
		dp[0]=0;
		dp[1]=p[1];
		dp[2]=p[1]+p[2]; 
		/*
		 *바로 전 잔 마셨을 경우 XOO
		 *dp[i-3]+p[i-1]+p[i]   두번째 전 잔은 마시면 안되기 때문에 dp[i-3]해줘야함
		 * 
		 * 두번쨰 전 잔을 마셨을 경우 0X0
		 * dp[i-2]+p[i]
		 * 
		 * 어떤 잔을 안 마셨을 경우  OOX
		 * dp[i]=dp[i-1]
		 * */
		for(int i=3;i<=num;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(dp[i-3]+p[i-1]+p[i], dp[i-2]+p[i]));
		}
		System.out.println(dp[num]);
	}

}
