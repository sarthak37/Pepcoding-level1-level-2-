import java.util.*;

public class Main {

    public static int findRotationCount(int[]arr) {
        //write your code here
        int lo = 0;
        int hi = arr.length - 1;
        
        if(arr[lo] <= arr[hi]){
            return 0;
        }
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] > arr[mid + 1]){
                return mid + 1;
            } else if(arr[mid] < arr[mid - 1]){
                return mid;
            }
            else if(arr[lo] <= arr[mid]){
                lo = mid + 1;
            } else if(arr[mid] <= arr[hi]){
                hi = mid - 1;
            }
        } 
        
        return 0;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findRotationCount(arr);
        System.out.println(ans);
    }
}