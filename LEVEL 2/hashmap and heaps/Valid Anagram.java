import java.util.*;

public class Main {
	
	public static boolean solution(String s1, String s2){
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s1.length(); i++){
		    char ch = s1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(int i = 0; i < s2.length(); i++){
		    char ch = s2.charAt(i);
		    
		    if(map.containsKey(ch) == false){
		        return false;
		    } else if(map.get(ch) == 1){
		        map.remove(ch);
		    } else  {
		        map.put(ch, map.get(ch) - 1);
		    }
		}

		return map.size() == 0;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}