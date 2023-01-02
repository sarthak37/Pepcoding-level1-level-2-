import java.io.*;
import java.util.*;

public class Main {
  public static int[] smallest(int[] nums, int k) {
      Stack<Integer> st = new Stack<>();
      int n = nums.length;
      
      for(int i = 0; i < n; i++){
          int val = nums[i];
          
          while(st.size() > 0 && nums[i] < st.peek() && n - i - 1 >= k - st.size()){
              st.pop();
          }
          
          if(st.size() < k){
              st.push(val);
          }
      }
      
      int ans[] = new int[k];
      int i = k - 1;
      while(i >= 0){
          ans[i--] = st.pop();
      }
      
      return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int k = Integer.parseInt(read.readLine());
    int ans[] = smallest(arr, k);
    System.out.println(ans.length);

    for (int e : ans) {
      System.out.println(e);
    }

  }
}