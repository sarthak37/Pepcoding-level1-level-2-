import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int of = hm.get(ch);
                int nf = of + 1;
                hm.put(ch, nf);
            } else {
                hm.put(ch, 1);
            }
        }
        
        char mf = str.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key) > hm.get(mf)){
                mf = key;
            }
            
        }
        
        System.out.println(mf);
        
        
    }

}