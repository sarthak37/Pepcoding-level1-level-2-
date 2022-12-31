import java.util.*;

public class Main {

    public static int findMaxSteps(int[]arr) {
        //write your code here
        int ms = 0;
        int c = 0;
        
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[i + 1]){
                c++;
            } else {
                if(c > ms){
                    ms = c;
                }
                
                c = 0;
            }
        }
        
         if(c > ms){
             ms = c;
                }
                
                return ms;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}