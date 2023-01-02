import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main{
    public static boolean meetingRooms(int arr[][]){
        // write code here
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        
        if(arr.length <= 1){
            return true;
        }
        int ep = arr[0][1];
        
        for(int j = 1; j <= arr.length - 1; j++){
            if(arr[j][0] < ep){
                return false;
            } else {
                ep = arr[j][1];
            }
        }
        
        return true;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}