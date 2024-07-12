package tree;

public class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
  public void show()
  {
    TreeNode root = this;
    if (root == null) {
      System.out.print("This tree is null.");
      return;
    }
    show_inorder(root);
  }

  static void show_inorder(TreeNode node) {
    if (node != null) {
      show_inorder(node.left);
      System.out.print(node.val + " ");
      show_inorder(node.right);
    }
  }
  
}