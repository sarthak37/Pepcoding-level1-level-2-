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
  
  public static void exactlyOneChild(TreeNode root, ArrayList<Integer> ans){
      if(root == null || (root.left == null && root.right == null))
return;
      
      if(root.left == null || root.right == null){
          ans.add(root.val);
      }
      
      exactlyOneChild(root.left, ans);
      exactlyOneChild(root.right, ans);
      
  }

  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    exactlyOneChild(root,ans);
    return ans;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = exactlyOneChild(root);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.print(ele + " ");
  }

  public static void main(String[] args) {
    solve();
  }
}