import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [][] a = new int[n][m];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                a[i][j] = sc.nextInt();
            }
        }
        
        int minr = 0;
        int minc = 0;
        int maxr = a.length - 1;
        int maxc = a[0].length - 1;
        int tn = n * m;
        int cnt = 0;
        
        while(cnt < tn){
            for(int i = minr, j = minc; i <= maxr && cnt < tn; i++){
                System.out.println(a[i][j]);
                cnt++;
            }
            
            minc++;
            
            for(int i = maxr, j = minc; j <= maxc && cnt < tn; j++){
                System.out.println(a[i][j]);
                cnt++;
            }
            
            maxr--;
            
            for(int i = maxr, j = maxc; i >= minr && cnt < tn; i--){
                System.out.println(a[i][j]);
                cnt++;
            }
            
            maxc--;
            
            for(int i = minr, j = maxc; j >= minc && cnt < tn; j--){
                System.out.println(a[i][j]);
                cnt++;
            }
            
            minr++;
            
            
        }
    }

}