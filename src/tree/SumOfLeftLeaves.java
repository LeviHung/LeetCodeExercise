package tree;

public class SumOfLeftLeaves
{
  public static int sumOfLeftLeaves(TreeNode root)
  {
    //      3
    //   9     20
    //       15  17
    return binaryTreeInorder(root, false);
  }

  public static int binaryTreeInorder(TreeNode btree, boolean isLeft) 
  {
    if (btree == null) {
      return 0;
    }

    if (btree.left == null && btree.right == null) {
      if (isLeft == true) {
        return btree.val;
      }
    }
    int sum = 0;
    
    sum += binaryTreeInorder(btree.left, true);

    sum += binaryTreeInorder(btree.right, false);

    return sum;
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return the sum of all left leaves.\n\n";

    str += "A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SumOfLeftLeaves.readme();

    // root = [3,9,20,null,null,15,7] => 24
    //      3
    //   9     20
    //       15  17
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;
    
    node4 = new TreeNode(15);
    node5 = new TreeNode(17);
    node3 = new TreeNode(20, node4, node5);
    node2 = new TreeNode(9);
    TreeNode tree = new TreeNode(3, node2, node3);
    System.out.print("Tree: ");
    tree.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree) = " +  
                       sumOfLeftLeaves(tree));

    
    // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1

    node7 = new TreeNode(7);
    node8 = new TreeNode(2);
    node4 = new TreeNode(11, node7, node8);
    node2 = new TreeNode(4, node4, null);
    node9 = new TreeNode(1);
    node6 = new TreeNode(4, null, node9);
    node5 = new TreeNode(13);
    node3 = new TreeNode(8, node5, node6);
    TreeNode tree1 = new TreeNode(5, node2, node3);
    int targetSum = 22;

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree1) = " +  
                       sumOfLeftLeaves(tree1));

    // root = [1,2,3]
    //    1
    //  2   3
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    targetSum = 5;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree2) = " +  
                       sumOfLeftLeaves(tree2));

    // Input: root = [1]
    TreeNode tree3 = new TreeNode(1);
    targetSum = 0;
    System.out.print("Tree 3: ");
    //tree3.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree3) = " +  
                       sumOfLeftLeaves(tree3));
    
  }
}