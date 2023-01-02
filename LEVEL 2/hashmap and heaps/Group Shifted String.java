import java.util.*;

public class Main {

	public static String getKey(String str) {
		// write your code here
		String key = "";
		
		for(int i = 1; i < str.length(); i++){
		    char curr = str.charAt(i);
		    char prev = str.charAt(i - 1);
		    int diff = curr - prev;
		    
		    if(diff < 0){
		        diff = diff + 26;
		    }
		    
		    key = key + diff + "#";
		}
		
		key  += ".";

		return key;
	}
	
	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
	    HashMap<String, ArrayList<String>> map = new HashMap<>();
	    
	    for(String str: strs){
	        String key = getKey(str);
	        if(map.containsKey(key) == false){
	            ArrayList<String> list = new ArrayList<>();
	            list.add(str);
	            map.put(key, list);
	        } else {
	            ArrayList<String> list = map.get(key);
	            list.add(str);
	        }
	    }
	    
	    ArrayList<ArrayList<String>> res = new ArrayList<>();
	    for(ArrayList<String> list: map.values()){
	        res.add(list);
	    }
	    
	    return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}