import java.io.*;
import java.util.*;

public class Main {
  
  private static void optimalbst(int[] keys, int[] frequency, int n) {
    //write your code here
    int[][] dp = new int[n][n];
    
    for(int g = 0; g < dp.length; g++){
        for(int i = 0, j = g; j < n; i++, j++){
            if(g == 0){
                dp[i][j] = frequency[i];
            } else if(g == 1){
                int f1 = frequency[i];
                int f2 = frequency[j];
                dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
            } else {
                int min = Integer.MAX_VALUE;
                int fs = 0;
                for(int x = i; x <= j; x++){
                    fs += frequency[x]; 
                }
                
                for(int k = i; k <= j; k++){
                    int left = k == i? 0: dp[i][k - 1];
                    int right = k == j? 0: dp[k + 1][j];
                    
                    if(left + right + fs < min){
                        min = left + right + fs;
                    }
                }
                
                dp[i][j] = min;
            }
        }
    }
    
    System.out.println(dp[0][n - 1]);
    
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
	optimalbst(keys,frequency,n);
	}

}