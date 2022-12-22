import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int mx = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++){
            Integer max = null;
            
            for(int j = 0; j < i; j++){
                if(arr[j] <= arr[i]){
                    if(max == null){
                        max = dp[j];
                    } else if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            
            if(max == null){
                dp[i] = arr[i];
            } else {
                dp[i] = max + arr[i];
            }
            
            if(dp[i] > mx){
                mx = dp[i];
            }
            
            
        }
        
        System.out.println(mx);
        
        
    }

}