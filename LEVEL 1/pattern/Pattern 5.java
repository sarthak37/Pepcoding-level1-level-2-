import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int sp = n / 2; 
        int str = 1;
        
        for(int i =1; i <= n; i++){
            for(int j = 1; j <= sp; j++){
                System.out.print("	");
            }
            
            for(int j = 1; j <= str; j++){
                System.out.print("*	");
            }
            
            if(i <= n / 2){
                sp--;
                str += 2;
            } else {
                sp++;
                str -= 2;
            }
            System.out.println();
        }

        // write ur code here

    }
}