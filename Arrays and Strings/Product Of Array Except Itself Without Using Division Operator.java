import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        int n = arr.length;
        
        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];
        
        int i , j;
        
        left[0] = 1;
        
        right[n - 1] = 1;
        
        for( i = 1; i < n; i++){
            left[i] = arr[i - 1] * left[i - 1];
        }
        
        for( j = n - 2; j >= 0; j--){
            right[j] = arr[j + 1] * right[j + 1];
        }
        
        for( i = 0; i < n;i++){
            prod[i] = left[i] * right[i];
        }
        
        return prod;
    
        
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}