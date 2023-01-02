import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    Stack<Integer> st = new Stack<>();
    int num = 1;
    
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        
        if(ch == 'd'){
            st.push(num);
            num++;
        } else {
            st.push(num);
            num++;
            
            while(st.size() > 0){
                System.out.print(st.pop());
            }
        }
    }
    
    st.push(num);
    while(st.size() > 0){
        System.out.print(st.pop());
    }
 }
}