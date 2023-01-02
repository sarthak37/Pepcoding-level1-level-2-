import java.io.*;
import java.util.*;

public class Main {

    public static int maximalRectangle(int[][] ar) {           
        int heights[] = new int[ar[0].length];
        
        for(int i = 0; i < ar[0].length;i++){
            heights[i] = ar[0][i];
        }
        
        int area = l(heights);
        
        for(int i = 1; i < ar.length; i++){
            for(int j = 0; j < ar[0].length; j++){
                if(ar[i][j] == 1){
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            
            area = Math.max(area, l(heights));
        }
        
        return area;
    }
    
    public static int l(int[] heights) {
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

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }
}