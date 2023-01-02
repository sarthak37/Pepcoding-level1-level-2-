import java.util.*;
import java.io.*;

public class Main {

  public static boolean shouldPunish(int[]roll, int[]marks, double avg) {
    //write your code here
    int s = 0;
    int n = roll.length;
    
    for(int j = 1; j <= n - 1; j++){
        for(int i = 0; i < n - j; i++){
            if(roll[i] > roll[i+ 1]){
                s = s + 2;
                int t = roll[i];
                roll[i] = roll[i + 1];
                roll[i + 1] = t;
            }
        }
    }
    
    int o = 0;
    
    for(int i = 0; i < marks.length; i++){
        o = o + marks[i];
    }
    
    int n1 = o - s;
    
    double nav = (n1 * 1.0) / n;
    
    return nav >= avg;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]roll = new int[n];

    for (int i = 0; i < n; i++) {
      roll[i] = scn.nextInt();
    }

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    double avg = scn.nextDouble();

    System.out.println(shouldPunish(roll, marks, avg));
  }
}