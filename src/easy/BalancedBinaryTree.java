package easy;

public class BalancedBinaryTree
{
  private static boolean isBalancedTree;
  private static int depth;

  public static boolean isBalanced(TreeNode root)
  {
    isBalancedTree = true;
    depth = 0;
    int d = binaryTreeInorder(root);

    return isBalancedTree;
    
  }
  //    3
  // 9    20
  //    15  7

  //         1
  //     2       2
  //   3   3
  // 4   4

  //          1
  //      2       3
  //   4    5   6 
  // 8
  public static int binaryTreeInorder(TreeNode btree) 
  {
    int depthLeft;
    int depthRight;
    
    boolean result = false;
    if (btree == null) {
      return depth;
    }

    depth++;
    depthLeft = binaryTreeInorder(btree.left);
    depthRight = binaryTreeInorder(btree.right);
    depth--;

    if (depthLeft > depthRight) {
      if ((depthLeft - depthRight) > 1) {
        isBalancedTree = false;
      }
    } else {
      if ((depthRight - depthLeft) > 1) {
        isBalancedTree = false;
      }
    }

    if (depthLeft > depthRight) {
      return depthLeft;
    } else {
      return depthRight;
    }    
  }


  public static void readme()
  {
    String str = "Given a binary tree, determine if it is height-balanced.\n";

    System.out.println(str);
  }
}