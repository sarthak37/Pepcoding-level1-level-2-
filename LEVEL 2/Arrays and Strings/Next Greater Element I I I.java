import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        // write your code here
        char[] arr = str.toCharArray();
        
        int i = arr.length - 2;
        
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
        
        if(i == -1){
            return "-1";
        }
        
        int k = arr.length - 1;
        while(arr[i] >= arr[k]) {
            k--;
        }
        
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
        
        String res = "";
        for(int j = 0; j <= i; j++){
            res = res + arr[j];
        }
        
        for(int j = arr.length - 1; j > i; j--){
            res = res + arr[j];
        }
        
        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}