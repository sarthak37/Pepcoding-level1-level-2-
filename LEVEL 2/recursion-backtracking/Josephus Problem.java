import java.io.*;
import java.util.*;

public class Main {

  public static int s(int n, int k){
    //write your code here
    if(n == 1){
        return 0;
    }
    
    int x = s(n - 1, k);
    int y = (x + k) % n;
    return y;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(s(n,k));
  }
  

}