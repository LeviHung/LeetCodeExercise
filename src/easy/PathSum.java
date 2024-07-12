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

  public static void main()
  {
    PathSum.readme();

    // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1

    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(2);
    TreeNode node4 = new TreeNode(11, node7, node8);
    TreeNode node2 = new TreeNode(4, node4, null);
    TreeNode node9 = new TreeNode(1);
    TreeNode node6 = new TreeNode(4, null, node9);
    TreeNode node5 = new TreeNode(13);
    TreeNode node3 = new TreeNode(8, node5, node6);
    TreeNode tree1 = new TreeNode(5, node2, node3);
    int targetSum = 22;

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("minDepth(tree1, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree1, targetSum));

    // root = [1,2,3], targetSum = 5
    //    1
    //  2   3
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    targetSum = 5;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("minDepth(tree2, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree2, targetSum));

    // Input: root = [], targetSum = 0
    TreeNode tree3 = null;
    targetSum = 0;
    System.out.print("Tree 3: ");
    //tree3.show();
    System.out.println("");

    System.out.println("minDepth(tree3, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree3, targetSum));
  }
}