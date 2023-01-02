// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    if(i == board.length){
        display(board);
        return;
    }
    
    int ni = 0;
    int nj = 0;
    
    if(j == board[0].length - 1) {
        ni = i + 1;
        nj = 0;
    } else {
        ni = i;
        nj = j + 1;
    }
    
    if(board[i][j] != 0){
        solveSudoku(board, ni, nj);
    } else {
        for(int po = 1; po <= 9; po++){
            if(isValid(board, i, j, po) == true){
                board[i][j] = po;
                solveSudoku(board, ni, nj);
                board[i][j] = 0;
            }
        }
    }
  }
  
  public static boolean isValid(int[][] board, int x, int y, int val){
      for(int j = 0; j < board[0].length; j++){
          if(board[x][j] == val){
              return false;
          }
      }
      
      for(int i = 0 ; i < board.length; i++){
          if(board[i][y] == val){
              return false;
          }
      }
      
      int smi = x / 3 * 3;
      int smj = y / 3 * 3;
      for(int i = 0 ; i < 3; i++){
          for(int j = 0 ; j < 3; j++){
              if(board[smi + i][smj + j] == val){
                  return false;
              }
          }
      }
      
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}