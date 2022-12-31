import java.io.*;
import java.util.*;

public class Main {
  public static class RecentCounter {
      
      private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
      q.add(t);
      int min = t - 3000;
      while(q.peek() < min){
          q.remove();
      }
      
      return q.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    RecentCounter obj = new RecentCounter();

    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      int ans = obj.ping(val);
      System.out.println(ans);
    }

  }
}