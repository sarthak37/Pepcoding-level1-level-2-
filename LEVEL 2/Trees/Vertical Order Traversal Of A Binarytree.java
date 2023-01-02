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
    
    public  static class vPair{
        TreeNode node = null;
        int h1 = 0;
        
        vPair(TreeNode node,int h1){
            this.node = node;
            this.h1 = h1;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        LinkedList<vPair> que = new LinkedList<>();
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int minh1 = 0, maxh1 = 0;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        que.addLast(new vPair(root,0));
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                vPair rp = que.removeFirst();
                
                maxh1 = Math.max(maxh1,rp.h1);
                minh1 = Math.min(minh1,rp.h1);
                
                map.putIfAbsent(rp.h1,new ArrayList<>());
                map.get(rp.h1).add(rp.node.val);
                
                if(rp.node.left != null) que.addLast(new vPair(rp.node.left,rp.h1 - 1));
                if(rp.node.right != null) que.addLast(new vPair(rp.node.right,rp.h1 + 1));
                
                
            }
        }
        
        for(int i = minh1; i <= maxh1; i++){
            ans.add(map.get(i));
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

        List<List<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (List<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}