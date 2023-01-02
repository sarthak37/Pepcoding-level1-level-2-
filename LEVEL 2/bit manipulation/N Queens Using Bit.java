import java.io.*;
import java.util.*;

public class Main {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
    // write your code here
    if(row == board.length){
        System.out.println(asf +  ".");
        return;
    }
    
    for(int col = 0; col < board.length; col++){
        if(
            ((cols & (1 << col)) == 0) &&
            ((ndiag & (1 << (row + col))) == 0) &&
            ((rdiag & (1 << (row - col + board.length - 1))) == 0)
                ){
                    board[row][col] = true;
                    cols ^= (1 << col);
                    ndiag ^= (1 << (row + col));
                    rdiag ^= (1 << (row - col + board.length - 1));
                    solution(board, row  + 1, cols, ndiag, rdiag,  asf  + row + "-" + col + ", ");
                    cols ^= (1 << col);
                    ndiag ^= (1 << (row + col));
                    rdiag ^= (1 << (row - col + board.length - 1));
                    board[row][col] = false;
                }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
  }

}