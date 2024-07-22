package tree;

public class DiameterOfBinaryTree
{
  private static int maxDiameter;
  public static int diameterOfBinaryTree(TreeNode root)
  {
    //       1
    //    2      3
    // 4    5  
    int num = 0;
    maxDiameter = 0;
    num = binaryTreeInorder(root);

    return maxDiameter;
  }

  // Use final to get better for runtime (6ms => 2ms)
  public static int binaryTreeInorder(final TreeNode btree) 
  {
    if (btree == null) {
      return 0;
    }
    int numL = 0;
    int numR = 0;

    if (btree.left != null) {
      numL++;
      numL += binaryTreeInorder(btree.left);
      //System.out.println(btree.val + ": left numL = " + numL);
    }
    if (btree.right != null) {
      numR++;
      numR += binaryTreeInorder(btree.right);
      //System.out.println(btree.val + ": right numR = " + numR);
    }
    if (numL + numR > maxDiameter) {
      maxDiameter = numL + numR;
    }
    if (numL > numR) {
      return numL;
    } else {
      return numR;
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return the length of the diameter of the tree.\n\n";

    str += "The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.\n\n";

    str += "The length of a path between two nodes is represented by the number of edges between them.\n";

    System.out.println(str);
  }

  public static void main()
  {

    DiameterOfBinaryTree.readme();

    //  root = [1,2,3,4,5] => 3
    //       1
    //    2      3
    //  4    5  
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;

    node4 = new TreeNode(4);
    node5 = new TreeNode(5);
    node2 = new TreeNode(2, node4, node5);
    node6 = new TreeNode(6);
    //node3 = new TreeNode(3, node6, null);
    node3 = new TreeNode(3);
    
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");
    System.out.println("diameterOfBinaryTree(tree1) = " + 
                       diameterOfBinaryTree(tree1));

    // root = [1,2] => 1
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, node2, null);
    System.out.println("Tree 2: ");
    tree2.show();
    System.out.println("");
    System.out.println("diameterOfBinaryTree(tree2) = " + 
                       diameterOfBinaryTree(tree2));

  }
}