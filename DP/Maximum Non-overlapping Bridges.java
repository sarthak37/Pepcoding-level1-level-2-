import java.io.*;
import java.util.*;

public class Main {
    
    public static class Bridge implements Comparable<Bridge> {
        int n;
        int s;
        
        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        
        public int compareTo(Bridge o){
            if(this.n != o.n){
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        
        Bridge[] bdgs = new Bridge[n];
        for(int i = 0; i < n; i++){
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int nr = Integer.parseInt(parts[0]);
            int s = Integer.parseInt(parts[1]);
            bdgs[i] = new Bridge(nr, s);
        }
        
        Arrays.sort(bdgs);
        
        int[] dp = new int[n];
        int omax = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(bdgs[j].s <= bdgs[i].s){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            
            dp[i] = max + 1;
            
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        
        System.out.println(omax);
    }

}