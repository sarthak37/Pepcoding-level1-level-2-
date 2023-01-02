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
    
    public static void width(TreeNode node, int h1, int[] minMax){
        if(node == null) return;
        
        minMax[0] = Math.min(minMax[0], h1);
        minMax[1] = Math.max(minMax[1], h1);
        
        width(node.left, h1 - 1, minMax);
        width(node.right, h1 + 1, minMax);
    }
    
    public static class vPair{
        TreeNode node = null;
        int h1 = 0;
        
        vPair(TreeNode node,int h1){
            this.node = node;
            this.h1 = h1;
        }
    }

    public static ArrayList<Integer> TopView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        int[] minMax = new int[2];
        width(root,0, minMax);
        int len =  minMax[1] - minMax[0] + 1;
        
        for(int i = 0; i < len; i++) ans.add(null);
        
        
        
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minMax[0])));
        while(que.size() !=0){
            int size = que.size();
            while(size-- > 0){
                vPair rp = que.removeFirst();
                
                TreeNode node = rp.node;
                int h1 = rp.h1;
                
                if(ans.get(h1) == null) ans.set(h1,node.val);
                
                if(node.left != null) que.addLast(new vPair(node.left, h1 - 1));
                if(node.right != null) que.addLast(new vPair(node.right, h1 + 1));
            }
        }
        
        return ans;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}