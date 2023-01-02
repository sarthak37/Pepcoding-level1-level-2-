import java.util.*;
import java.io.*;

public class Main {

    //return an array of size two, which contains first and last index of target.
    public static int[] find(int[]arr,int target) {
        //write your code here
        int[] ans = {-1, -1};
        
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
           int  mid = (lo + hi) / 2;
            
            if(arr[mid] == target){
                ans[0] = mid;
                hi = mid - 1;
            } else if(arr[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        lo = 0;
        
        hi = arr.length - 1;
        
         while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] == target){
                ans[1] = mid;
                lo = mid + 1;
            } else if(arr[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0;i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[]ans = find(arr,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}