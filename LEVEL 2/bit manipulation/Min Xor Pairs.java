import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int[] arr) {
        //write your code here
        Arrays.sort(arr);
        
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length - 1; i++){
            int xor = arr[i] ^ arr[i + 1];
            if(xor < min){
                min = xor;
                res = new ArrayList<>();
                res.add(arr[i] + ", " + arr[i + 1]);
            } else if(xor == min){
                res.add(arr[i] + ", " + arr[i + 1]);
            }
        }
        
        for(String val: res){
            System.out.println(val);
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}