import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  static class TreeNode {
    int val;
    TreeNode left = null, right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] inorder, int isi, int iei, int[] levelOrder){
      if(isi > iei) return null;
      
      TreeNode root = new TreeNode(levelOrder[0]);
      if(levelOrder.length == 1) return root;
      
      int idx = isi;
      while(inorder[idx] != root.val) idx++;
      
      HashSet<Integer> set = new HashSet<>();
      for(int i = isi; i < idx; i++) set.add(inorder[i]);
      
      int[] lofls = new int[idx - isi];
      int[] lofrs = new int[iei - idx];
      int ls = 0, rs = 0;
      
      for(int i = 1; i < levelOrder.length; i++){
          int ele = levelOrder[i];
          if(set.size() != 0 && set.contains(ele)){
              lofls[ls++] = ele;
              set.remove(ele);
          } else {
              lofrs[rs++] = ele;
          }
      }
      
      root.left = buildTree(inorder, isi, idx - 1, lofls);
      root.right = buildTree(inorder, idx + 1, iei, lofrs);
      
      return root;
  }
  
  public static TreeNode buildTree(int[] inorder, int[] levelOrder){
      int n = inorder.length;
      return buildTree(inorder, 0, n - 1, levelOrder);
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

  int[] InOrder = new int[n];
  for (int i = 0; i < n; i++)
    InOrder[i] = scn.nextInt();

  int[] LevelOrder = new int[n];
  for (int i = 0; i < n; i++)
    LevelOrder[i] = scn.nextInt();

  TreeNode root = buildTree(InOrder, LevelOrder);
  display(root);
}

public static void main(String[] args) {
  solve();
}

}