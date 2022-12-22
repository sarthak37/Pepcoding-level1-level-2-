import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
    // write your code here
    int csum = arr[0];
    int osum = arr[0];
    
    for(int i = 1; i < arr.length; i++){
        if(csum >= 0){
            csum += arr[i];
        } else {
            csum = arr[i];
        }
        
        if(csum > osum){
            osum = csum;
        }
    }

    return osum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}