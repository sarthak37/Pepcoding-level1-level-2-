import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < x.length; i++){
            map.put(x[i], rev[i]);
        }
        
        int[] dp = new int[m + 1];
        dp[0] = 0;
        for(int i = 1; i <= m; i++){
            if(map.containsKey(i) == false){
                dp[i] = dp[i - 1];
            } else {
                int boardNotInstalled =  dp[i - 1];
                int boardInstalled = map.get(i);
                if(i >= t + 1){
                    boardInstalled += dp[i - t - 1];
                }
                
                dp[i] = Math.max(boardNotInstalled, boardInstalled);
            }
        }
        
        return dp[m];
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}