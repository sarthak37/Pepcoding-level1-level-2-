import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }
  
  public static int getNum(String s, HashMap<Character, Integer> charIntMap){
      String num = "";
      for(int i = 0; i < s.length(); i++){
          num += charIntMap.get(s.charAt(i));
      }
      
      return Integer.parseInt(num);
  }

  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    
	    if(idx == unique.length()){
	        int num1 = getNum(s1, charIntMap);
	        int num2 = getNum(s2, charIntMap);
	        int num3 = getNum(s3, charIntMap);
	        
	        if(num1 + num2 == num3){
	            for(int i = 0; i < 26; i++){
	                char ch = (char)('a' + i);
	                if(charIntMap.containsKey(ch)){
	                    System.out.print(ch + "-" + charIntMap.get(ch));
	                }
	                System.out.println();
	            }
	            
	            return;
	        }
	        
	        char ch = unique.charAt(idx);
	        for(int num = 0; num <= 9; num++){
	            if(usedNumbers[num] == false){
	                charIntMap.put(ch, num);
	                usedNumbers[num] = true;
	                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
	                usedNumbers[num] = false;
	                charIntMap.put(ch, -1);
	            }
	        }
	    }
  }

}