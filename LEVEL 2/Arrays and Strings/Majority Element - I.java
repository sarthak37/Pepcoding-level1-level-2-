import java.util.*;

public class Main {
    
    public static int v(int[] arr){
        int val = arr[0];
        int count = 1;
        
        for(int  i = 1; i < arr.length; i++){
            if(val == arr[i]){
                count++;
            } else {
                count--;
            }
            
            if(count == 0){
                val = arr[i];
                count = 1;
            }
        }
        
        return val;
    }

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static void printMajorityElement(int[] arr) {
        // write your code here
        int value = v(arr);
        
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value)
                count++;
            }
            
            if(count > arr.length / 2){
                System.out.println(value);
            } else {
                System.out.println("No Majority Element exist");
            }
        }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}