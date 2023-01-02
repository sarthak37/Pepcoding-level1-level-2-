import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for(int i = 0; i < arr.length; i++){
        arr[i] = sc.nextInt();
    }
    
    int d = sc.nextInt();
    
    int idx = -1;
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == d){
            idx = i;
        }
    }
    
    System.out.println(idx);
 }

}