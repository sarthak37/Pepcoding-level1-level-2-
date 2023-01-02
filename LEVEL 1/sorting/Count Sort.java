import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int r = max - min + 1;
   int[] f = new int[r];
   
   for(int i = 0; i < arr.length; i++){
       int idx = arr[i] - min;
       f[idx]++;
   }
   
   for(int i = 1; i < f.length; i++){
       f[i] = f[i] + f[i - 1];
   }
   
   int[] ans = new int[arr.length];
   
   for(int i = arr.length - 1; i >= 0; i--){
       int val = arr[i];
       int pos = f[val - min];
       int idx = pos - 1;
       ans[idx] = val;
       f[val - min]--;
   }
   
   for(int i = 0; i < ans.length; i++){
       arr[i] = ans[i];
   }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}