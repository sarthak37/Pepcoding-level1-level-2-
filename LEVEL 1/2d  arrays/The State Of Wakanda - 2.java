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
        
        for(int g = 0; g < arr.length; g++){
            for(int i = 0, j = g; j < arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }

}