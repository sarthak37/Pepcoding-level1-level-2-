import java.io.*;
import java.util.*;

public class Main {
  public static class MovingAverage {
      
      private Queue<Integer> q;
      private final int size;
      private  int sum;
      
      
    public MovingAverage(int size) {
        this.size = size;
        q = new ArrayDeque<>();
    }

    public double next(int val) {
        sum += val;
        q.add(val);
        
        if(q.size() > size){
            sum -= q.remove();
        }
        double avg = ((double)sum)/q.size();
        return avg;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(read.readLine());
    MovingAverage obj = new MovingAverage(size);
    PrintWriter out = new PrintWriter(System.out);
    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      double avg = obj.next(val);

      StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
      while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }
      out.println(ans);
    }
    out.close();
  }
}