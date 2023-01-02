import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int a = scn.nextInt();
     int  b = scn.nextInt();
     int d = x(n, a);
     int h = y(d, b);
     System.out.println(h);
   }
   
  public static int x(int n, int b){
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
   
    public static int y(int d, int b){
       int av = 0;
       
       int q = 1;
       while(d > 0){
           int dig = d % b;
           d = d / b;
           
           av += dig * q;
           q = q * 10;
       }
       
       return av;
       
       
       
     
       
       
       
       
   }
  }