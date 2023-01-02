import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(br.readLine());
         }
      }

      int s = Integer.parseInt(br.readLine());
      int r = Integer.parseInt(br.readLine());
      shellrotate(arr, s, r);
      display(arr);
   }

   public static void shellrotate(int[][] arr, int s, int r) {
      int[] larr = fillLinear(arr, s);
      rotate(larr, r);
      fill2d(arr, larr, s);
   }

   public static int[] fillLinear(int[][] arr, int s) {
      int r2d = arr.length;
      int c2d = arr[0].length;
      int rshell = r2d - 2 * (s - 1);
      int cshell = c2d - 2 * (s - 1);
      int szshell = 2 * (rshell + cshell) - 4;

      int[] larr = new int[szshell];

      int rmin = s - 1;
      int cmin = s - 1;
      int rmax = arr.length - 1 - (s - 1);
      int cmax = arr[0].length - 1 - (s - 1);

      // left wall
      int idx = 0;
      for (int i = rmin; i <= rmax; i++) {
         larr[idx] = arr[i][cmin];
         idx++;
      }

      // bottom wall
      for (int j = cmin + 1; j <= cmax; j++) {
         larr[idx] = arr[rmax][j];
         idx++;
      }

      // right wall
      for (int i = rmax - 1; i >= rmin; i--) {
         larr[idx] = arr[i][cmax];
         idx++;
      }

      // top wall
      for (int j = cmax - 1; j >= cmin + 1; j--) {
         larr[idx] = arr[rmin][j];
         idx++;
      }

      return larr;
   }

   public static void fill2d(int[][] arr, int[] larr, int s) {
      int rmin = s - 1;
      int cmin = s - 1;
      int rmax = arr.length - 1 - (s - 1);
      int cmax = arr[0].length - 1 - (s - 1);

      // left wall
      int idx = 0;
      for (int i = rmin; i <= rmax; i++) {
         arr[i][cmin] = larr[idx];
         idx++;
      }

      // bottom wall
      for (int j = cmin + 1; j <= cmax; j++) {
         arr[rmax][j] = larr[idx];
         idx++;
      }

      // right wall
      for (int i = rmax - 1; i >= rmin; i--) {
         arr[i][cmax] = larr[idx];
         idx++;
      }

      // top wall
      for (int j = cmax - 1; j >= cmin + 1; j--) {
         arr[rmin][j] = larr[idx];
         idx++;
      }
   }

   public static void rotate(int[] larr, int r) {
      r = r % larr.length;
      if (r < 0) {
         r += larr.length;
      }

      reverse(larr, 0, larr.length - 1 - r);
      reverse(larr, larr.length - r, larr.length - 1);
      reverse(larr, 0, larr.length - 1);
   }

   public static void reverse(int[] arr, int i1, int i2) {
      int li = i1;
      int ri = i2;
      while (li < ri) {
         int temp = arr[li];
         arr[li] = arr[ri];
         arr[ri] = temp;

         li++;
         ri--;
      }
   }

   public static void display(int[][] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

}