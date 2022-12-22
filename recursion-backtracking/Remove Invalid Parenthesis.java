import java.io.*;
import java.util.*;

public class Main {

	public static void s(String str, int mra, HashSet<String> ans) {
		//write your code here
		if(mra == 0){
		    int mrn = getMin(str);
		    if(mrn == 0){
		        if(!ans.contains(str)){
		            System.out.println(str);
		            ans.add(str);
		        }
		    }
		    
		    return;
		}
		for(int i = 0; i < str.length(); i++){
		    String l = str.substring(0, i);
		    String r = str.substring(i + 1);
		    s(l + r, mra - 1, ans);
		}
	}
	
	public static int getMin(String str){
		//write your code here
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i);
		    if(ch == '('){
		        st.push(ch);
		    } else if(ch == ')'){
		        if(st.size() == 0){
		            st.push(ch);
		        } else if(st.peek() == ')'){
		            st.push(ch);
		        } else if(st.peek() == '('){
		            st.pop();
		        }
		    }
		}
		
		return st.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		s(str, getMin(str),new HashSet<>());
	}
		
}