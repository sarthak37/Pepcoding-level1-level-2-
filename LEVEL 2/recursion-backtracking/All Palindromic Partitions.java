import java.io.*;
import java.util.*;

public class Main {
    public static boolean i1(String str){
        int li = 0;
        int ri = str.length() - 1;
        while(li < ri){
            char left = str.charAt(li);
            char right = str.charAt(ri);
            if(left != right){
                return false;
            }
            
            li++;
            ri--;
        }
        
        return true;
    }

	public static void s(String str, String asf) {
		//write you code here
		if(str.length() == 0){
		    System.out.println(asf);
		    return;
		}
		
		for(int i = 0; i < str.length(); i++){
		    String p = str.substring(0, i + 1);
		    String r = str.substring(i + 1);
		    if(i1(p)){
		        s(r, asf + "(" + p + ") ");
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		s(str, "");
	}

}