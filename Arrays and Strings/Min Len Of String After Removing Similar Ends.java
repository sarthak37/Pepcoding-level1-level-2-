import java.util.Scanner;
public class Main {
  public static int minLen(String s) {
    // write your code here
    
    int left = 0 , right = s.length() - 1;
    
    while(left < right && s.charAt(left) == s.charAt(right)){
        char ch = s.charAt(left);
        
        while(left < right && ch == s.charAt(left)){
            left++;
        }
        
        while(left <= right && ch == s.charAt(right)){
            right--;
        }
    }
    
    return right-left+1;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String inp = scn.nextLine();
    int len = minLen(inp);

    System.out.println(len);
  }
}