import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr, int k) {
    // write your code here
    int ans = Integer.MIN_VALUE;
    
    int[] maxSum = new int[arr.length];
    
    int csum = arr[0];
    maxSum[0] = csum;
    for(int i = 1; i < arr.length; i++){
        if(csum > 0){
            csum += arr[i];
        } else {
            csum = arr[i];
        }
        
        maxSum[i] = csum;
    }
    
    int exactK = 0;
    for(int i = 0; i < k; i++){
        exactK += arr[i];
    }
    
    if(exactK > ans){
        ans = exactK;
    }
    
    for(int i = k; i < arr.length; i++){
        exactK = exactK + arr[i] - arr[i - k];
        
        if(exactK > ans){
            ans = exactK;
        }
        
        int morethanK = maxSum[i - k] + exactK;
        if(morethanK > ans){
            ans = morethanK;
        }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k));
  }
}