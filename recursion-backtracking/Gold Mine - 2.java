import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	public static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited,ArrayList<Integer> bag){
	    if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true){
	        return;
	    }
	visited[i][j] = true;
	bag.add(arr[i][j]);
	travelAndCollectGold(arr, i - 1, j, visited, bag);
	travelAndCollectGold(arr, i, j + 1, visited, bag);
	travelAndCollectGold(arr, i, j - 1, visited, bag);
	travelAndCollectGold(arr, i + 1, j, visited, bag);
	
		
	}
	
	public static void 	getMaxGold(int[][] arr){
	    boolean[][] visited = new boolean[arr.length][arr[0].length];
	    
	    for(int i = 0; i < arr.length; i++){
	        for(int j = 0; j < arr[i].length; j++){
	            if(arr[i][j] != 0 && visited[i][j] == false){
	                ArrayList<Integer> bag = new ArrayList<>();
	                travelAndCollectGold(arr, i, j, visited, bag);
	                
	                int sum = 0;
	                for(int val: bag){
	                    sum += val;
	                }
	                if(sum > max){
	                    max = sum;
	                }
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}


