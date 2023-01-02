import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int dir = 0;
        
        int i = 0;
        
        int j = 0;
        
        while(true){
            dir = (dir + arr[i][j]) % 4;
            
            if(dir == 0){
                j++;
            } else if(dir == 1){
                i++;
            } else if(dir == 2){
                j--;
            } else {
                i--;
            }
            
            if(i < 0){
                i++;
                break;
            } else if(j < 0){
                j++;
                break;
            } else if(i == arr.length){
                i--;
                break;
            } else if(j == arr[0].length){
                j--;
                break;
            }
        }
        
        System.out.println(i);
        System.out.println(j);
    }

}