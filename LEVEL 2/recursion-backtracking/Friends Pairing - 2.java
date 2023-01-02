import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void s(int i, int n, boolean[] used, String asf) {
    // write your code here
    if(i > n){
        System.out.println(counter + "." + asf);
        counter++;
        return;
    }
    
    if(used[i] == true){
        s(i + 1, n, used, asf);
    } else {
        used[i] = true;
        s(i + 1, n, used, asf + "(" + i + ") ");
        for(int j = i + 1; j <= n; j++){
            if(used[j] == false){
                used[j] = true;
                s(i + 1, n , used, asf + "(" + i + "," + j + ") ");
                used[j] = false;
            }
        }
        
        used[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    s(1, n, used, "");
  }
}