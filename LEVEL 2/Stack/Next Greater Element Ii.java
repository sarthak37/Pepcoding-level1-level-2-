import java.io.*;
import java.util.*;

public class Main {
    public static int[] nextGreaterElementII(int[] nums) {
       int n = nums.length;
       
       Stack<Integer> st = new Stack<>();
       
       for(int i = n - 2; i >= 0; i--){
           while(st.size() > 0 && st.peek() <= nums[i]){
               st.pop();
           }
           
           st.push(nums[i]);
       }
       
       int ans[] = new int[n];
       
       for(int i = n - 1; i >= 0; i--){
           while(st.size() > 0 && st.peek() <= nums[i]){
               st.pop();
           }
           ans[i] = st.size() == 0 ? -1:st.peek();
           st.push(nums[i]);
       }
       
       return ans;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}