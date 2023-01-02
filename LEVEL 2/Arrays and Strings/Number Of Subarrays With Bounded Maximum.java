import java.util.*;

public class Main {

  public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
    // write your code here
    int si = 0;
    int ei = 0;
    
    int n = arr.length;
    int ans = 0;
    int prevc = 0;
    
    while(ei < n){
        if(left <= arr[ei] && arr[ei] <= right){
            prevc = ei - si + 1;
            ans = ans + prevc;
        } else if(arr[ei] < left){
            ans = ans + prevc;
        } else {
            si = ei + 1;
            prevc = 0;
        }
        
        ei++;
        
        
    }
    
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int left = scn.nextInt();
    int right = scn.nextInt();

    int count = numSubarrayBoundedMax(arr, left, right);
    System.out.println(count);
  }
}