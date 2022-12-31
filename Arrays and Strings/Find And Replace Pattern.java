import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
  public static boolean isMatching(String word, String pattern) {
    // write your code here
    HashMap<Character, Character> map = new HashMap<>();
    
    HashSet<Character> set = new HashSet<>();
    
    for(int i = 0; i < pattern.length(); i++){
        char wch = word.charAt(i);
        char pch = pattern.charAt(i);
        
        
        if(map.containsKey(pch) == true){
            if(map.get(pch) != wch){
                return false;
            }
         } else {
                if(set.contains(wch)){
                    return false;
                }
                map.put(pch,wch);
                set.add(wch);
            }
        }
        
        return true;
    }
    
    public static List<String> findAndReplacePattern(String[] words, String pattern){
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(isMatching(word, pattern)){
                res.add(word);
            }
        }
        
        return res;
    }

  // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String pattern = scn.nextLine();
    int n = scn.nextInt();
    scn.nextLine(); // to consume enter after number
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = scn.nextLine();
    }
    List<String> res = findAndReplacePattern(words, pattern);
    if (res.size() == 0) {
      System.out.println("Empty");
      return;
    }
    Collections.sort(res);
    for (String str : res) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}