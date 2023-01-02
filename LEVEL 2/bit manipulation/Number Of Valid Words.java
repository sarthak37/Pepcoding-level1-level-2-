import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
		for(int i = 0 ; i < m; i++){
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
	}
	
	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, new ArrayList<>());
        }
        for (String word : words) {
            int temp = 0;
            //make bit mask of every word
            for (char c : word.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            //jo jo bit on hai uske saamne word rkh diya
            for (int i = 0; i < 26; i++) {
                if ((temp & (1 << i)) != 0) {
                    map.get(i).add(temp);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            int temp = 0;
            //make bit mask of a puzzle
            for (char c : p.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            //bring out the first character
            int c = p.charAt(0) - 'a';
            int count = 0;
            for (int key : map.get(c)) {
                if ((key & temp) == key) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}