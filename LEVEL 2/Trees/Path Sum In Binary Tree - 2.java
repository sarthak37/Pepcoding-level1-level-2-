import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  public static void pathSum(TreeNode root, int targetSum, ArrayList<ArrayList<Integer>> res,
         ArrayList<Integer> smallAns) {
             if(root == null)
             return;
             
             if(root.left == null && root.right == null) {
                 if(targetSum - root.val == 0) {
                     ArrayList<Integer> base = new ArrayList<>(smallAns);
                     base.add(root.val);
                     res.add(base);
                 }
                                     
                return;
            }  
                                 
            smallAns.add(root.val);
            
            pathSum(root.left, targetSum - root.val, res, smallAns);
            pathSum(root.right, targetSum - root.val, res, smallAns);
            
            smallAns.remove(smallAns.size() - 1);
        }

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> smallAns = new ArrayList<>();
    pathSum(root, targetSum, res, smallAns);
    return res;
  }

  // input_Section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}