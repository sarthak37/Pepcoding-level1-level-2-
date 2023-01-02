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
  

  public static void burnTree(TreeNode root, TreeNode blockNode, int time,ArrayList<ArrayList<Integer>> ans){
      if(root == null || root == blockNode) return;
      
      if(time == ans.size()) ans.add(new ArrayList<>());
      ans.get(time).add(root.val);
      
      burnTree(root.left,blockNode, time + 1,ans);
      burnTree(root.right,blockNode, time + 1,ans);
  }

  public static int burningTree(TreeNode root, int data, ArrayList<ArrayList<Integer>> ans) {
      if(root == null) return -1;
      
      if(root.val == data){
           burnTree(root,null,0,ans);
           return 1;
      }
      
      int leftTime = burningTree(root.left,data,ans);
      if(leftTime != -1){
          burnTree(root,root.left,leftTime, ans);
          return leftTime + 1;
      }
      
      int rightTime = burningTree(root.right,data,ans);
      if(rightTime != -1){
          burnTree(root,root.right,rightTime, ans);
          return rightTime + 1;
      }
      
      return -1;
  }
  

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      burningTree(root,data,ans);
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}