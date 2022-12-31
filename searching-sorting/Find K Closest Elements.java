import java.util.*;
import java.io.*;

public class Main {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static List<Integer> findClosest(int[]arr,int k,int x) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while(hi - lo >= k){
            if(Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)){
                lo++;
            } else {
                hi--;
            }
        }
        
        List<Integer> r = new ArrayList<>(k);
        for(int i = lo; i <= hi; i++){
            r.add(arr[i]);
        }
        
        return r;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        List<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}