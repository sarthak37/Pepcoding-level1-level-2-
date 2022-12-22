import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n) {
   int[] dp = new int[n + 1];
   dp[1] = 1;
   
   int p2 = 1;
   int p3 = 1;
   int p5 = 1;
   
   for(int i = 2; i <= n; i++){
       int f1 = 2 * dp[p2];
       int f2 = 3 * dp[p3];
       int f3 = 5 * dp[p5];
       
       int min =    Math.min(f1, Math.min(f2, f3));
       dp[i] = min;
       
       if(min == f1){
           p2++;
       }
       
       if(min == f2){
           p3++;
       }
       
       if(min == f3){
           p5++;
       }
       
   }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

}