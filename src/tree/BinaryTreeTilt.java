package tree;

public class BinaryTreeTilt
{
  private static int totalDiff;
  public static int findTilt(TreeNode root)
  {
    totalDiff = 0;
    int sum = binaryTreeInorder(root);
    //System.out.println("sum = " + sum);
    return totalDiff;
  }
  //    1             1
  //  2   3   =>   0     0  => 1 + 0 + 0 = 1

  //           4                     6
  //      2        9           2          7 
  //    3    5        7  => 0    0           0  =>  6 + 2 + 7 = 15

  public static int binaryTreeInorder(TreeNode btree) 
  {
    if (btree == null) {
      return 0;
    }
    int left = binaryTreeInorder(btree.left);
    int right = binaryTreeInorder(btree.right);
    
    totalDiff += Math.abs(left - right);
    return btree.val + left + right;
  }


  public static void readme()
  {
    String str = "Given the root of a binary tree, return the sum of every tree node's tilt.\n\n";

    str += "The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    BinaryTreeTilt.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;

    // root = [1,2,3] => 1
    //    1             1
    //  2   3   =>   0     0  => 1 + 0 + 0 = 1
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("findTilt(tree1) = " +  
                       findTilt(tree1));


    // root = [4,2,9,3,5,null,7] => 15
    //           4                     6
    //      2        9           2          7 
    //    3    5        7  => 0    0           0  =>  6 + 2 + 7 = 15

    node3 = new TreeNode(3);
    node5 = new TreeNode(5);
    node2 = new TreeNode(2, node3, node5);

    node7 = new TreeNode(7);
    node9 = new TreeNode(9, null, node7);
    TreeNode tree2 = new TreeNode(4, node2, node9);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("findTilt(tree2) = " +  
                        findTilt(tree2));

  }
}