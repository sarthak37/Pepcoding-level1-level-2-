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

    public static TreeNode buildTree(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi > iei) return null;
        
        TreeNode node = new TreeNode(postorder[pei]);
        
        int idx = isi;
        while(inorder[idx] != postorder[pei]) idx++;
        int tnel = idx - isi;
        
        
        
        node.left = buildTree(postorder, psi ,psi + tnel - 1, inorder, isi, idx - 1);
        node.right = buildTree(postorder, psi + tnel, pei - 1, inorder, idx + 1,iei);
        return node;
       
    }
    
     public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n =  inorder.length;
        
        return buildTree(postorder, 0, n - 1, inorder, 0 , n - 1);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}