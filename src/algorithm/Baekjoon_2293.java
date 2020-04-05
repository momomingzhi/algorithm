package algorithm;

import java.util.Scanner;

public class Baekjoon_2293 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		int money[] = new int[n];
		int dp[] = new int[c+1];
		
		for(int i=0;i<n;i++) {
			money[i] = sc.nextInt();
		}
		
		
		dp[0]=1;//아무 동전도 선택하지 않는다는 경우의 수 =1 
		for(int i=0;i<n;i++) {
			for(int j=money[i];j<=c;j++) {
				dp[j] = dp[j]+dp[j-money[i]];
			}
		}
		System.out.println(dp[c]);
	}

}
