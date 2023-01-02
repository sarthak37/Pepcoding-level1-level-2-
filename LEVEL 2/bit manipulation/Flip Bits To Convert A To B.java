import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    
    int c = a ^ b;
    
    int z = 0;
    while(c != 0){
        int rsb = (c & -c);
        c = c - rsb;
        z++;
    }
    
    System.out.println(z);

    //write your code here
  }

}