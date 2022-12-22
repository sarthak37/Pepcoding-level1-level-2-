import java.io.*;
import java.util.*;

public class Main {
    static int c = 0;

	public static void s(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(i > n){
		    if(nos == k){
		        c++;
		        System.out.print(c + ". ");
		        for(ArrayList<Integer> set : ans){
		            System.out.print(set + " ");
		        }
		        
		        System.out.println();
		    }
		    
		    return;
		}
		
		for(int j = 0; j < ans.size(); j++){
		    if(ans.get(j).size() > 0){
		        ans.get(j).add(i);
		        s(i + 1,n, k, nos, ans);
		        ans.get(j).remove(ans.get(j).size() - 1);
		    } else {
		        ans.get(j).add(i);
		        s(i + 1, n , k, nos + 1, ans);
		        ans.get(j).remove(ans.get(j).size() - 1);
		        break;
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		s(1, n, k, 0, ans);

	}

}