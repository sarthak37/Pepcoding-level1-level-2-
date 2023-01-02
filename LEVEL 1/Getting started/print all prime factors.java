import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  
  int n2 = 2;
  while(n2 * n2 <= n){
      while(n % n2 == 0){
          n = n / n2;
          System.out.print(n2 + " ");
      }
      n2++;
  }
  
  if(n != 1){
      System.out.print(n + " ");
  }
 }
}