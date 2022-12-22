import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str) {
		int[][] dp = new int[str.length()][str.length()];
		
		for(int gap = 0; gap < dp.length; gap++){
		    for(int si = 0, ei = gap ; ei < dp.length; si++, ei++){
		        if(gap == 0){
		            dp[si][ei] = 1;
		        } else {
		            if(str.charAt(si) == str.charAt(ei)){
		                dp[si][ei] = dp[si + 1][ei - 1] + 2; 
		            } else {
		                dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
		            }
		        }
		    }
		}

		int ans = str.length() - dp[0][dp.length - 1];
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}