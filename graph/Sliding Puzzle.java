import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[2][3];

    for (int i = 0; i < 2; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(slidingPuzzle(arr));
  }

  public static int slidingPuzzle(int[][] board) {
      LinkedList<String> queue = new LinkedList<>();
      String tar = "123450";
      
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < board.length;i++){
          for(int j  = 0; j < board[0].length;j++){
              sb.append(board[i][j]);
          }
      }
      String initial = sb.toString();
      
      int[][] swapidx = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{4,2}};
      
      queue.addLast(initial);
      int level = 0;
      HashSet<String> vis = new HashSet<>();
      while(queue.size() > 0){
          int size = queue.size();
          while(size-->0){
              String rem = queue.removeFirst();
              if(rem.equals(tar)){
                  return level;
              }
              
              int idx = -1;
              for(int i = 0; i < rem.length();i++){
                  if(rem.charAt(i) == '0'){
                      idx = i;
                      break;
                  }
              }
              int[]swap = swapidx[idx];
              for(int i = 0; i < swap.length;i++){
                  String tobeadded = swapchar(rem,idx,swap[i]);
                  if(vis.contains(tobeadded)){
                      continue;
                  }
                  queue.addLast(tobeadded);
                  vis.add(tobeadded);
              }
          }
          level++;
      }
      return -1;
  }
  
  public static String swapchar(String st, int i, int j){
      StringBuilder sb = new StringBuilder(st);
      sb.setCharAt(i,st.charAt(j));
      sb.setCharAt(j,st.charAt(i));
      
      return sb.toString();
  }
}