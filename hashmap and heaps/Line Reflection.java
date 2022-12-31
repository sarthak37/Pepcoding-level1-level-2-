import java.io.*;
import java.util.*;

public class Main {

  public static boolean isReflected(int[][] points) {
    //Code Here
    HashMap<Long, Long> map = new HashMap<>();
    long xmin = Integer.MAX_VALUE;
    long xmax = Integer.MIN_VALUE;
    
    for(int[] point : points){
        long x = point[0];
        long y = point[1];
        
        xmin = Math.min(xmin, x);
        xmax = Math.max(xmax, x);
        
        long hash = x * 100000000 + y;
        map.put(hash, 1L);
    }
    
    long mirr = xmin + xmax;
    
    for(int[] point : points){
        int x = point[0];
        int y = point[1];
        
        long ximg = mirr - x;
        long yimg = y;
        
        long imghash = ximg * 100000000 + y;
        
        if(map.containsKey(imghash) == false){
            return false;
        }
    }
    
    return true;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[][] points = new int[n][2];
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[0].length; j++) {
        points[i][j] = scn.nextInt();
      }
    }

    System.out.println(isReflected(points));
  }

}