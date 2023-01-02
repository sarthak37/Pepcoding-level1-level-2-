import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      
      for(int i = 0; i < t; i++){
           int n = scn.nextInt();
           
           int ct = 0;
           for(int j = 2; j * j <= n; j++){
           if(n % j == 0){
               ct++;
           }
       }
       
      
       
       if(ct == 0){
           System.out.println("prime");
       } else {
           System.out.println("not prime");
       }
       
      }
  
   }
  }