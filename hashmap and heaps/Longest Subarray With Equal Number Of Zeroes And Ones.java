import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        int a = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int s = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                s = s + 1;
            } else {
                s = s - 1;
            }
            
            if(map.containsKey(s)){
                int idx =  map.get(s);
                int len = i - idx;
                if(len > a){
                    a = len;
                }
            } else {
                map.put(s, i);
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