import java.util.*;

public class Main {

	public static String solution(String s1, String s2){
		String a = "";
		
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < s2.length(); i++){
		    char ch = s2.charAt(i);
		    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		
		int mct = 0;
		int dmct = s2.length();
		HashMap<Character , Integer> map1 = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    
		    while(i < s1.length() - 1 && mct < dmct){
		        i++;
		        char ch = s1.charAt(i);
		        map1.put(ch, map1.getOrDefault(ch, 0) + 1);
		        
		        if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
		            mct++;
		        }
		        f1 = true;
		    }
		    
		    while(j < i && mct == dmct){
		        String p = s1.substring(j + 1, i+ 1);
		        if(a.length() == 0 || p.length() < a.length()){
		            a = p;
		        }
		        
		        j++;
		        char ch = s1.charAt(j);
		        if(map1.get(ch)  == 1){
		            map1.remove(ch);
		        } else {
		            map1.put(ch, map1.get(ch) - 1);
		        }
		        
		        if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
		            mct--;
		        }
		        f2 = true;
		    }
		    
		    if(f1 == false && f2 == false){
		        break;
		    }
		}
		
		return a;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}