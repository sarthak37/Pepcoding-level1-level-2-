import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        int prime;
        int pointer;
        int value;
        
        public Pair(int prime, int pointer, int value){
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }
        
        public int compareTo(Pair o){
            return this.value = o.value;
        }
    }
  
  public static int solution2(int[] primes, int n){
      int[] dp = new int[n + 1];
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int i = 0; i < primes.length; i++){
          pq.add(new Pair(primes[i], 1, primes[i]));
      }
      dp[1] = 1;
      
      for(int i = 2; i <= n; i++){
          Pair rp = pq.remove();
          if(dp[i - 1] != rp.value){
              dp[i] = rp.value;
              i++;
          }
          pq.add(new Pair(rp.prime, rp.pointer + 1, rp.prime * dp[rp.pointer + 1]));
      }
      return dp[n];
  }    

  public static int solution(int[] primes, int n) {
    // write your code here
    int[] pointers = new int[primes.length];
    Arrays.fill(pointers, 1);
    
    int[] dp = new int[n + 1];
    dp[1] = 1;
    
    for(int i = 2; i <= n; i++){
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < primes.length; j++){
            min = Math.min(min, primes[j] * dp[pointers[j]]);
        }
        dp[i] = min;
        for(int j = 0; j < primes.length; j++){
            if(primes[j] * dp[pointers[j]] == min){
                pointers[j]++;
            }
        }
    }
    
    return dp[n];

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int[] primes = new int[k];
    for (int i = 0 ; i < k; i++) {
      primes[i] = scn.nextInt();
    }
    int n = scn.nextInt();
    System.out.println(solution(primes, n));
  }

}