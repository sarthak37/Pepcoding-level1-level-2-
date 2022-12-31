import java.util.*;
import java.io.*;

public class Main {

  public static int splitArray(int[]arr, int m) {
    int max = 0;
    int sum = 0;
    
    for(int val : arr) {
        sum = sum + val;
        max = Math.max(val, max);
    }
    
    if(m == arr.length) {
        return max;
    }
    
    int lo = max;
    int hi = sum;
    int ans = 0;
    
    while(lo <= hi) {
        int mid = (lo + hi) / 2;
        
        if(I(arr,mid,m) == true) {
            ans = mid;
            hi = mid - 1;
        }
        else {
            lo = mid + 1;
        }
    }
    
    return ans;
  }
  
  public static boolean I(int[]arr,int mid,int m) {
      int sa = 1;
      int sum = 0;
      
      for(int i = 0; i < arr.length; i++){
          sum += arr[i];
          
          if(sum > mid){
              sa++;
              sum = arr[i];
          }
      }
      
      return sa <= m;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = splitArray(arr, m);
    System.out.println(ans);
  }
}