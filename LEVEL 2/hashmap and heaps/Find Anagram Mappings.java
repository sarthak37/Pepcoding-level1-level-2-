import java.util.*;

public class Main {
    public static class Pair {
		// write your code here
		int idx = 0;
		ArrayList<Integer> list = new ArrayList<>();
	}
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here
		HashMap<Integer, Pair> map = new HashMap<>();
		for(int i = 0; i < arr2.length; i++){
		    if(map.containsKey(arr2[i])){
		        Pair p = map.get(arr2[i]);
		        p.list.add(i);
		    } else {
		        Pair p = new Pair();
		        p.list.add(i);
		        map.put(arr2[i], p);
		    }
		}
		
		int[] ans = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++){
		    Pair p = map.get(arr1[i]);
		    ans[i] = p.list.get(p.idx);
		    p.idx++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}