import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
		Arrays.sort(nums);   
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
		    if(i != 0 && nums[i] == nums[i - 1])  continue;
		    
		    for(int j = i + 1; j < n; j++){
		        if(j != i + 1 && nums[j] == nums[j - 1]) continue;
		        
		        int si = j + 1;
		        int ei = n - 1;
		        while(si < ei){
		            int sum = nums[i] + nums[j] + nums[si] + nums[ei];
		            if(sum > target) ei--;
		            else if(sum < target) si++;
		            else {
		                res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[si] , nums[ei])));
		                si++;
		                ei--;
		                
		                while(si < ei && nums[si] == nums[si - 1]) si++;
		                while(si < ei && nums[ei] == nums[ei + 1]) ei--;
		            }
		        }
		}
		
		
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans,(a,b)->{
            int i = 0;
            int j = 0;
            
            while(i < a.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else{
                    return a.get(i) - b.get(j);
                }
            }
            
            return 0;
        }); 
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}