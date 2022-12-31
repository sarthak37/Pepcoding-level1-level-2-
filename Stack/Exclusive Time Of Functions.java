import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair{
        int id;
        int st;
        int ct;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // use read for taking inputF
        int n = Integer.parseInt(read.readLine());
        
        int timeF[] = new int[n];
        int len = Integer.parseInt(read.readLine());
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0; i < len; i++){
            String log[] = read.readLine().split(":");
            
            if(log[1].equals("start")){
                Pair p = new Pair();
                p.id = Integer.parseInt(log[0]);
                p.st = Integer.parseInt(log[2]);
                p.ct = 0;
                st.push(p);
            } else {
                Pair p = st.pop();
                int interval = Integer.parseInt(log[2]) - p.st + 1;
                int time = interval - p.ct;
                timeF[p.id] += time;
                
                if(st.size() > 0){
                    st.peek().ct += interval;
                }
            }
        }
        
        for(int e: timeF){
            System.out.println(e);
        }
    }
}