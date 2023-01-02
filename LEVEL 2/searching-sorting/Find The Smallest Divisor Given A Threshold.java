import java.util.*;
import java.io.*;

public class Main {
    public static int findSmallestDivisor(int[]nums,int th) {
        //write your code here
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        
        if(th == nums.length) {
            return max;
        }
        
        int lo = 1;
        int hi = max;
        int mdiv = Integer.MAX_VALUE;
        
        while(lo <= hi){
            int div = (lo + hi) / 2;
            
            if(I(nums,div,th) == true) {
                mdiv = div;
                hi = div - 1;
            } else {
                lo = div + 1;
            }
        }
        
        return mdiv;
    }
    
    public static boolean I(int[]nums, int div, int th) {
        int res = 0;
        
        for(int i = 0; i < nums.length;i++){
            res = res + (int)Math.ceil(nums[i]*1.0/div);
        }
        
        return res <= th;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}