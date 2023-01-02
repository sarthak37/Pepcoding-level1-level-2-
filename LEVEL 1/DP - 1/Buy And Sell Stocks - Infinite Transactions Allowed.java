import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int bd = 0;
        int sd = 0;
        int profit = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i - 1]){
                sd++;
            } else {
                profit = profit + arr[sd] - arr[bd];
                bd = sd = i;
            }
        }
        
        profit = profit + arr[sd] - arr[bd];
        
        System.out.println(profit);
    }

}