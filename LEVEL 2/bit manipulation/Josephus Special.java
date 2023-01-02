import java.io.*;
import java.util.*;

public class Main {

  public static int p(int n){
    //write your code here
    int i = 1;
    
    while(i * 2 <= n){
        i = i * 2;
    }
    
    return i;
  }
  
   public static int s(int n){
       int h = p(n);
       int l = n - h;
       return 2 * l + 1;
   }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(s(n));
  }
  

}