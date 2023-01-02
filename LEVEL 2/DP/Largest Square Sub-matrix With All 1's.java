import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
		//write your code here
		int[][] dp = new int[arr.length][arr[0].length];
		
		int ans = 0;
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1;j >= 0; j--){
		        if(i == dp.length - 1 && j == dp[0].length - 1){
		            dp[i][j] = arr[i][j];
		        } else if(i == dp.length - 1){
		            dp[i][j] = arr[i][j];
		        } else if(j == dp[0].length - 1){
		            dp[i][j] = arr[i][j];
		        } else {
		            if(arr[i][j] == 0){
		                dp[i][j] = 0;
		            } else {
		                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
		                min = Math.min(min, dp[i + 1][j + 1]);
		                dp[i][j] = min + 1;
		                
		                if(dp[i][j] > ans){
		                    ans = dp[i][j];
		                }
		            }
		        }
		    }
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}