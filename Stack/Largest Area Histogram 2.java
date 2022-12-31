import java.io.*;
import java.util.*;

public class Main {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxArea = 0;
        
        for(int i = 0; i <= heights.length; i++){
            int val = i == heights.length?0:heights[i];
            
            while(st.peek() != -1 && heights[st.peek()] >=  val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea, h*(rm-lm-1));
            }
            
            st.push(i);
        }
        
        
        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
        
    }
}