import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        for(int i = 0; i < n; i++){
            int v = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(v+ "	");
                int z = v * (i - j) / (j + 1);
                v = z;
            }
            
            System.out.println();
        }
        
        

        //write your code here

    }
}