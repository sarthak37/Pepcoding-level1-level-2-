import java.util.*;
import java.io.*;

public class Main {

    public static int find(int[]arr,int target) {
        //write your code here
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[lo] <= arr[mid]){
                if(target >= arr[lo] && arr[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            
            else if(arr[mid] <= arr[hi]) {
                if(target > arr[mid] && arr[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}