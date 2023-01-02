import java.util.*;
import java.io.*;

public class Main {
  public static int countPairs(int[]arr) {
 HashMap<Integer,Integer> fmap = new HashMap<>();
    
    for(int i = 0; i < arr.length; i++){
        if(fmap.containsKey(arr[i]) == true) {
            fmap.put(arr[i],fmap.get(arr[i]) + 1);
        }
        else {
            fmap.put(arr[i],1);
        }
    }
    
    int count = 0;
    for(int key : fmap.keySet()) {
        int val = fmap.get(key);
        count += ((val - 1) * val)/2;
    }
    
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}