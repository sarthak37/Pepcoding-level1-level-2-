import java.io.*;
import java.util.*;

public class Main {

    static class StockSpanner {

        static class Pair{
            int price;
            int index;
        }
        
        Stack<Pair> st;
        int time = 0;
        
        public StockSpanner() {
            st = new Stack<>();
            Pair base = new Pair();
            base.price = 1000000;
            base.index = -1;
            st.push(base);
        }
        
        public int next(int price) {
            Pair p = new Pair();
            p.price = price;
            p.index = time;
            time++;
            while(st.peek().price <= p.price){
                st.pop();
            }
            int ans = p.index - st.peek().index;
            
            st.push(p);
            
            return ans;
            
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StockSpanner obj = new StockSpanner();

        while(read.ready()){
            int price = Integer.parseInt(read.readLine());
            System.out.println(obj.next(price));
        }        
    }
}