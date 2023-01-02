import java.io.*;
import java.util.*;

public class Main {

  public static int[] m1(int[] arr, int lo, int hi) {
    //write your code here
    if(lo == hi){
        int[] ba = new int[1];
        ba[0] = arr[lo];
        return ba;
    }

    int mid = (lo + hi) / 2;
    
    int[] fs = m1(arr, lo, mid);
    
    int[] sh = m1(arr, mid + 1, hi);
    
    int[] fsh = m(fs, sh);
    
    return fsh;
  }

  //used for merging two sorted arrays
  public static int[] m(int[] a, int[] b){
    System.out.println("Merging these two arrays ");
    System.out.print("left array -> ");
    print(a);
    System.out.print("right array -> ");
    print(b);
    int i = 0, j =0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i < a.length && j < b.length){
        if(a[i] <= b[j]){
          ans[k] = a[i];
          i++;
          k++;
        }else{
          ans[k] = b[j];
          j++;
          k++;
        }
    }

    while(i < a.length){
      ans[k] = a[i];
      k++;
      i++;
    }

    while(j < b.length){
      ans[k] = b[j];
      k++;
      j++;
    }
    
    return ans;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int[] sa = m1(arr,0,arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(sa);
  }

}