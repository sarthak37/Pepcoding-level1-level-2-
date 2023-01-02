import java.util.*;
import java.io.*;

public class Main {

  public static int[] find(int[]arr1, int[]arr2) {
    //write your code here
    int max1 = 0;
    int max2 = 0;
    
    for(int val : arr1) {
        max1 = Math.max(max1,val);
    }
    
    for(int val : arr2) {
        max2 = Math.max(max2,val);
    }
    
    int omax = Math.max(max1,max2);
    
    int[]farr = new int[100000];
    
    for(int i = 0; i < arr2.length; i++) {
        farr[arr2[i]]++;
    }
    
    int[] psa = new int[100000];
    psa[0] = farr[0];
    
    for(int i = 1; i < psa.length; i++){
        psa[i] = psa[i - 1] + farr[i];
    }
    
    int[] ans = new int[arr1.length];
    
    for(int i = 0; i < arr1.length; i++) {
        int key = arr1[i];
        ans[i] = psa[key];
    }
    
    return ans;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[]a = new int[n1];

    for (int i = 0; i < n1; i++) {
      a[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[]b = new int[n2];

    for (int i = 0; i < n2; i++) {
      b[i] = scn.nextInt();
    }

    int[]ans = find(a, b);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}