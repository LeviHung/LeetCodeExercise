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

  public static void main()
  {
    BalancedBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => true
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isBalanced(tree1) = " +  
                       BalancedBinaryTree.isBalanced(tree1));


    // root = [1,2,2,3,3,null,null,4,4] => false
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(4);
    node4 = new TreeNode(3, node6, node7);
    node5 = new TreeNode(3);
    node2 = new TreeNode(2, node4,node5);
    node3 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, node2, node3);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("isBalanced(tree2) = " +  
                       BalancedBinaryTree.isBalanced(tree2));


    // [1,null,2,null,3]
    node3 = new TreeNode(3);
    node2 = new TreeNode(2, null, node3);
    TreeNode tree3 = new TreeNode(1, null, node2);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("isBalanced(tree3) = " +  
                       BalancedBinaryTree.isBalanced(tree3));

    // [1,2,3,4,5,6,null,8] => true
    //          1
    //      2       3
    //   4    5   6 
    // 8
    node7 = new TreeNode(8);
    node4 = new TreeNode(4, node7, null);
    node5 = new TreeNode(5);
    node2 = new TreeNode(2, node4, node5);
    node6 = new TreeNode(6);
    node3 = new TreeNode(3, node6, null);
    TreeNode tree4 = new TreeNode(1, node2, node3);
    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("isBalanced(tree4) = " +  
                       BalancedBinaryTree.isBalanced(tree4));

  }
}