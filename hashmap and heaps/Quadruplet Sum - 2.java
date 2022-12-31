import java.util.*;

public class Main {
	
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int c = 0;
		
		for(int e1 : A){
		    for(int e2 : B){
		        map.put(e1 + e2, map.getOrDefault(e1 + e2, 0) + 1);
		    }
		}
		
		int t = 0;
		
		for(int e3 : C){
		    for(int e4 : D){
		        c = c + map.getOrDefault(t - (e3 + e4), 0);
		    }
		}

		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}
		System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
	}

}