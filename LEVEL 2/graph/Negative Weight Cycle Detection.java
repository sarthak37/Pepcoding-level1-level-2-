import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] st = br.readLine().split(" ");
	    int n = Integer.parseInt(st[0]);
	    int m = Integer.parseInt(st[1]);
	    
	    int[][] edges = new int[m][3];
	    for(int i = 0; i < m; i++){
	        st = br.readLine().split(" ");
	        edges[i][0] = Integer.parseInt(st[0]);
	        edges[i][1] = Integer.parseInt(st[1]);
	        edges[i][2] = Integer.parseInt(st[2]);
	    }
	    System.out.println(i(n, edges));
	}
	
	public static int i(int n, int[][] edges) {
	    int[] path = new int[n];
	    Arrays.fill(path, Integer.MAX_VALUE);
	    path[0] =  0;
	    
	    for(int i = 0; i < n - 1; i++){
	        for(int j = 0; j < edges.length; j++){
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int wt = edges[j][2];
	            
	            if(path[u] == Integer.MAX_VALUE){
	                continue;
	            }
	            if(path[u] + wt < path[v]){
	                path[v] = path[u] + wt;
	            }
	        }
	    }
	    
	    for(int j = 0; j < edges.length; j++){
	        int u = edges[j][0];
	        int v = edges[j][1];
	        int wt = edges[j][2];
	        
	        if(path[u] == Integer.MAX_VALUE){
	            continue;
	        }
	        if(path[u] + wt < path[v]){
	            return 1;
	        }
	    }
	    
	    return 0;
	}
}