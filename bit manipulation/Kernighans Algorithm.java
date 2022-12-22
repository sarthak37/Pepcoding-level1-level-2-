import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int c = 0;
    while(n != 0){
        int rs = n & -n;
        n = n - rs;
        c++;
    }
    
    System.out.println(c);
  }

}