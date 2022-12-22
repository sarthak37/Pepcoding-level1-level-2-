import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //write your code here
    
    int om = 0x55555555;
    int em = 0xAAAAAAAA;
    
    int odds = (n & om);
    int evens = (n & em);
    
    odds <<= 1;
    evens >>= 1;
    
    n = odds | evens;
    System.out.println(n);
  }

}