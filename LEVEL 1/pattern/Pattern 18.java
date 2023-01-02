import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int st = n;
    int sp = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= sp; j++){
            System.out.print("	");
        }
        
        for(int j = 1; j <= st; j++){
            if(i > 1 && i <= n / 2 && j > 1 && j < st){
                  System.out.print("	");
            } else {
                 System.out.print("*	");
            }
           
        }
        
        if(i <= n / 2){
            sp++;
            st -= 2;
        } else {
            sp--;
            st += 2;
        }
        
        System.out.println();
        
    }

 }
}