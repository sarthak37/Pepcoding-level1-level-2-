import java.util.*;

public class Main {

	public static boolean wordPattern(String pattern, String str) {
		// write your code here
			String[] w = str.split(" ");
		
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Boolean> used = new HashMap<>();
		
		for(int i = 0; i < pattern.length();i++){
		    char ch = pattern.charAt(i);
		    
		    if(map.containsKey(ch) == false){
		        if(used.containsKey(w[i]) == true){
		            return false;
		        } else {
		            used.put(w[i],true);
		            map.put(ch, w[i]);
		        }
		    } else {
		        String mw = map.get(ch);
		        if(mw.equals(w[i]) == false){
		            return false;
		        }
		    }
		}
		return true;
	
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

}