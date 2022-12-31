import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[]args) {
        //write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        mergeSort(arr,0,n - 1);
        System.out.println(count);
    }
    
    static int count = 0;
    public static int[] merge2SortedArrays(int[]left,int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[]merged = new int[left.length + right.length];
        
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]){
                merged[k] = left[i];
                i++;
                k++;
            } else {
                count += (left.length - i);
                merged[k] = right[j];
                k++;
                j++;
            }
        }
        
        while(i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        
        while(j < right.length) {
            merged[k] = right[j];
            k++;
            j++;
        }
        
        return merged;
    }
    
    public static int[] mergeSort(int[]arr,int lo,int hi) {
        if(lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        
        int mid = (lo + hi)/ 2;
        
        int[]left = mergeSort(arr,lo,mid);
        int[]right = mergeSort(arr, mid + 1, hi);
        
        int[]merged = merge2SortedArrays(left,right);
        
        return merged;
    }
}