import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }

  public static int[] findRedundantConnection(int[][] edges) {
      int[]par = new int[edges.length+1];
      int[]rank = new int[edges.length+1];
      for(int i = 1; i < par.length;i++){
          par[i] = i;
          rank[i] = 1;
      }
      
      for(int[]edge: edges){
          int u = edge[0];
          int v = edge[1];
          
          int lu = find(par,u);
          int lv = find(par,v);
          
          if(lu!=lv){
              if(rank[lu] > rank[lv]){
                  par[lv] = lu;
              } else if(rank[lu] < rank[lv]){
                  par[lu] = lv;
                  rank[lv]++;
              }else {
              par[lu] =lv;
              rank[lv]++;
          }
      } else {
          return edge;
      }
          
     }  
      
      return new int[2];
  }

  private static int find(int[] parent, int f) {
      if(parent[f] == f){
          return f;
      }
      
      int temp = find(parent,parent[f]);
      parent[f] = temp;
      return temp;
  }
}