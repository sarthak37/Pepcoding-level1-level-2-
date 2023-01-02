import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
      List<Integer> ans = new ArrayList<>();
      int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}};
      
      int[]par = new int[m*n];
      int[]rank = new int[m*n];
      Arrays.fill(par,-1);
      int count = 0;
      
      for(int i = 0; i < positions.length; i++){
          int row = positions[i][0];
          int col = positions[i][1];
          
          int cellno = row*n+col;
          if(par[cellno]!=-1){
              ans.add(count);
              continue;
          }
          par[cellno] = cellno;
          rank[cellno] = 1;
          count++;
          
          for(int[]dir: dirs){
              int rowdash = row + dir[0];
              int coldash = col + dir[1];
              int celldash = rowdash * n + coldash;
              
              if(rowdash < 0 || coldash < 0 || rowdash>=m || coldash >=n || par[celldash] == -1){
                  continue;
              }
              
              int lx = find(cellno,par);
              int ly = find(celldash,par);
              
              if(lx != ly){
                  if(rank[lx] > rank[ly]){
                      par[ly] = lx;
                  } else if(rank[lx] < rank[ly]){
                      par[lx] = ly;
                  } else {
                      par[ly] = lx;
                      rank[lx]++;
                  }
                  count--;
              }
          }
          ans.add(count);
      }
      return ans;
  }
  public static int find(int x, int[]par){
      if(par[x] == x){
          return x;
      }
      
      int temp = find(par[x],par);
      par[x] = temp;
      return temp;
  }
}