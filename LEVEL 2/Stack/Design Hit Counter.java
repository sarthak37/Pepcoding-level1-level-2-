import java.util.*;
import java.io.*;

public class Main {

  static class HitCounter {
     ArrayDeque<Integer> q;

    /** Initialize your data structure here. */
    public HitCounter() {
         q = new ArrayDeque<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
        int start = timestamp - 300 + 1;
        while(q.peek() < start){
             q.remove();
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      int start = timestamp - 300 + 1;
      while(q.peek() < start){
           q.remove();
      }
      
      return q.size();
    }
  }
  public static void main(String[] args) throws java.lang.Exception {

    Scanner scn = new Scanner(System.in);

    HitCounter obj = new HitCounter();
    while (true) {
      String in = scn.next();

      if (in.equals("hit")) {
        obj.hit(scn.nextInt());
      } else if (in.equals("getHits")) {
        System.out.println(obj.getHits(scn.nextInt()));
      } else {
        break;
      }
    }
  }
}