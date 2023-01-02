import java.util.*;
import java.io.*;

public class Main {

  public static int countZeros(int[][]mat) {
    int n = mat.length;
    int i = 0;
    int j = n - 1;
    
    int cz = 0;
    
    while(i < n && j >= 0){
        if(mat[i][j] == 1){
            j--;
        } 
        else {
            cz = cz + j + 1;
            i++;
        }
    }
    
    return cz;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][]mat = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(countZeros(mat));
  }
}