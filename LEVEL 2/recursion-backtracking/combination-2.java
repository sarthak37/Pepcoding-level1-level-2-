import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(boolean[] boxes, int ci, int ti, int llb){
    // write your code here
   if(ci > ti){
       for(int i = 0; i < boxes.length; i++){
           if(boxes[i]){
               System.out.print("i");
           } else {
               System.out.print("-");
           }
       }
       System.out.println();
       return;
   }
       
    for(int b = llb + 1; b < boxes.length; b++){
        if(boxes[b] == false){
            boxes[b] = true;
            combinations(boxes, ci + 1, ti, b);
            boxes[b] = false;
        }
    }   
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new boolean[nboxes], 1, ritems, -1);
  }

}