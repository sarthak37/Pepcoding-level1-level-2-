import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());

        // write your code here
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        while(k > 0){
            st.pop();
            k--;
        }
        
        char ans[] = new char[st.size()];
        int h = ans.length - 1;
        while(h >= 0) ans[h--] = st.pop();
        
        int d = 0;
        while(d < ans.length && ans[d] == '0') d++;
        
        StringBuilder sb = new StringBuilder();
        
        while(d < ans.length)sb.append(ans[d++]);
        if(sb.length() == 0) sb.append("0");
        System.out.println(sb);
    }
}