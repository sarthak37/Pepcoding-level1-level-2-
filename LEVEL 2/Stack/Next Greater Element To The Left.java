import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "
");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] ngl = solve(a);
    display(ngl);
  }

  public static int[] solve(int[] arr) {
    int n = arr.length;
    int ngl[] = new int[n];
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < n; i++){
        while(st.size() > 0 && st.peek() <= arr[i]){
            st.pop();
        }
        
        if(st.size() > 0){
            ngl[i] = st.peek();
        } else {
            ngl[i] = -1;
        }
        
        st.push(arr[i]);
    }
    
    return ngl;
  }

}