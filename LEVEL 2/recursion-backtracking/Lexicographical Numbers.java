import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		for(int i = 1; i <= 9; i++){
		    dfs(i,n);
		}
	}
	
	public static void dfs(int i, int n){
	    if(i > n){
	        return;
	    }
	    
	    System.out.println(i);
	    for(int j = 0; j < 10; j++){
	        dfs(10 * i + j, n);
	    }
	}
}