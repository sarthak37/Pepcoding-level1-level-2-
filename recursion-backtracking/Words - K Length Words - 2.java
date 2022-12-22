import java.io.*;
import java.util.*;

public class Main {
    
    public static void c(int cs, int ts, String ustr, HashSet<Character> used,String asf){
        if(cs > ts){
            System.out.println(asf);
            return;
        }
        
        for(int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            if(used.contains(ch) == false){
                used.add(ch);
                c(cs + 1, ts, ustr, used, asf + ch);
                used.remove(ch);
            }
        }
    }

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

  
  c(1, k, ustr, new HashSet<>(), "");
  }

}