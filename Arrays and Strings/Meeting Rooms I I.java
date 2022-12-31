import java.util.*;


public class Main {
  public static int meetingRooms(int intervals[][]) {
    // write your code here
    int st[] = new int[intervals.length],  et[] = new int[intervals.length];
    
    for(int i = 0; i < intervals.length; i++){
        st[i] = intervals[i][0];
        et[i] = intervals[i][1];
    }
    
    Arrays.sort(st);
    Arrays.sort(et);
    
    int c = 0, i = 0, j = 0;
    
    while(i < st.length){
        if(st[i] < et[j]){
            c++;
            i++;
        } else {
            i++;
            j++;
        }
    }
    
    return c;
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);

    // Input Format
    int n = scn.nextInt();
    int input[][] = new int[n][2];

    for (int i = 0 ; i <  n ; i++) {
      int sp = scn.nextInt();
      int ep = scn.nextInt();

      input[i][0] = sp;
      input[i][1] = ep;
    }

    // Output Format
    System.out.println(meetingRooms(input));
  }
}