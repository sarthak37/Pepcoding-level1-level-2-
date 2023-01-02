import java.util.*;
import java.io.*;

public class Main {

  public static int count(int[]arr) {
    //write your code here
    int c = arr.length;
    int i = 0;
    int j = arr.length - 1;
    int s = 0;
    
    while(i < j){
        while(i != j && arr[i] == arr[i + 1]){
            c--;
            i++;
        }
        
         while(i != j && arr[j] == arr[j -  1]){
            c--;
            j--;
        }
        
        if(i == j){
            break;
        }
        
        s = arr[i] + arr[j];
        
        if(s == 0){
            c--;
            i++;
            j--;
        } else if(s < 0){
            i++;
        } else {
            j--;
        }
    }
    
     return c;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(count(arr));
  }
}