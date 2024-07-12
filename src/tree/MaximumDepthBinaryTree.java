package tree;

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

  public static void main()
  {
    MaximumDepthBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => 3
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("maxDepth(tree1) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree1));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, null, node2);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("maxDepth(tree2) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree2));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node2, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("maxDepth(tree3) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree3));
  }
}