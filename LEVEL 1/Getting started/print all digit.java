import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      int temp = n;
      int d = 0;
      
      while(temp != 0){
          temp = temp / 10;
          d = d + 1;
      }
      
      int p = (int)Math.pow(10, d - 1);
      while(p != 0){
          int z = n / p;
          System.out.println(z);
          n = n % p;
          p = p / 10;
      }
    }
    }