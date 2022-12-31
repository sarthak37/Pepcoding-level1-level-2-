import java.util.*;

public class Main {

  // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
  public static ArrayList<Integer> pascalRow(int i) {
    // write your code here
    ArrayList<Integer> res = new ArrayList<>();
    
    int val = 1;
    for(int j = 0; j <= i; j++){
        res.add(val);
        val = val * (i - j) / (j + 1);
    }
    
    return res;
  }

  // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    for (int val : res) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}