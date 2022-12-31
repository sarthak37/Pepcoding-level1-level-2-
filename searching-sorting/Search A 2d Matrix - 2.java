import java.util.*;
import java.io.*;

public class Main {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return true;
            }
            
            else if(matrix[r][c] > target){
                c--;
            }
            
            else {
                r++;
            }
        }
        
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}