import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        map.put(ch, -1);
    }
    int k = Integer.parseInt(br.readLine());
    
    fun(str, map, 0, new Character[k], 0, k);
  }
  
  public static void fun(String str, HashMap<Character, Integer> map, int idx, Character[] spots, int ssf, int ts){
      if(idx == str.length()){
          if(ssf == ts){
              for(int i = 0; i < spots.length; i++){
                  System.out.print(spots[i]);
              }
              System.out.println();
          }
          return; 
      }
      
      char ch = str.charAt(idx);
      int lo = map.get(ch);
      for(int i = lo + 1; i < spots.length;i++){
          if(spots[i] == null){
              spots[i] = ch;
              map.put(ch, i);
              fun(str,map, idx + 1, spots, ssf + 1, ts);
              spots[i] = null;
              map.put(ch, lo);
          }
      }
      if(lo == -1){
          fun(str, map, idx + 1, spots, ssf, ts);
      }
  }

}