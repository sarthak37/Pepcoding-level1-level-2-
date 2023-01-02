import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            int svj = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] < arr[i][svj]){
                    svj = j;
                }
            }
            
            boolean flag = true;
            for(int k = 0; k < arr.length; k++){
                if(arr[k][svj] > arr[i][svj]){
                    flag = false;
                    break;
                }
            }
            
            if(flag == true){
                System.out.println(arr[i][svj]);
                return;
            }
        }
        
        System.out.println("Invalid input");
    }

}