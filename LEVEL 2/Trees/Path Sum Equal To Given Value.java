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
  
  
  public static class pairSum{
      int NTN_MaxSum = -(int)1e9;
      int RTN_MaxSum = 0;
  }
  
  public static int getMaxSum(int... arr){
      int maxSF = arr[0];
      for(int ele : arr)
          maxSF = Math.max(maxSF,ele);
      return maxSF;      
  }
  
  public static pairSum maxPathSum_(TreeNode root) {
      if(root == null) return new pairSum();
      
      pairSum lp = maxPathSum_(root.left);
      pairSum rp = maxPathSum_(root.right);
      
      pairSum myAns = new pairSum();
      
      int RTN_maxSum = Math.max(lp.RTN_MaxSum,rp.RTN_MaxSum) + root.val;
      
      int NTN_MaxSum = getMaxSum(lp.NTN_MaxSum,rp.NTN_MaxSum,lp.RTN_MaxSum + root.val + rp.RTN_MaxSum, root.val,RTN_maxSum);
      
      myAns.RTN_MaxSum = Math.max(RTN_maxSum,root.val);
      myAns.NTN_MaxSum = NTN_MaxSum;
      
      return myAns;
  }

  static int NTN_MaxAns = -(int)1e9;
  public static int maxPathSum_02(TreeNode root) {
      if(root == null) return 0;
      
      int RTN_LmaxSum = maxPathSum_02(root.left);
      int RTN_RmaxSum = maxPathSum_02(root.right);
      
      int RTN_maxSum = Math.max(RTN_LmaxSum,RTN_RmaxSum) + root.val;
      
       NTN_MaxAns = getMaxSum(NTN_MaxAns,RTN_LmaxSum + root.val + RTN_RmaxSum, root.val,RTN_maxSum);
      
      return Math.max(RTN_maxSum,root.val);
  }
  
  
  public static int maxPathSum(TreeNode root) {
      if(root == null) return 0;
     maxPathSum_02(root);
      
      return NTN_MaxAns;
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