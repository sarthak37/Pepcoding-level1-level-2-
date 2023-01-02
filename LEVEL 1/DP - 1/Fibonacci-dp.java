import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fibn = FibMemoized(n, new int[n + 1]);
    System.out.println(fibn);
 }
 
 public static int FibMemoized(int n, int[] qb){
     if(n == 0 || n == 1){
         return n;
     }
     
     if(qb[n] != 0){
         return qb[n];
     }
     
     int fibnm1 = FibMemoized(n - 1, qb);
     int fibnm2 = FibMemoized(n - 2, qb);
     int fibn = fibnm1 + fibnm2;
     
     qb[n] = fibn;
     return fibn;
 }

}