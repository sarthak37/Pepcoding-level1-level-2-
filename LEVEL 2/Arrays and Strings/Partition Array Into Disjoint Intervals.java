import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
  public static int partitionDisjoint(int[] arr) {
    // write your code here
    int l = arr[0];
    int g = arr[0];
    int a = 0;
    
    for(int i = 1; i < arr.length; i++){
        if(arr[i] > g){
            g = arr[i];
        } else if(arr[i] < l) {
            l = g;
            a = i;
        }
    }
    
    return a + 1;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int len = partitionDisjoint(arr);
    System.out.println(len);
  }
}