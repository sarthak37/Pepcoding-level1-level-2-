import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        //write your code here
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        
        HashMap<Character, Integer> lo = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = 2 * dp[i - 1];
            
            char ch = str.charAt(i - 1);
            if(lo.containsKey(ch)){
                int j = lo.get(ch);
                dp[i] = dp[i] - dp[j - 1];
            }
            
            lo.put(ch, i);
        }
        
        System.out.println(dp[str.length()] - 1);

    }
}