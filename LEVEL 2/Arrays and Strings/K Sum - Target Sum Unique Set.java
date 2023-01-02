import java.util.*;

public class Main {
    public static List<List<Integer>> twoSum(int[] arr, int target, int si) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n - si < 2) return res;
        
        int left = si;
        int right = n - 1;
        
        
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
    
    public static List<List<Integer>> kSumHelper(int[] arr, int target, int k, int si) {
        if(k == 2) {
            return twoSum(arr, target, si);
        }
        
        int n = arr.length;
        
        List<List<Integer>> res = new ArrayList<>();
        if(n - k < 0){
            return res;
        }
        
        for(int i = si; i <= n - k; i++) {
            if(i != si && arr[i] == arr[i - 1]){
                continue;
            }
            
            int val1 = arr[i];
            List<List<Integer>> subRes = kSumHelper(arr, target - val1, k - 1, i + 1);
            for(List<Integer> list : subRes) {
                list.add(val1);
                res.add(list);
            }
        }
        
        return res;
    }

  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    // write your code here
    Arrays.sort(arr);
    return kSumHelper(arr, target, k, 0);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
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