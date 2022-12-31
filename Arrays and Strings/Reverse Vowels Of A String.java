import java.util.*;

public class Main {
    public static boolean i(char[] arr, int idx){
        char ch = arr[idx];
        
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        
        return false;
    }
  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  
  public static void swap(char[] arr, int left, int right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
  }
  public static String reverseVowels(String s) {
    // write your code here
    char[] arr = s.toCharArray();
    
    int left = 0;
    int right = arr.length - 1;
    while(left < right){
        while(left <  right && i(arr, left) == false){
            left++;
        }
        
        while(left < right && i(arr, right) == false){
            right--;
        }
        
        swap(arr, left, right);
        left++;
        right--;
    }
    
    String str = "";
    for(char ch : arr){
        str += ch;
    }
    
    return str;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}