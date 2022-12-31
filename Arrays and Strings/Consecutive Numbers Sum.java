import java.util.*;

public class Main {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
  public static int consecutiveNumbersSum(int n) {
    // write your code here
    int c = 0;
    for(int k = 1; n > (k * (k - 1) / 2); k++) {
        int n1 = n - (k*(k - 1) / 2);
        
        if(n1 % k == 0){
            c++;
        }
    }
    
    return c;
  }

  // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int num = scn.nextInt();
    int res = consecutiveNumbersSum(num);
    System.out.println(res);
  }
}