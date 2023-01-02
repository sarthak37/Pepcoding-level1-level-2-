import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        int a = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int s = 0;
        int rem = 0;
        map.put(0, -1);
        
        for(int i = 0; i < arr.length; i++){
            s = s + arr[i];
            rem = s % k;
            
            if(rem < 0){
                rem = rem + k;
            }
            
            if(map.containsKey(rem)){
                int idx = map.get(rem);
                int len = i - idx;
                if(len > a){
                    a = len;
                }
            } else {
                map.put(rem, i);
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