import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
        int[] dp = new int[arr.length];
        int omax = 0;
        int omi = 0;
        
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(arr[j] <= arr[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            
            dp[i] = max + 1;
            if(dp[i] > omax){
                omax = dp[i];
                omi = i;
            }
        }
        
        System.out.println(omax);
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(omax, omi, arr[omi], arr[omi] + ""));
        
        while(queue.size() > 0){
            Pair rem = queue.removeFirst();
            
            if(rem.l == 1){
                System.out.println(rem.psf);
            }
            
            for(int j = rem.i - 1; j >= 0; j--){
                if(dp[j] == rem.l - 1 && arr[j] <= rem.v){
                queue.add(new Pair(dp[j],j , arr[j], arr[j] + " -> " + rem.psf));
            }
        }
    }
    
}
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}