import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int i = 1;
    while(i * i <= n){
        System.out.println(i * i);
        i++;
    }
   }
  }