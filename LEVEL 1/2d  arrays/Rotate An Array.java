import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
  
  public static void r(int[] a, int i, int j){
      int li = i;
      int ri = j;
      
      while(li < ri){
          int temp = a[li];
          a[li] = a[ri];
          a[ri] = temp;
          
          li++;
          ri--;
      }
  }

  public static void rotate(int[] a, int k){
    // write your code here
    k = k % a.length;
    if(k < 0){
        k = k + a.length;
    }
    
    r(a, 0, a.length - k -1);
    r(a, a.length - k, a.length - 1);
    r(a, 0, a.length - 1);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}