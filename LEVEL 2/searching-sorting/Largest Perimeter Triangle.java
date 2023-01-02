import java.util.*;
import java.io.*;

public class Main {
  public static int largestPerimeter(int[]nums) {
    //write your code here
    Arrays.sort(nums);
    
    int p = 0;
    
    for(int i = nums.length - 1; i >=2; i--){
        if(nums[i - 1] + nums[i - 2] > nums[i]){
            p = nums[i - 1] + nums[i - 2] + nums[i];
            break;
        }
    }
    
    return p;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = scn.nextInt();
    }

    System.out.println(largestPerimeter(nums));
  }
}