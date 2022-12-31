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
    
    private static int idx = 0;
    private static TreeNode bstFromPostorder(int[] postorder, int lr, int rr){
        if(idx < 0 || postorder[idx] < lr || postorder[idx] > rr){
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[idx--]);
        
        node.right = bstFromPostorder(postorder, node.val, rr);
        node.left = bstFromPostorder(postorder, lr , node.val);
        
        return node;
    }

    public static TreeNode bstFromPostorder(int[] postorder) {
        idx = postorder.length - 1;
        int lr = -(int)1e9 - 1;
        int rr = (int)1e9 + 1;
        
        return bstFromPostorder(postorder, lr, rr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}