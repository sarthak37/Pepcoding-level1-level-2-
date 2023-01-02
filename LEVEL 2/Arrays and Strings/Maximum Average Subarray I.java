import java.util.Scanner;

public class Main {
  public static double solution(int nums[], int k) {
    // write your code here
    int sum = 0;
    for(int i = 0; i < k; i++){
        sum = sum + nums[i];
    }
    
    int max = sum;
    
    for(int i = k; i < nums.length; i++){
        sum = sum + nums[i];
        sum = sum - nums[i - k];
        max = Math.max(max,sum);
    }
    
    return (max * 1.0) / k;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nums[] = new int[n];
    for (int i = 0 ; i < n ; i++) {
      nums[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    System.out.println(solution(nums, k));
  }
}