import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    
    int odd = 0;
    int even = 0;
    
    for(int i = 0; i < str.length(); i++){
        int bit = str.charAt(i) - '0';
        
        if(i % 2 == 0){
            even = even + bit;
        } else {
            odd = odd + bit;
        }
    }
    
    int d = even - odd;
    
    if(d % 11 == 0){
        System.out.println(true);
    } else {
        System.out.println(false);
    }

    //write your code here
  }

}