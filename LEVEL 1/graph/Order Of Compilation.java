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
      }

      // write your code here
      boolean[] visited = new boolean[vtces];
      Stack<Integer> st = new Stack<>();
      for(int v = 0; v < vtces; v++){
          if(visited[v] == false){
              topologicalSort(graph, v, visited, st);
          }
      }
      
      while(st.size() > 0){
          System.out.println(st.pop());
      }
   }
   
   public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
       visited[src] = true;
       for(Edge e: graph[src]){
           if(visited[e.nbr] == false){
               topologicalSort(graph, e.nbr, visited, st);
           }
       }
       
       st.push(src);
   }

}