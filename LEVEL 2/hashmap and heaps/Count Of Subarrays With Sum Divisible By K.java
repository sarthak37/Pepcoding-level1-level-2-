import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        int a = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int rem = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }
            
            if(map.containsKey(rem)){
                a = a + map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }

        return a;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}