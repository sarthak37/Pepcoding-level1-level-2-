import java.util.*;
import java.io.*;

public class Main {

  public static int findTransition(int[]arr) {
   int tp = -1;
   int lo = 0;
   int hi = arr.length - 1;
   
   while(lo <= hi){
       int mid = (lo + hi) / 2;
       
       if(arr[mid] == 1){
           tp = mid;
           hi = mid - 1;
       } else {
           lo = mid + 1;
       }
   }
   
   return tp;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(findTransition(arr));
  }
}