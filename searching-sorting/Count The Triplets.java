import java.util.*;
import java.io.*;

public class Main {

  public static int countTriplets(int[]arr) {
    //write your code here
    Arrays.sort(arr);
    int c = 0;
    
    for(int i = arr.length - 1; i >= 2 ; i--){
        int l = 0;
        int r = i - 1;
        
        while(l < r){
            if(arr[l] + arr[r] == arr[i]){
                c++;
                l++;
                r--;
            } else if(arr[l] + arr[r] < arr[i]){
                l++;
            } else {
                r--;
            }
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

    System.out.println(countTriplets(arr));
  }
}