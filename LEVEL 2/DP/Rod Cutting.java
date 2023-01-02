import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
    // write your code here
    int[] np = new int[prices.length + 1];
    for(int i = 0; i < prices.length;i++){
        np[i + 1] = prices[i];
    }
    
    int[] dp = new int[np.length];
    dp[0] = 0;
    dp[1] = np[1];
    
    for(int i = 2; i < dp.length; i++){
        dp[i] = np[i];
        
        int li = 1;
        int ri = i - 1;
        while(li <= ri){
            if(dp[li] + dp[ri] > dp[i]){
                dp[i] = dp[li] + dp[ri];
            }
            
            li++;
            ri--;
        }
    }
    
    return dp[dp.length - 1];
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}