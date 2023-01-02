import java.io.*;
import java.util.*;

public class Main {

  public static class TwoStack {
    int[] data;
    int tos1;
    int tos2;

    public TwoStack(int cap) {
      // write your code here
      data = new int[cap];
      tos1 = -1;
      tos2 = data.length;
    }

    int size1() {
      // write your code here
      return tos1 + 1;
    }

    int size2() {
      // write your code here
      return data.length - tos2;
    }

    void push1(int val) {
      // write your code here
      if(tos2 == tos1 + 1){
          System.out.println("Stack overflow");
      } else {
          tos1++;
          data[tos1] = val;
      }
    }

    void push2(int val) {
      // write your code here
      if(tos2 == tos1 + 1){
          System.out.println("Stack overflow");
      } else {
          tos2--;
          data[tos2] = val;
      }
    }

    int pop1() {
      // write your code here
      if(size1() == 0){
          System.out.println("Stack underflow");
          return -1;
      } else {
          int val = data[tos1];
          tos1--;
          return val;
      }
      
    }

    int pop2() {
      // write your code here
      if(size2() == 0){
          System.out.println("Stack underflow");
          return -1;
      } else {
          int val = data[tos2];
          tos2++;
          return val;
      }
    }

    int top1() {
      // write your code here
      if(size1() == 0){
          System.out.println("Stack underflow");
          return -1;
      } else {
          int val = data[tos1];
          return val;
      }
    }

    int top2() {
      // write your code here
      if(size2() == 0){
          System.out.println("Stack underflow");
          return -1;
      } else {
          int val = data[tos2];
          return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TwoStack st = new TwoStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = br.readLine();
    }
  }
}