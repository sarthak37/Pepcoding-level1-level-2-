import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		solution(arr);
	}

	public static void solution(int[] arr) {
		HashMap<Integer,Integer> left = new HashMap<>();
		HashMap<Integer,Integer> fmap = new HashMap<>();
		int max = 0;
		int minLength = Integer.MAX_VALUE;
		int stidx = -1;

		for(int i = 0 ; i < arr.length; i++){
			//if element is coming for the first time
			if(!fmap.containsKey(arr[i])){
				left.put(arr[i], i);
				fmap.put(arr[i], 1);
			}else{
				fmap.put(arr[i], fmap.get(arr[i]) + 1);
			}

			//if frequency of current element is greater than max till now, update max and minLength
			if(fmap.get(arr[i]) > max){
				max = fmap.get(arr[i]);
				minLength = i - left.get(arr[i]) + 1;
				stidx = left.get(arr[i]);
			}else if((fmap.get(arr[i]) == max) && (minLength > i - left.get(arr[i]) + 1)){
				minLength = i - left.get(arr[i]) + 1;
				stidx = left.get(arr[i]);
			}
		}

		System.out.println(arr[stidx]);
		System.out.println(stidx);
		System.out.println(stidx + minLength - 1);
	}

}