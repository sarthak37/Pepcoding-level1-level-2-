import java.util.*;
import java.io.*;

public class Main {
  public static int countBuildings(int[]ht) {
    //write your code here
    int lmax = ht[0];
    int c = 1;
    
    for(int i = 1; i < ht.length; i++){
        if(ht[i] > lmax){
            c++;
            lmax = ht[i];
        }
    }
    
    return c;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]ht = new int[n];

    for (int i = 0; i < n; i++) {
      ht[i] = scn.nextInt();
    }

    System.out.println(countBuildings(ht));
  }
}