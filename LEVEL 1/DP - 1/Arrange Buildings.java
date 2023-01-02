import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    
    long ob = 1;
    long os = 1;
    
    for(long i = 2; i <= n;i++){
        long nb = os;
        long ns = os + ob;
        
        os = ns;
        ob = nb;
    }
    
    long total= os + ob;
    total = total * total;
    
    System.out.println(total);
 }

}