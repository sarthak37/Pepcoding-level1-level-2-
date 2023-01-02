import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i < arr.length; i++){
            arr[i] = scn.nextInt();
            
        }
        
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <=arr[i] && i + j < dp.length; j++){
                dp[i] = dp[i] + dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }

}