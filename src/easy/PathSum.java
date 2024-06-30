package easy;

public class PathSum
{
  private static int sum;
  public static boolean hasPathSum(TreeNode root, int targetSum)
  {
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1
    sum = 0;
    
    return binaryTreeInorder(root, targetSum);
  }

  public static boolean binaryTreeInorder(TreeNode btree, int target) 
  {
    if (btree == null) {
      return false;
    }
    sum += btree.val;
    if (btree.left == null && btree.right == null) {
      if (sum == target) {
        return true;
      }
    }
    
    if (binaryTreeInorder(btree.left, target) == true){
      return true;
    }
    if (binaryTreeInorder(btree.right, target) == true) {
      return true;
    }
    sum -= btree.val;
    return false;
  }
  
  public static void readme()
  {
    String str = "Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.\n\n";

    str += "A leaf is a node with no children.\n";

    System.out.println(str);
  }
}