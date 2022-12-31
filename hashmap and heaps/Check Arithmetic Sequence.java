import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
       if(arr.length <= 1){
           return true;
       }
       
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       HashSet<Integer> set = new HashSet<>();
       for(int val : arr){
            min = Math.min(val, min);
            max = Math.max(val, max);
            set.add(val);
        }
        
        int d = (max - min) / (arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            int ai = min + i * d;
            if(set.contains(ai) == false){
                return false;
            }
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