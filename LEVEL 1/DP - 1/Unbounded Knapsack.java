import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        
	        int n = sc.nextInt();
	        
	        int[] vals = new int[n];
	        for(int i = 0; i < vals.length; i++){
	            vals[i] = sc.nextInt();
	        }
	        
	        int[] wts = new int[n];
	        for(int i = 0; i < wts.length; i++){
	            wts[i] = sc.nextInt();
	        }
	        
	        int cap = sc.nextInt();
	        
	        int[] dp = new int[cap + 1];
	        dp[0] = 0;
	        
	        for(int bagc = 1; bagc <= cap; bagc++){
	            int max = 0;
	            
	            for(int i = 0; i < n; i++){
	                if(wts[i] <= bagc){
	                    int rbagc = bagc - wts[i];
	                    int rbagv = dp[rbagc];
	                    int tbagv = rbagv + vals[i];
	                    
	                    if(tbagv > max){
	                        max = tbagv;
	                    }
	                }
	            }
	            
	            dp[bagc] = max;
	        }
	        
	        System.out.println(dp[cap]);
	        
	        

	    }
	}