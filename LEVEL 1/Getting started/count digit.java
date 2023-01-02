import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int d = 0;
    while(n != 0){
        n = n / 10;
        d = d + 1;
    }
    
    System.out.print(d);
    
   }
  }