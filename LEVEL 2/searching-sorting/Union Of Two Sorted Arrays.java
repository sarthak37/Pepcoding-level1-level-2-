import java.util.*;
import java.io.*;

public class Main {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] a,int[] b) {
        //write your code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                if(list.size() > 0 && list.get(list.size() - 1) != a[i]){
                    list.add(a[i]);
                }
                
                else if(list.size() == 0){
                    list.add(a[i]);
                }
                
                i++;
                j++;
            }
            else if(a[i] < b[j]) {
                if(list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                
                else if(list.size() == 0){
                    list.add(a[i]);
                }
                
                i++;
            }
            
            else {
                if(list.size() > 0 && list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
                }
                
                else if(list.size() == 0){
                    list.add(b[j]);
                }
                
                j++;
        }
    }
    
    while(i < a.length){
        if(list.get(list.size() - 1) != a[i]){
            list.add(a[i]);
        }
        
        i++;
    }
    
    while(j < b.length){
        if(list.get(list.size() - 1) != b[j]){
            list.add(b[j]);
        }
        
        j++;
    }
    
    return list;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}