import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        int a = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int s = 0;
        int rem = 0;
        map.put(0, 1);
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                s = s + 1;
            } else {
                s = s - 1;
            }
            
            if(map.containsKey(s)){
                a = a + map.get(s);
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
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