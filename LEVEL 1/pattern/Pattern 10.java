import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nos = n / 2;
    int nis = -1;
    
    for(int i = 1; i <=n; i++){
        for(int j = 1; j <= nos; j++){
                System.out.print("	");
            } 
            System.out.print("*	");
            
            for(int j = 1; j <= nis; j++){
                System.out.print("	");
            }
            
            if(i > 1 && i < n){
                System.out.print("*	");
            }
            
            if(i <= n / 2){
                nos--;
                nis += 2;
            } else {
                nos++;
                nis -= 2;
            }
        
        System.out.println();
 }

}

 }