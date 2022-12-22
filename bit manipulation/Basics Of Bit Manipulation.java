import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    int on = (1 << i);
    int of = ~(1 << j);
    int tm = (1 << k);
    int cm = (1 << m);
    
    System.out.println(n | on);
    System.out.println(n & of);
    System.out.println(n ^ tm);
    System.out.println((n & cm) == 0? false: true);
  }

}