import java.io.*;
import java.util.*;

public class Main {
    public static class Envelop implements Comparable<Envelop> {
        int w;
        int h;
        
        Envelop(int w, int h){
            this.w = w;
            this.h = h;
        }
        
        public int compareTo(Envelop o){
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        Envelop[] envlps = new Envelop[n];
        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int w = Integer.parseInt(parts[0]);
            int h = Integer.parseInt(parts[1]);
            envlps[i] = new Envelop(w, h);
        }
        
        Arrays.sort(envlps);
        
        int[] dp = new int[n];
        int omax = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(envlps[j].h < envlps[i].h && envlps[j].w < envlps[i].w){
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