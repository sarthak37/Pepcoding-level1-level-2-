import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }
  
  static HashMap<String,String> parent;
  static HashMap<String,Integer> rank;


  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
      parent = new HashMap<>();
      rank = new HashMap<>();
      
      if(Sentence1.length!=Sentence2.length){
          return false;
      }
      
      for(String[]p:pairs){
          union(p[0],p[1]);
      }
      
      for(int i = 0; i < Sentence1.length; i++){
          String w1 = Sentence1[i];
          String w2 = Sentence2[i];
          if(w1.equals(w2) == false && find(w1).equals(find(w2))==false){
              return false;
          }
      }
      
      return true;
  }
  
  public static void union (String x, String y){
      String lx = find(x);
      String ly = find(y);
      
      if(lx.equals(ly) == false){
          if(rank.get(lx) > rank.get(ly)){
              parent.put(ly,lx);
          } else if(rank.get(lx) < rank.get(ly)){
              parent.put(lx,ly);
          } else {
              parent.put(lx,ly);
              rank.put(ly,rank.get(ly) + 1);
          }
      }
  }
  
  public static String find(String x){
      if(parent.containsKey(x) == false){
          parent.put(x,x);
          rank.put(x,1);
      }
      
      if(x.equals(parent.get(x)) == true){
          return x;
      }
      
      String temp = find(parent.get(x));
      parent.put(x,temp);
      return temp;
  }

}