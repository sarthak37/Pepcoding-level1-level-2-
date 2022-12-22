import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str1, String str2) {
	    int n = str1.length();
	    
	    int[][] dpt = new int[n][n];
	    int[][] dpf = new int[n][n];
	    
	    for(int g = 0; g < n; g++){
	        for(int i = 0, j = g; j < n; i++, j++){
	            if(g == 0){
	                char ch = str1.charAt(i);
	                
	                if(ch == 'T'){
	                    dpt[i][j] = 1;
	                    dpf[i][j] = 0;
	                } else {
	                    dpt[i][j] = 0;
	                    dpf[i][j] = 1;
	                }
	            } else {
	                for(int k = i; k < j; k++){
	                    char oprtr = str2.charAt(k);
	                    int ltc = dpt[i][k];
	                    int rtc = dpt[k + 1][j];
	                    int lfc = dpf[i][k];
	                    int rfc = dpf[k + 1][j];
	                    
	                    if(oprtr == '&'){
	                        dpt[i][j] += ltc * rtc;
	                        dpf[i][j] += lfc * rtc + ltc * rfc + lfc * rfc;
	                    } else if(oprtr == '|'){
	                        dpt[i][j] += ltc * rtc + lfc * rtc + ltc * rfc;
	                        dpf[i][j] += lfc * rfc;
	                    } else {
	                        dpt[i][j] += ltc * rfc + lfc * rtc;
	                        dpf[i][j] += lfc * rfc + ltc * rtc;
	                        
	                    }
	                    
	                }
	            }
	        }
	    }
	    
	    return dpt[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}