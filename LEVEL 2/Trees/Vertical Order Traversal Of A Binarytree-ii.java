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
    
    public static class vPair{
        TreeNode node = null;
        int h1 = 0;
        
        vPair(TreeNode node,int h1){
            this.node = node;
            this.h1 = h1;
        }
    }
    
    public static void width(TreeNode node, int h1, int[] minMax){
        if(node == null) return;
        
        minMax[0] = Math.min(minMax[0],h1);
        minMax[1] = Math.max(minMax[1],h1);
        
        width(node.left, h1 - 1, minMax);
        width(node.right, h1 + 1, minMax);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        PriorityQueue<vPair> parQue = new PriorityQueue<>((a,b)->{
            return a.node.val - b.node.val;
        });
        
        PriorityQueue<vPair> chQue = new PriorityQueue<>((a,b)->{
            return a.node.val - b.node.val;
        });
        
        int[] minMax = new int[2];
        width(root,0,minMax);
        int len = minMax[1] - minMax[0] + 1;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len; i++)  ans.add(new ArrayList<>());
        
        parQue.add(new vPair(root,Math.abs(minMax[0])));
        while(parQue.size() != 0){
            int size = parQue.size();
            while(size-- > 0){
                
                vPair rp = parQue.remove();
                TreeNode node = rp.node;
                int h1 = rp.h1;
                
                ans.get(h1).add(node.val);
                
                if(node.left != null)  chQue.add(new vPair(node.left,h1 - 1));
                
                if(node.right != null)  chQue.add(new vPair(node.right,h1 + 1));
            }
            
                PriorityQueue<vPair> temp = parQue;
                parQue = chQue;
                chQue = temp;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
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