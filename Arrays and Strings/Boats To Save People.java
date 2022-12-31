import java.util.*;

public class Main {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static int numRescueBoats(int[] people, int limit) {
    // write your code here
    int c = 0;
    
    Arrays.sort(people);
    
    int l = 0;
    int r = people.length - 1;
    while(l <= r){
        int sum = people[l] + people[r];
        if(sum <= limit){
            c++;
            l++;
            r--;
        } else {
            c++;
            r--;
        }
    }
    
    return c;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] people = new int[n];

    for (int i = 0; i < n; i++)
      people[i] = scn.nextInt();

    int limit = scn.nextInt();
    int boats = numRescueBoats(people, limit);
    System.out.println(boats);
  }
}