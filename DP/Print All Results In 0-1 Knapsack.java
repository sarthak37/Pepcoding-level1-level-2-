import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair {
        int i;
        int j;
        String psf;
        
        Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] vals = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            vals[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here
        
        int[][] dp= new int[vals.length + 1][cap + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j <dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];
                
                if(j >= wts[i - 1]){
                    if(dp[i - 1][j - wts[i - 1]] + vals[i - 1] > dp[i - 1][j]){
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + vals[i - 1];
                    }
                }
            }
        }
        
        int ans = dp[vals.length][cap];
        System.out.println(ans);
        
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(vals.length, cap, ""));
        
        while(que.size() > 0){
            Pair rem = que.removeFirst();
            
            if(rem.i == 0 || rem.j == 0){
                System.out.println(rem.psf);
            } else {
                int exc = dp[rem.i - 1][rem.j];
                
                if(rem.j >= wts[rem.i - 1]){
                    int inc =dp[rem.i - 1][rem.j - wts[rem.i - 1]] + vals[rem.i - 1];
                
                if(dp[rem.i][rem.j] == inc){
                    que.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], (rem.i - 1) + " " + rem.psf ));
                    
                }
            }
                
                
                if(dp[rem.i][rem.j] == exc){
                    que.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }
        
        
        
    }
}