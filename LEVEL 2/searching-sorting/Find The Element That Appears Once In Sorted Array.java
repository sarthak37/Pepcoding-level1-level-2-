import java.util.*;
import java.io.*;

public class Main {

  public static int findSingleElement(int[]arr) {
    //write your code here
    int n = arr.length;
    
    if(n == 1){
        return arr[0];
    }
    if(arr[0] != arr[1]) {
        return arr[0];
    }
    if(arr[n - 1] != arr[n -2]) {
        return arr[n - 1];
    }
    
    int lo = 0;
    int hi = arr.length - 1;
    
    while(lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
            return arr[mid];
        }
        else if(arr[mid] == arr[mid - 1]) {
            int lc = mid - lo + 1;
            
            if(lc % 2 == 0){
                lo = mid + 1;
            } else {
                hi = mid - 2;
            }
        } else if(arr[mid] == arr[mid + 1]) {
            int rc = hi - mid + 1;
            
            if(rc % 2 == 0){
                hi = mid - 1;
            } else {
                lo = mid + 2;
            }
        }
    }
    
    return -1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = findSingleElement(arr);
    System.out.println(ans);
  }
}