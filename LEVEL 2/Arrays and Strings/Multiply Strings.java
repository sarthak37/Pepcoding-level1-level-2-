import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static String multiplication(String num1, String num2) {
    // write your code here
    if(num1.equals("0") || num2.equals("0")) return "0";
    
    int l1 = num1.length();
    int l2 = num2.length();
    int[] res = new int[l1 + l2];
    
    int i = l2 - 1;
    int pf = 0;
    while(i >= 0){
        int ival = num2.charAt(i) - '0';
        i--;
        
        int j = l1 - 1;
        int k = res.length - 1 - pf;
        int carry = 0;
        
        while(j >= 0 || carry != 0) {
            int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
            j--;
            
            int prod = ival * jval + carry + res[k];
            
            res[k] = prod % 10;
            carry = prod / 10;
            k--;
    }
    pf++;
  }
  
  String str = "";
  boolean flag = false;
  for(int val : res){
      if(val == 0 && flag == false){
          continue;
      } else {
          flag = true;
          str += val;
      }
  }
  return str;
  }

  //~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String str1 = scn.nextLine();
    String str2 = scn.nextLine();

    String res = multiplication(str1, str2);
    System.out.println(res);
  }
}