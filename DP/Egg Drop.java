import java.io.*;
import java.util.*;

public class Main {

	public static int eggDrop(int n, int k){
		int[][] dp = new int[n + 1][k + 1];
		
		
		for(int i = 1; i <= n; i++){
		    for(int j = 1; j <= k; j++){
		        if(i == 1){
		            dp[i][j] = j;
		        } else if(j == 1){
		            dp[i][j] = 1;
		        } else {
		            int min = Integer.MAX_VALUE;
		            
		            for(int mj = j - 1, pj = 0; mj >= 0; mj--, pj++){
		                int v1 = dp[i][mj];
		                int v2 = dp[i -  1][pj];
		                int val = Math.max(v1, v2);
		                min = Math.min(val, min);
		            }
		            dp[i][j] = min + 1;
		        }
		    }
		}

		return dp[n][k];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}