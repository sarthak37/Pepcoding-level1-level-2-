import java.io.*;
import java.util.*;

public class Main {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '('){
                st.push(-1);
            } else {
                if(st.peek() == -1){
                    st.pop();
                    st.push(1);
                } else {
                    int v = 0;
                    while(st.peek() != -1){
                        v = v + st.pop();
                    }
                    st.pop();
                    st.push(2*v);
                }
            }
        }
        
        int v = 0;
        while(st.size() > 0){
            v = v + st.pop();
        }
        
        return v;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}