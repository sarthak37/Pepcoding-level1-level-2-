import java.util.*;

public class Main {
	public static boolean areKAnagrams(String s1, String s2, int k) {
	if(s1.length() != s2.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s1.length(); i++){
            char ch = s2.charAt(i);
             if(map.getOrDefault(ch, 0) > 0){
		        map.put(ch, map.get(ch) - 1);
		    }
        }
        
        int c = 0;
        for(char ch:map.keySet()){
            c = c  + map.get(ch);
        }
        
        if(c > k){
            return false;
        } else {
            return true;
        }
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}