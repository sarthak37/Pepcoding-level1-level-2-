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
  
  private static int maxTime = 0;
  
  public static void burnTree(TreeNode root, TreeNode blockNode, int time){
      if(root == null || root == blockNode) return;
      
      maxTime = Math.max(maxTime, time);
      
      burnTree(root.left,blockNode, time + 1);
      burnTree(root.right,blockNode, time + 1);
  }

  public static int burningTree_(TreeNode root, int fireNode) {
      if(root == null) return -1;
      
      if(root.val == fireNode){
           burnTree(root,null,0);
           return 1;
      }
      
      int leftTime = burningTree_(root.left,fireNode);
      if(leftTime != -1){
          burnTree(root,root.left,leftTime);
          return leftTime + 1;
      }
      
      int rightTime = burningTree_(root.right,fireNode);
      if(rightTime != -1){
          burnTree(root,root.right,rightTime);
          return rightTime + 1;
      }
      
      return -1;
  }
  
  public static int burningTree(TreeNode root, int fireNode) {
      burningTree_(root,fireNode);
      return maxTime;
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

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}