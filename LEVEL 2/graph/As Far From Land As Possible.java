import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }
  
  public static class Pair{
      int row;
      int col;
      
      Pair(int row, int col){
          this.row = row;
          this.col = col;
      }
  }

  public static int shortestBridge(int[][] A) {
      LinkedList<Pair>queue = new LinkedList<>();
      boolean[][]vis = new boolean[A.length][A[0].length];
      boolean flag = false;
      
      for(int i = 0; i < A.length && !flag;i++){
          for(int j = 0; j < A[0].length && !flag;j++){
              if(A[i][j] == 1){
                  dfs(i,j,A,queue,vis);
                  flag = true;
              }
          }
      }
      
      int level = 0;
      while(queue.size() > 0){
          int size = queue.size();
          while(size-->0){
              Pair rem = queue.removeFirst();
              
              for(int i = 0; i <  4; i++){
                  int rowdash = rem.row + dirs[i][0];
                  int coldash = rem.col + dirs[i][1];
                  if(rowdash < 0 || coldash < 0 || rowdash >= A.length || coldash >= A[0].length || vis[rowdash][coldash] == true){
                      continue;
                  }
                  
                  if(A[rowdash][coldash] == 1){
                      return level;
                  }
                  
                  queue.addLast(new Pair(rowdash,coldash));
                  vis[rowdash][coldash] = true;
                  
              }
              
          }
              
              level++;
          }
          
          return -1;
      }
      
      static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
      public static void dfs(int i, int j, int[][] A, LinkedList<Pair>queue,boolean[][]vis){
          vis[i][j] = true;
          queue.addLast(new Pair(i,j));
          for(int k = 0; k < 4; k++){
              int rowdash = i + dirs[k][0];
              int coldash = j + dirs[k][1];
              
              if(rowdash < 0 || coldash < 0 || rowdash >= A.length || coldash >= A[0].length || vis[rowdash][coldash] == true || vis[rowdash][coldash] == true || A[rowdash][coldash] == 0){
                  continue;
              }
              
              dfs(rowdash,coldash,A,queue,vis);
          }
      }
  }