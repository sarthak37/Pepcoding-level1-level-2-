import java.util.*;
import java.io.*;

public class Main {

  public static int firstBadVersion(int n) {
    //write your code here
    int lo = 1;
    int hi = n;
    int fbv = -1;
    
    while(lo <= hi){
        int mid = (lo + hi) / 2;
        
        if(isBadVersion(mid) == true){
            fbv = mid;
            hi = mid - 1;
        }
        else {
            lo = mid + 1;
        }
    }
    
    return fbv;
  }

  static int bad = 0;
  public static boolean isBadVersion(int val) {
    if (val >= bad) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void solve(int n, int fbv) {
    bad = fbv;
    System.out.println(firstBadVersion(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fbv = scn.nextInt();

    solve(n, fbv);
  }
}