import java.io.*;
import java.util.*;

public class Main {

  public static int connectSticks(int[] sticks) {

    //Code Here
    PriorityQueue<Integer> q = new PriorityQueue<>();
    
    for(int stick : sticks){
        q.add(stick);
    }
    
    int cost = 0;
    while(q.size() > 1){
        int s1 = q.remove();
        int s2 = q.remove();
        
        int c = s1 + s2;
        
        cost += c;
        q.add(c);
    }
    
    return cost;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] sticks = new int[n];
    for (int i = 0; i < sticks.length; i++) {
      sticks[i] = scn.nextInt();
    }

    System.out.println(connectSticks(sticks));
  }

}