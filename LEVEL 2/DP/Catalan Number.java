import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] dp  =  new int[n + 1];
    
    dp[0] = 1;
    dp[1] = 1;
    
    for(int i = 2; i < dp.length; i++){
        for(int j = 0; j < i; j++){
            dp[i] = dp[i] + dp[j] * dp[i - j - 1];
        }
    }
    
    System.out.println(dp[n]);
 }

}