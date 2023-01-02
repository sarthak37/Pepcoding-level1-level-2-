import java.io.*;
import java.util.*;

public class Main {
    public static String swap(String str, int i, int j){
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        
        String l = str.substring(0, i);
        String m = str.substring(i + 1, j);
        String r = str.substring(j + 1);
        
        return l + jth + m + ith + r;
    }

	static String max;
	public static void f(String str, int k) {
		//write your code here
		if(Integer.parseInt(str) > Integer.parseInt(max)){
		    max = str;
		}
		
		if(k == 0){
		    return;
		}
		
		for(int i = 0; i < str.length() - 1; i++){
		    for(int j = i + 1; j < str.length(); j++){
		        if(str.charAt(j) > str.charAt(i)){
		            str = swap(str, i, j);
		            f(str, k - 1);
		            str = swap(str, i, j);
		        }
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		f(str, k);
		System.out.println(max);
	}

}