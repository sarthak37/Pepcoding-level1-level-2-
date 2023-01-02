import java.io.*;
import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        //write your code here
        int rbytes = 0;
        
        for(int val : arr){
            if(rbytes == 0){
                if((val >> 7) == 0b0){
                    rbytes = 0;
                } else if((val >> 5) == 0b110){
                    rbytes = 1;
                } else if((val >> 4) == 0b1110){
                    rbytes = 2;
                } else if((val >> 3) == 0b11110){
                    rbytes = 3;
                }
            } else {
                if((val >> 6) == 0b10){
                    rbytes--;
                } else {
                    return false;
                }
            }
        }
        
        if(rbytes == 0){
            return true;
        } else {
            return false;
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}