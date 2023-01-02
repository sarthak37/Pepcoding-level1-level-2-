import java.util.*;

public class Main{
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
       
        for(int n = low ; n <= high; n++){
             int ct = 0;
             
             for(int j = 2; j * j <= n; j++){
                if(n % j == 0){
                    ct++;
                    break;
                }
            }
                
            if(ct == 0){
                System.out.println(n);
            }
            
        }
        
    }
}