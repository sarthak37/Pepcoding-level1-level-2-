import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

   //write your code here
   int m = (1 << (right - left + 1))
   ;
   m--;
   m = (m <<(left - 1));
   
   m = (m & a);
   b = b | m;
   System.out.println(b);
    
  }

}