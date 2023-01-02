import java.util.*;
import java.io.*;

class Main {
    static int[]parent;
    static  int[]disc;
    static int[]low;
    static int time;
    static boolean[]vis;
    static boolean[]ap;
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int v = sc.nextInt();
      int e = sc.nextInt();
      
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < v; i++){
          graph.add(new ArrayList<>());
      }
      
      for(int i = 0; i < e; i++){
          int u = sc.nextInt() - 1;
          int v1 = sc.nextInt() - 1;
          
          graph.get(u).add(v1);
          graph.get(v1).add(u);
      }
      
       parent = new int[v];
      disc = new int[v];
      low = new int[v];
      time = 0;
      vis = new boolean[v];
      ap = new boolean[v];
      parent[0] = -1;
      dfs(0,graph);
      
      int ans = 0;
      for(int i = 0; i < v; i++){
          if(ap[i] == true){
              ans++;
          }
      }
      
      System.out.println(ans);
  }
  
  public static void dfs(int u,ArrayList<ArrayList<Integer>>graph){
      disc[u] = low[u] = time;
      time++;
      int count = 0;
      
      vis[u] = true;
      
      ArrayList<Integer> nbrs = graph.get(u);
      
      for(int i = 0; i < nbrs.size(); i++){
          int v = nbrs.get(i);
          
          if(parent[u] == v){
              continue;
          } else if(vis[v] == true){
              low[u] = Math.min(low[u],disc[v]);
          } else {
              parent[v] = u;
              count++;
              dfs(v, graph);
              
              low[u] = Math.min(low[u],low[v]);
              if(parent[u] == -1){
                  if(count >= 2){
                      ap[u] = true;
                  }
              } else {
                  if(low[v] >= disc[u]){
                      ap[u] = true;
                  }
              }
          }
      }
  }

}