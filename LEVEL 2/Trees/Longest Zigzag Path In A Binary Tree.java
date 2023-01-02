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
        int forwardSlop = -1;
        int backwardSlop = -1;
        int maxLen = 0;
    }
    
    public static pair longestZigZagPath_(TreeNode root) {
        if(root == null) return new pair();
        
        pair left = longestZigZagPath_(root.left);
        pair right = longestZigZagPath_(root.right);
        
        pair myAns = new pair();
        myAns.maxLen = Math.max(Math.max(left.maxLen,right.maxLen),Math.max(left.backwardSlop, right.forwardSlop) + 1);
        
        myAns.forwardSlop = left.backwardSlop + 1;
        myAns.backwardSlop = right.forwardSlop + 1;
        
        return myAns;
    }
    
    static int maxLen = 0;
    
    public static int[] longestZigZagPath_02(TreeNode root){
        if(root == null) return new int[]{-1,-1};
        
        int[] left = longestZigZagPath_02(root.left);
        int[] right = longestZigZagPath_02(root.right);
        
        maxLen = Math.max(maxLen,Math.max(left[1],right[0]) + 1);
        return new int[]{left[1] + 1,right[0] + 1};
    }

    public static int longestZigZagPath(TreeNode root) {
        longestZigZagPath_02(root);
        return maxLen;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}