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

    public static TreeNode constructFromPrePost(int[] pre, int psi,  int pei, int[] post, int ppsi, int ppei) {
        if(psi > pei){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[psi]);
        if(psi == pei){
            return root;
        }
        
        int idx = ppsi;
        while(post[idx] != pre[psi + 1]){
            idx++;
        }
        
        int tnel = idx - ppsi + 1;
        
        root.left = constructFromPrePost(pre, psi + 1, psi + tnel, post, ppsi, idx);
        root.right = constructFromPrePost(pre, psi + tnel + 1, pei, post, idx + 1, ppei - 1);
        
        return root;
    }
    
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        return constructFromPrePost(pre, 0, n - 1, post, 0, n - 1);
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

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}