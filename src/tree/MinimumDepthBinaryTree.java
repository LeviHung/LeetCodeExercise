package tree;

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

  public static void main()
  {
    MinimumDepthBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => 3
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("minDepth(tree1) = " +  
                       MinimumDepthBinaryTree.minDepth(tree1));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, null, node2);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("minDepth(tree2) = " +  
                       MinimumDepthBinaryTree.minDepth(tree2));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node2, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("minDepth(tree3) = " +  
                       MinimumDepthBinaryTree.minDepth(tree3));

    // root = [2,null,3,null,4,null,5,null,6]
    // 2
    //  3
    //   4
    //    5
    //     6
    TreeNode node6 = new TreeNode(6);
    node5 = new TreeNode(5, null, node6);
    node4 = new TreeNode(4, null, node5);
    node3 = new TreeNode(3, null, node4);
    TreeNode tree4 = new TreeNode(2, null, node3);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("minDepth(tree4) = " +  
                       MinimumDepthBinaryTree.minDepth(tree4));

    System.out.println("minDepthOpt(tree4) = " +  
                       MinimumDepthBinaryTree.minDepthOpt(tree4));
  }
}