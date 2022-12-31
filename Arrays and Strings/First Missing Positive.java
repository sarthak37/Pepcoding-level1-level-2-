import java.util.*;

public class Main {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] arr) {
    // write your code here
    boolean one = false;
    int n = arr.length;
    for(int i = 0; i < n; i++) {
        if(arr[i] == 1)
            one = true;
        if(arr[i] < 1 || n < arr[i]) {
            arr[i] = 1;
        }    
    }
    
    for(int i = 0; i < n; i++) {
        int indx = Math.abs(arr[i]);
        arr[indx - 1] = -Math.abs(arr[indx - 1]);
    }
    
    for(int i = 0; i < n; i++){
        if(arr[i] > 0) return i + 1;
    }
    return n + 1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}