import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        int ans = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        int cz = 0;
        int co = 0;
        int ct = 0;
        int d10 = co - cz;
        int d21 = ct - co;
        String key = d21 + "#" + d10;
        map.put(key, -1);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                cz++;
            } else if(arr[i] == 1){
                co++;
            } else {
                ct++;
            }
            
            d10 = co - cz;
            d21 = ct - co;
            key = d21 + "#" + d10;
            
            if(map.containsKey(key)){
                int idx = map.get(key);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                } 
            }else {
                map.put(key, i);
            }
        }
    
    return ans;
     
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