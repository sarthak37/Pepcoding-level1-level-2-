import java.io.*;
import java.util.*;

public class Main {

  public static int validSubarrays(int[] nums) {
      Stack<Integer> st = new Stack<>();
      int ans= 0;
      
      for(int i = nums.length - 1; i >= 0;i--){
          int val = nums[i];
          while(st.size() > 0 && nums[st.peek()] >= val)st.pop();
          int si = nums.length;
          if(st.size() > 0)si = st.peek();
          ans += si - i;
          st.push(i);
      }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(read.readLine());
    }

    int count = validSubarrays(nums);

    System.out.println(count);

  }
}