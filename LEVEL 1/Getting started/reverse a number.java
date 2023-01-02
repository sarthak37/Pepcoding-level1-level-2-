import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     
    while(n != 0){
        int p = n % 10;
        System.out.println(p);
        n = n / 10;
    }
   }
   }