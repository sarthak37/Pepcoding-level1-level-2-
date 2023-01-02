import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = 0; int st = n;
        // write ur code here
        for (int i = 1; i <= n; i++){
             for(int j = 1; j <= sp; j++){
                System.out.print("	");
            }
            for(int j = 1; j <=st; j++){
                System.out.print("*	");
            }
            
           
            
            sp++;
            st--;
            System.out.println();
        }

    }
}