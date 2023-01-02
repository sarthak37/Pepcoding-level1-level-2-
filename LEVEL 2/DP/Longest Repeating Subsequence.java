import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str){
		//write your code here
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 && j == dp[0].length - 1){
		            dp[i][j] = 0;
		        } else if(i == dp.length - 1){
		            dp[i][j] = 0;
		        } else if(j == dp[0].length - 1){
		            dp[i][j] = 0;
		        } else {
		            if(str.charAt(i) == str.charAt(j) && i != j){
		                dp[i][j] = dp[i + 1][j + 1] + 1;
		            } else {
		                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
		            }
		        }
		    }
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}