package easy;

public class MaximumDepthBinaryTree
{
  private static int depthMax;
  private static int depth;

  public static int maxDepth(TreeNode root)
  {
    depthMax = 0;
    depth = 0;
    binaryTreeInorder(root);

    return depthMax;
  }

  public static void binaryTreeInorder(TreeNode btree) 
  {
    if (btree != null) {
      depth++;
      if (depth > depthMax) {
        depthMax = depth;
      }
      binaryTreeInorder(btree.left);

      binaryTreeInorder(btree.right);
      depth--;
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return its maximum depth.\n\n";

    str += "A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.\n";
    
    System.out.println(str);
  }
}