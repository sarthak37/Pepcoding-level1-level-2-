import java.io.*;
import java.util.*;

public class Main {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int f[] = new int[26];
        boolean e[] = new boolean[26];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            f[ch - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            f[ch - 'a']--;
            if(e[ch - 'a']) continue;
            
            while(st.size() > 0 && st.peek() > ch && f[st.peek() - 'a'] > 0){
                char rem = st.pop();
                e[rem - 'a'] = false;
            }
            
            st.push(ch);
            e[ch - 'a'] = true;
        }
        
        char a[] = new char[st.size()];
        int i = a.length - 1;
        while(i >= 0) a[i--] = st.pop();
        
        return new String(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicateLetters(read.readLine());
        System.out.println(result);
        
    }
}