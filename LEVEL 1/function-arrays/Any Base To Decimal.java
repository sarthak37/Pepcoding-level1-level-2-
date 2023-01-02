import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      int rv = 0;
      
      int p = 0;
      while(n > 0){
          int dig = n % 10;
          n = n / 10;
          
          rv += dig * Math.pow(b, p);
          p = p + 1;
      }
      
      return rv;
   }
  }