import java.util.*;

public class Main {
    public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target) {
      int left = si;
      int right = ei;
      List<List<Integer>> res = new ArrayList<>();
      while(left < right) {
          if(left != si && arr[left] == arr[left - 1]) {
              left++;
              continue;
          }
          int sum = arr[left] + arr[right];
          
          if(sum == target) {
              List<Integer> subres = new ArrayList<>();
              subres.add(arr[left]);
              subres.add(arr[right]);
              res.add(subres);
              
              left++;
              right--;
          } else if(sum > target) {
              right--;
          } else {
              left++;
          }
      }
      
      return res;
  }
  public static List<List<Integer>> threeSum(int[] arr, int target, int si) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    int n = arr.length;
    if(n - si < 3) return res;
    
    Arrays.sort(arr);
    
    for(int i = si ; i <= n - 3; i++) {
        if(i != si && arr[i] == arr[ i - 1]) continue;
        
        int val1 = arr[i];
        int targ = target - val1;
        List<List<Integer>> subRes = twoSum(arr, i + 1, n - 1, targ);
        for(List<Integer> list : subRes) {
            list.add(val1);
            res.add(list);
        }
    }
    
    return res;
  }

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if(n < 4) return res;
    
    Arrays.sort(nums);
    
    for(int i = 0 ; i <= n - 4; i++) {
        if(i != 0 && nums[i] == nums[ i - 1]) continue;
        
        int val1 = nums[i];
        List<List<Integer>> subRes = threeSum(nums, target - val1, i + 1);
        for(List<Integer> list : subRes) {
            list.add(val1);
            res.add(list);
        }
    }
    
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }
}