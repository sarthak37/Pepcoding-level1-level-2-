import java.util.*;

public class Main {

	public static int solution(int[] arr, int target){
		int ans = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++){
		    sum += arr[i];
		    if(map.containsKey(sum - target)){
		        ans = ans + map.get(sum - target);
		    }
		    
		    map.put(sum, map.getOrDefault(sum,0) + 1);
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
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}