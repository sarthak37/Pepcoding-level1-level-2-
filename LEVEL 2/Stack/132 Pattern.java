import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int min[] = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for(int j = n - 1; j >= 0;j--){
            while(st.size() > 0 && st.peek() <= min[j])st.pop();
            if(st.size() > 0 && st.peek() < nums[j]){
                found = true;
                    break;
                }
                st.push(nums[j]);
            }
            
            System.out.println(found);
        }

      
    }