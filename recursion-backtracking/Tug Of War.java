import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		s(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}

	static int mf = Integer.MAX_VALUE;
	static String ans = "";

	public static void s(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		//write your code here
		if(vidx == arr.length){
		    int de = Math.abs(soset1 - soset2);
		    if(de < mf){
		        mf = de;
		        ans = set1 + " " + set2;
		    }
		    return;
		}
		
		if(set1.size() < (arr.length + 1) / 2){
		    set1.add(arr[vidx]);
		    s(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
		    set1.remove(set1.size() - 1);
		}
		
		if(set2.size() < (arr.length + 1) / 2){
		    set2.add(arr[vidx]);
		    s(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
		    set2.remove(set2.size() - 1);
		}

	}

}