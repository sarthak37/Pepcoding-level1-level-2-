import java.util.*;
import java.io.*;

public class Main {

    public static double find(int[]a,int[]b) {
       if(a.length > b.length) {
           int[] temp = a;
           a = b;
           b = temp;
       }
       
       int lo = 0;
       int hi = a.length;
       int te = a.length + b.length;
       
       while(lo <= hi){
           int aleft = (lo + hi) / 2;
           int bleft = (te + 1) /2 - aleft;
           
           int a1m1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
           int a1 = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
           int b1m1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
           int b1 = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];
           
           if(a1m1 <= b1 && b1m1 <= a1) {
               double median = 0.0;
               
               if(te % 2 == 0){
                   int lmax = Math.max(a1m1,b1m1);
                   int rmin = Math.min(a1,b1);
                   median = (lmax + rmin) / 2.0;
               }
               else {
                   int lmax = Math.max(a1m1,b1m1);
                   median = lmax;
               }
               
               return median;
           }
           
           else if(a1m1 > b1) {
               hi = aleft - 1;
           }
           else if(b1m1 > a1) {
               lo = aleft + 1;
           }
       }
       
       return 0;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}