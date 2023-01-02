import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static List<Integer> findDuplicates(int[] nums) {
    // write your code here
    List<Integer> res = new ArrayList<>();
    
    for(int i = 0; i < nums.length; i++){
        int indx = Math.abs(nums[i]) - 1;
        int val = nums[indx];
        
        if(val < 0){
            res.add(indx + 1);
        } else {
            nums[indx] *= -1;
        }
    }
    
    return res;
  }

  // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    List<Integer> res = findDuplicates(arr);
    if (res.size() == 0) {
      System.out.println("Empty");
      return;
    }
    Collections.sort(res);
    for (int val : res)
      System.out.print(val + " ");
    System.out.println();
  }
}