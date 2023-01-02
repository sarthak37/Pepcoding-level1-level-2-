import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] coins = new int[n];
        for(int i = 0; i < coins.length; i++){
            coins[i] = sc.nextInt();
        }
        
        int tar = sc.nextInt();
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        
        for(int amt = 1; amt <= tar; amt++){
            for(int coin:coins){
                if(coin <= amt){
                    int ramt = amt - coin;
                    dp[amt] = dp[amt] + dp[ramt];
                }
            }
        }
        
        System.out.println(dp[tar]);

    }
}