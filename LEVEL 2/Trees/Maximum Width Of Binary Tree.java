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
  
  public static class pair{
      TreeNode node = null;
      int idx = 0;
      
      pair(TreeNode node, int idx){
          this.node = node;
          this.idx = idx;
      }
  }

  public static int widthOfBinaryTree(TreeNode root) {
      LinkedList<pair> que = new LinkedList<>();
      int max = 0;
      
      que.addLast(new pair(root,0));
      while(que.size() != 0){
          int size = que.size();
          int lm = que.getFirst().idx;
          int rm = que.getFirst().idx;
          while(size-->0){
              pair rp = que.removeFirst();
              rm = rp.idx;
              
              if(rp.node.left != null) que.addLast(new pair(rp.node.left,rp.idx * 2 + 1));
              if(rp.node.right != null) que.addLast(new pair(rp.node.right,rp.idx * 2 + 2));
          }
          
          max = Math.max(max, rm  - lm + 1);
      }
      
      return max;
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}