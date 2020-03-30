package algorithm;

import java.util.Scanner;

public class Baekjoon9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 int t= scanner.nextInt();
		 int n;
		 int[] dp=new int[11];
		 //dp[0]=1;//어떤 숫자로도 만들 수 없다는 경우의 수 하나
		 dp[1]=1;
		 dp[2]=2;
		 dp[3]=4;
		 
		 for(int i=0;i<t;i++) {
			 n=scanner.nextInt();
			 
			 for(int j=4;j<=n;j++) {
				 dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
			 
			 }
			 
			 System.out.println(dp[n]);
		 }

	}

}
