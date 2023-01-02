import java.util.*;

public class Main {

  // ~~~~~~~~~~User Section~~~~~~~~~~~
    // write your code here
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static String maximumSwap(String num) {
        char[] arr = num.toCharArray();
        
        int[] li = new int[10];
        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            li[digit] = i;
        }
        
        boolean flag = false;
        for(int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            for(int j = 9; j > digit; j--) {
                if(i < li[j]) {
                    swap(arr, i, li[j]);
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                break;
            }
        }
        
        String res = "";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }
  

  // ~~~~~~~~Input Management~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String ans = maximumSwap(str);
    System.out.println(ans);
  }
}