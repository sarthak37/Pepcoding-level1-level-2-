import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
		
		HashMap<String, Boolean> psrc = new HashMap<>();
		for(String src: map.keySet()){
		    String dest=map.get(src);
		
		
		psrc.put(dest, false);
		if(psrc.containsKey(src) == false){
		    psrc.put(src, true);
		}
		
		}
		
		String src = "";
		for(String pot: psrc.keySet()){
		    Boolean val = psrc.get(pot);
		    if(val == true){
		        src = pot;
		        break;
		    }
		}
		
		while(true){
		    if(map.containsKey(src) == true){
		        System.out.print(src + " -> ");
		        src = map.get(src);
		    } else {
		        System.out.print(src + ".");
		        break;
		    }
		}


	}
}