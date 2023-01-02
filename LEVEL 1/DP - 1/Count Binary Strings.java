import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    
    int oczeros = 1;
    int ocones = 1;
    
    for(int i = 2; i <=n; i++){
        int nczeros = ocones;
        int ncones = oczeros + ocones;
        
        ocones = ncones;
        oczeros = nczeros;
    }
    
    System.out.println(oczeros + ocones);
 }

}