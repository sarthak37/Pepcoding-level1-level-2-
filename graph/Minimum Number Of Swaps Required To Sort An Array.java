import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] st = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(minSwaps(arr));
  }

  public static int minSwaps(int[] arr1) {
      int n = arr1.length;
      Pair[]arr = new Pair[n];
      
      for(int i = 0; i < n; i++){
          arr[i] = new Pair(arr1[i],i);
      }
      
      Arrays.sort(arr);
      int ans = 0;
      
      boolean[] vis = new boolean[n];
      
      for(int i = 0; i < n; i++){
          if(vis[i] == true || arr[i].idx == i){
              continue;
          }
          
          int clen = 0;
          int j = i;
          while(vis[j] == false){
              vis[j] = true;
              clen++;
              j = arr[j].idx;
          }
          
          ans += (clen - 1);
      }
      
      return ans;
  }

  private static class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair o) {
      return this.val - o.val;
    }
  }
}