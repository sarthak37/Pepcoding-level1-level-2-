import java.util.*;
import java.io.*;

public class Main {

  public static String largestNumber(int[]nums) {
    //write your code here
    String[] arr = new String[nums.length];
    
    for(int i = 0; i < nums.length; i++) {
        arr[i] = nums[i] + "";
    }
    
    Arrays.sort(arr, (a,b)->{
        long n1 = Long.parseLong(a + b);
        long n2 = Long.parseLong(b + a);
        
        if(n1 > n2){
            return 1;
        } else if (n1 < n2){
            return -1;
        } else {
            return 0;
        }
    });
    
    StringBuilder sb = new StringBuilder("");
    
    for(int i = arr.length - 1; i >= 0; i--){
        sb.append(arr[i]);
    }
    
    return sb.toString();
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestNumber(nums));
  }
}