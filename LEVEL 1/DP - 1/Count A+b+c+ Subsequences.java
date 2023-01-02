import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        int a = 0;
        int ab = 0;
        int abc = 0;
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == 'a'){
                a = 2 * a + 1;
            } else if(ch == 'b'){
                ab = 2 * ab + a;
            } else if(ch == 'c'){
                abc = 2 * abc + ab;
            }
        }
        
        System.out.println(abc);

    }
}