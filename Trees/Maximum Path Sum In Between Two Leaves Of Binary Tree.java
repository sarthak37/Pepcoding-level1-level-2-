import java.util.Scanner;

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
  
  public static class pair{
      int LTLMaxSum = -(int)1e9 - 1;
      int NTLMaxSum = -(int)1e9 - 1;
  }
  
  

  public static pair maxPathSum_(TreeNode root) {
    pair myAns = new pair();
    
    if(root == null) return myAns;
    if(root.left == null && root.right == null){
        myAns.NTLMaxSum = root.val;
        return myAns;
    }
    
    pair lp = maxPathSum_(root.left);
    pair rp = maxPathSum_(root.right);
     
     myAns.LTLMaxSum = Math.max(lp.LTLMaxSum,rp.LTLMaxSum);
     
     if(root.left != null && root.right != null){
         myAns.LTLMaxSum = Math.max(myAns.LTLMaxSum, lp.NTLMaxSum + root.val + rp.NTLMaxSum);
     }
     
     myAns.NTLMaxSum = Math.max(lp.NTLMaxSum,rp.NTLMaxSum) + root.val;
     return myAns;
    
  }
  
  public static int maxPathSum(TreeNode root) {
      return maxPathSum_(root).LTLMaxSum;
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

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}