import java.io.*;
import java.util.*;

public class Main {
  public static int islandPerimeter(int[][] grid) {
    //Code Here
    
    int p = 0;
    for(int i = 0; i  < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
                p += 4;
            
            if(i > 0 && grid[i - 1][j] == 1){
                p -= 2;
            }
            
            if(j > 0 && grid[i][j - 1] == 1){
                p -= 2;
            }
        }
        
        
        
    }
}
    
    return p;


  }

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();

    int[][] grid = new int[row][col];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        grid[i][j] = sc.nextInt();
      }
    }

    System.out.println(islandPerimeter(grid));
  }
}