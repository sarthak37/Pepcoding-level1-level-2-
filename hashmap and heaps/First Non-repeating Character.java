import java.util.*;

public class Main {
	
	public static int solution(String s) {
		// write your code here
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
		    char ch = s.charAt(i);
		    fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		    
		}
		
		for(int i = 0; i < s.length(); i++){
		    char ch = s.charAt(i);
		    if(fmap.get(ch) == 1){
		        return i;
		    }
		}
   
		return -1;
	 }
	 
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s= scn.next();
		System.out.print(solution(s));
	}

}