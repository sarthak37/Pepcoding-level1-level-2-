import java.util.*;
import java.io.*;

public class Main {

  public static int findRow(int[][]mat) {
    //write your code here
    int om = 0;
    int r = 0;
    
    for(int i = 0; i < mat.length; i++){
        int co = b(mat, i);
        
        if(co > om){
            om = co;
            r = i;
        }
    }
    
    return r;
  }
  
  public static int b(int[][]mat, int r) {
      int lo = 0;
      int hi = mat[0].length - 1;
      int fl1 = mat[0].length;
      
      while(lo <= hi){
          int mid = (lo + hi) / 2;
          
          if(mat[r][mid] == 1){
              fl1 = mid;
              hi = mid - 1;
          } else {
              lo = mid + 1;
          }
      }
      
      int c = mat[0].length - fl1;
      return c;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][]mat = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(findRow(mat));
  }
}