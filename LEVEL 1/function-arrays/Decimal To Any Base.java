import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       int rv = 0;
       
       int p = 1;
       while(n > 0){
           int dig = n % b;
           n = n / b;
           
           rv += dig * p;
           p = p * 10;
       }
       
       return rv;
       
       
       
     
       
       
       
       
   }
  }