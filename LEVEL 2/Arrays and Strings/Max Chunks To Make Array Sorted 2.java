import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int[] rmin = new int[arr.length + 1];
        
        rmin[arr.length] = Integer.MAX_VALUE;
        for(int i = arr.length - 1; i >= 0; i--){
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }
        
        int lmax = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            lmax = Math.max(lmax, arr[i]);
            if(lmax <= rmin[i + 1]){
                count++;
            }
        }
        
        return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}