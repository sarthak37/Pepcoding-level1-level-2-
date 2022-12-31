import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        // write your code here
        if(arr.length == 0) return true;
        
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int ele : arr) freqMap.put(ele,freqMap.getOrDefault(ele, 0) + 1);
        
        Integer[] ar = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) ar[i] = arr[i];
        
        Arrays.sort(ar,(a,b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        
        for(Integer ele : ar){
            if(freqMap.get(ele) == 0) continue;
            
            if(freqMap.getOrDefault(2 * ele, 0) == 0) return false;
            
            freqMap.put(ele, freqMap.get(ele) - 1);
            freqMap.put(2 * ele,freqMap.get(2 * ele) - 1);
        }
        
        return true;
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