import java.io.*;
import java.util.*;

public class Main {
    public static int trap(int[] h) {
        int l = 0;
        int r = h.length - 1;
        
        int lmax = 0, rmax = 0;
        
        int ans = 0;
        
        while(l < r){
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            
            if(lmax < rmax){
                ans = ans + lmax - h[l];
                l++;
            } else {
                ans = ans + rmax - h[r];
                r--;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = Integer.parseInt(read.readLine());
        int result = trap(arr);
        System.out.println(result);
        
    }
}