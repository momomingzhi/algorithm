package algorithm;

import java.util.Scanner;

public class Baekjoon9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 int t= scanner.nextInt();
		 int n;
		 int[] dp=new int[11];
		 //dp[0]=1;//� ���ڷε� ���� �� ���ٴ� ����� �� �ϳ�
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
