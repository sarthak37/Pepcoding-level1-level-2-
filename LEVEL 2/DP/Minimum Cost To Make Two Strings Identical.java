import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2, int c1, int c2) {
		// write your code here
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = dp.length - 1; i >= 0;i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 && j == dp[0].length - 1){
		            dp[i][j] = 0;
		        } else if(i == dp.length - 1){
		            dp[i][j] = 0;
		        } else if(j == dp[0].length - 1){
		            dp[i][j] = 0;
		        } else {
		            if(s1.charAt(i) == s2.charAt(j)){
		                dp[i][j] = 1 + dp[i + 1][j + 1];
		            } else {
		                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
		            }
		        }
		    }
		}
		
		int lcs = dp[0][0];
		int s1r = s1.length() - lcs;
		int s2r = s2.length() - lcs;
		int cost = s1r * c1 + s2r * c2;
		return cost;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

}