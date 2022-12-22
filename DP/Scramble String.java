import java.io.*;
import java.util.*;

public class Main {

	public static boolean isScrambleTab(String s1, String s2) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		
		for(int len = 1; len <= n; len++){
		    for(int i = 0; i <= n - len; i++){
		        for(int j = 0; j <= n - len; j++){
		            if(len == 1){
		                dp[i][j][len] = (s1.charAt(i) == s2.charAt(j));
		            } else {
		                for(int k = 1; k < len && !dp[i][j][len]; k++){
		                    dp[i][j][len] = (dp[i][j][k] && dp[i + k][j + k][len - k]) ||  (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
		                }
		            }
		        }
		    }
		}
		
		return dp[0][0][n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(isScrambleTab(s1,s2));
	}

}