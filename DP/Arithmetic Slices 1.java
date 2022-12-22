import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int[] dp = new int[arr.length];
		int ans = 0;
		
		for(int i = 2; i < arr.length; i++){
		    if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]){
		        dp[i] = dp[i - 1] + 1;
		        ans += dp[i];
		    }
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}