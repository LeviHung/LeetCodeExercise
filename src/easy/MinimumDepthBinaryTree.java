package easy;

public class MinimumDepthBinaryTree
{
  private static int depthMin;
  private static int depth;
  private static int minDepth = Integer.MAX_VALUE;
  private static int currentDepth = 0;

  public static int minDepth(TreeNode root)
  {
    if (root == null) {
      return 0;
    }
    depthMin = 100000;
    depth = 0;
    binaryTreeInorder(root);

    return depthMin;
  }

  public static void binaryTreeInorder(TreeNode btree) 
  {
    if (btree == null) {
      return;
    }
    depth++;
    binaryTreeInorder(btree.left);
    if (btree.left == null && btree.right == null) {
      if (depth < depthMin) {
        depthMin = depth;
      }
    }
    binaryTreeInorder(btree.right);
    depth--;
  }

  public static int minDepthOpt(TreeNode root) 
  {
    if (root == null) 
      return 0;
    
    calculateDepth(root);
    return minDepth;
  }

  private static void calculateDepth(TreeNode node) 
  {
    currentDepth++;
    if (currentDepth == minDepth) {
      currentDepth--;
      return;
    }
    
    if (node.left == null && node.right == null) {
      minDepth = Math.min(minDepth, currentDepth);
      currentDepth--;
      return;
    }
    
    if (node.left != null && 
       (node.right == null || node.right.left != null ||     node.right.right != null)) {
      calculateDepth(node.left);
    }
          
    if (node.right != null) {
      calculateDepth(node.right);
    }
    currentDepth--;
  }

  public static void readme()
  {
    String str = "Given a binary tree, find its minimum depth.\n\n";

    str += "The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.\n\n";

    str += "Note: A leaf is a node with no children.";
    System.out.println(str);
  }
}