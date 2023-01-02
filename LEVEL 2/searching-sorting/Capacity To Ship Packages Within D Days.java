import java.util.*;
import java.io.*;

public class Main {

  public static int shipWithinDays(int[]wt, int days) {
    //write your code here
    int max = 0;
    int sum = 0;
    
    for(int val : wt) {
        sum = sum + val;
        max =  Math.max(max,val);
    }
    
    if(wt.length == days){
        return max;
    }
    
    int lo = max;
    int hi = sum;
    int ans = 0;
    
    while(lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(I(wt,mid,days) == true){
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    
    return ans;
  }
  
  public static boolean I(int[]wt, int mid, int days) {
      int d = 1;
      int sum = 0;
      
      for(int i = 0; i < wt.length; i++) {
          sum = sum + wt[i];
          
          if(sum > mid){
              d++;
              sum = wt[i];
          }
      }
      
      return d <= days;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}