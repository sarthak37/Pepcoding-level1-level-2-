import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        int a = 0;
        
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        
        String key = (c1 - c0) + "#" + (c2 - c1);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(key, 1);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                c0++;
            } else if(arr[i] == 1){
                c1++;
            } else {
                c2++;
            }
            
            key = (c1 - c0) + "#" + (c2 - c1);
            
            if(map.containsKey(key)){
                a = a + map.get(key);
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
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
        System.out.println(solution(arr));
    }

}