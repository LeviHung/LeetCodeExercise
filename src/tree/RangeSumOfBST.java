package tree;

public class RangeSumOfBST
{
  private static int sum;
  public static int rangeSumBST(TreeNode root, int low, int high)
  {
    sum = 0;
    BSTinorder(root, low, high);
    return sum;
  }
  
  public static void BSTinorder(TreeNode btree, int low, int high) 
  {
    if (btree == null) {
      return;
    }
    if (btree.val > low) {
      BSTinorder(btree.left, low, high);
    }

    if (btree.val >= low && btree.val <= high) {
      sum += btree.val;
    }

    if (btree.val < high) {
      BSTinorder(btree.right, low, high);
    }
  }

  public static int rangeSumBSTEx(TreeNode root, int low, int high) 
  {
    if (root == null) 
      return 0;

    if (root.val > high) 
      return rangeSumBSTEx(root.left, low, high);
    
    if (root.val < low) 
      return rangeSumBSTEx(root.right, low, high);

    return root.val + 
           rangeSumBSTEx(root.left, low, high)+
           rangeSumBSTEx(root.right, low, high);
  }

  public static void readme()
  {
    String str = "Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].\n";

    System.out.println(str);
  }

  public static void main()
  {
    RangeSumOfBST.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;
    TreeNode node15;
    TreeNode node18;
    int low;
    int high;
    // root = [10,5,15,3,7,null,18], low = 7, high = 15 => 32
    //      10
    //   5    15
    // 3  7      18
    node3 = new TreeNode(3);
    node7 = new TreeNode(7);
    node5 = new TreeNode(5, node3, node7);
    node18 = new TreeNode(18);
    node15 = new TreeNode(15, null, node18);
    
    TreeNode tree1 = new TreeNode(10, node5, node15);
    low = 7;
    high = 15;
    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("rangeSumBST(tree1, " + low + ", " + high + ") = " +  
                       rangeSumBST(tree1, low, high));
    System.out.println("");

    // [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10 => 23
    //      10
    //    5    15
    //  3  7      18
    // 1  6
    node1 = new TreeNode(1);
    node3 = new TreeNode(3, node1, null);
    node6 = new TreeNode(6);
    node7 = new TreeNode(7, node6, null);
    node5 = new TreeNode(5, node3, node7);
    node18 = new TreeNode(18);
    node15 = new TreeNode(15, null, node18);
    TreeNode tree2 = new TreeNode(10, node5, node15);
    low = 6;
    high = 10;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("rangeSumBST(tree2, " + low + ", " + high + ") = " +  
                       rangeSumBST(tree2, low, high));

    System.out.println("rangeSumBSTEx(tree2, " + low + ", " + high + ") = " + 
                       rangeSumBSTEx(tree2, low, high));


  }
}