import java.util.*;
import java.io.*;

public class Main {

    public static int pivot_index(int[]arr) {
        //write your code here
        int s = 0;
        
        for(int i = 0; i < arr.length; i++){
            s += arr[i];
        }
        
        int ls = 0;
        
        int rs = s;
        
        for(int i = 0; i < arr.length; i++){
            rs = rs - arr[i];
            
            if(ls == rs){
                return i;
            }
            
            ls = ls +  arr[i];
            
        }
        
        return -1;
        
     
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}