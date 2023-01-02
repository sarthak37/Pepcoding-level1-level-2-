import java.util.Scanner;
import java.util.LinkedList;

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
        TreeNode par = null;
        int lb = -(int)1e9;
        int rb =  (int)1e9;
        
        pair(TreeNode par, int lb, int rb){
            this.par = par;
            this.lb = lb;
            this.rb = rb;
        }
        
        pair(){
            
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        int n = LevelOrder.length;
        LinkedList<pair> que = new LinkedList<>();
        que.add(new pair());
        TreeNode root = null;
        
        int idx = 0;
        while(que.size() != 0 && idx < n){
            pair rp = que.removeFirst();
            int ele = LevelOrder[idx];
            
            if(ele < rp.lb || ele > rp.rb) continue;
            
            TreeNode node = new TreeNode(ele);
            idx++;
            if(rp.par == null) root = node;
            else {
                TreeNode par = rp.par;
                if(ele <= par.val) par.left = node;
                else par.right = node;
            }
            
            que.addLast(new pair(node, rp.lb, ele));
            que.addLast(new pair(node, ele, rp.rb));
        }
        
        return root;
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}