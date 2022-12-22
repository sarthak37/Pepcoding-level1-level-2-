import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // write your code here
        if(i - 1 >= 0 && j - 2 >= 0 && chess[i - 1][j - 2]){
            return false;
        }
        
         if(i - 2 >= 0 && j - 1 >= 0 && chess[i - 2][j - 1]){
            return false;
        }
        
         if(i - 2 >= 0 && j + 1 < chess.length && chess[i - 2][j + 1]){
            return false;
        }
        
        if(i - 1 >= 0 && j + 2 < chess.length && chess[i - 1][j + 2]){
            return false;
        }
        
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k	" : "-	");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}