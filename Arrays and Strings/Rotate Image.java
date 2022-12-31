import java.util.*;

public class Main {
    public static void transpose(int[][] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    public static void reverseRow(int[][] arr) {
        for(int r = 0; r < arr.length; r++) {
            int left = 0;
            int right = arr.length - 1;
            
            while(left < right) {
                int temp = arr[r][left];
                arr[r][left] = arr[r][right];
                arr[r][right] = temp;
                
                left++;
                right--;
            }
        }
    }

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static void rotate(int[][] matrix) {
    // write your code here
    transpose(matrix);
    
    reverseRow(matrix);
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }
    rotate(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}