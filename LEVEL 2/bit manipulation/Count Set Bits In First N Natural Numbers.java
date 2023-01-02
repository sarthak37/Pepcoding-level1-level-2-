import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

  public static int solution(int n){
    //write your code here
    if(n == 0){
        return 0;
    }
    
    int x = l(n);
    int b = x * (1 << (x - 1));
    int m = n - (1 << x) + 1;
    int r = n - (1 << x);
    int a = b + m +solution(r);
    return a;
  }
  
  public static int l(int n) {
      int x = 0;
      
      while((1 << x) <= n) {
          x++;
      }
      
      return x - 1;
  }

}