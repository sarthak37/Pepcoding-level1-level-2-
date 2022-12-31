import java.util.*;
import java.io.*;

public class Main {

  
      public static class Pair implements Comparable<Pair> {
    //write your code here
    int marks;
    int idx;
    
    Pair(int marks, int idx) {
        this.marks = marks;
        this.idx = idx;
    }
    
    public int compareTo(Pair o){
        if(this.marks != o.marks){
            return this.marks - o.marks;
        } else {
            return o.idx - this.idx;
        }
    }
  }
  
  public static int[] kToppers(int[]marks, int k) {
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int i = 0; i < marks.length; i++){
          if(pq.size() < k){
              pq.add(new Pair(marks[i], i));
          }
          else if(pq.peek().marks < marks[i]){
              pq.remove();
              pq.add(new Pair(marks[i], i));
          }
      }
      
      int[] ans = new int[k];
      int idx = k - 1;
      
      while(idx >= 0){
          ans[idx] = pq.remove().idx;
          idx--;
      }
      
      return ans;
  }

  public static void main(String[]args) {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]marks = new int[n];

    for (int i = 0; i < n; i++) {
      marks[i] = scn.nextInt();
    }

    int k = scn.nextInt();

    int[]ans = kToppers(marks, k);

    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }

  }
}