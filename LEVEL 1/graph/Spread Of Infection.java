import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      int[] vv = new int[vtces];
      int c = 0;
      
      while(q.size() > 0){
          Pair rem = q.removeFirst();
          
          if(vv[rem.v] > 0){
              continue;
          }
          vv[rem.v] = rem.time;
          if(rem.time > t){
              break;
          }
          c++;
          
          for(Edge e : graph[rem.v]){
              if(vv[e.nbr] == 0){
                  q.add(new Pair(e.nbr, rem.time + 1));
              }
          }
      }
      
      System.out.println(c);
   }
   
   public static class Pair {
       int v;
       int time;
       
       Pair(int v, int time){
           this.v = v;
           this.time = time;
       }
   }

}