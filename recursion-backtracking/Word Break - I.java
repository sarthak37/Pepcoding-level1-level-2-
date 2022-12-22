import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		w(sentence,"", dict);
	}

	public static void w(String str, String ans, HashSet<String> dict){
		// write your code here
		if(str.length() == 0){
		    System.out.println(ans);
		    return;
		}
		
		for(int i = 0; i < str.length(); i++){
		    String l = str.substring(0, i + 1);
		    if(dict.contains(l)){
		        String r = str.substring(i + 1);
		        w(r, ans + l + " ", dict);
		    }
		}
	}
		
}