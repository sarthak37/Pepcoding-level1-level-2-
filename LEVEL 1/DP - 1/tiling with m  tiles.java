import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <=n; i++){
            if(i < m){
                dp[i] = 1;
            } else if(i == m){
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        
        System.out.println(dp[n]);

    }
}