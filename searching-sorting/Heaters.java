import java.util.*;
import java.io.*;

public class Main {
  public static int findRadius(int[]houses, int[]heaters) {
    //write your code here
    if(houses == null || houses.length == 0)
    return 0;
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int a = 0;
    int i = 0;
    int j = 0;
    
    while(i < houses.length){
        if(houses[i] <= heaters[j]){
            if(j == 0){
                a = Math.max(a,heaters[j] - houses[i]);
                i++;
                continue;
            }
        } else {
            while(j!= heaters.length - 1 && heaters[j] <houses[i]){
                j++;
            }
            if(j == 0 || heaters[j] < houses[i]){
                a = Math.max(a,houses[i] - heaters[j]);
                i++;
                continue;
            }
        }
        
        int d = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]);
        a = Math.max(a, d);
        i++;
    }
    
    return a;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]houses = new int[n];

    for (int i = 0; i < n; i++) {
      houses[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[]heaters = new int[m];

    for (int i = 0; i < m; i++) {
      heaters[i] = scn.nextInt();
    }

    System.out.println(findRadius(houses, heaters));
  }
}