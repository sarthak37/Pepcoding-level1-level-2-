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
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    for(int val : arr){
        map.put(val, true);
    }
    
    for(int val : arr){
        if(map.containsKey(val - 1)){
            map.put(val, false);
        }
    }
    
    int msp = 0;
    int ml = 0;
    for(int val : arr){
        if(map.get(val) == true){
            int tl = 1;
            int tsp = val;
            
            while(map.containsKey(tsp + tl)){
                tl++;
            }
            
            if(tl > ml){
                msp = tsp;
                ml = tl;
            }
        }
    }
    
    for(int i = 0; i < ml; i++){
        System.out.println(msp + i);
    }
 }

}