package tree;

public class MinimumAbsoluteDifferenceBST
{
  private static int min;
  private static int last;
  public static int getMinimumDifference(TreeNode root) 
  {
    //      4
    //   2     6
    // 1   3
    min = Integer.MAX_VALUE;
    last = -1;
    binaryTreeInorder(root);

    return min;
  }

  public static void binaryTreeInorder(TreeNode btree) 
  {
    if (btree != null) {
      binaryTreeInorder(btree.left);
      if (last != -1) {
        if (btree.val - last < min) {
          min = btree.val - last;
        } 
      }
      last = btree.val;
      binaryTreeInorder(btree.right);

    }
  }

  public static void readme()
  {
    String str = "Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumAbsoluteDifferenceBST.readme();
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;

    //  root = [4,2,6,1,3] => 1
    //      4
    //   2     6
    // 1   3
    node4 = new TreeNode(1);
    node5 = new TreeNode(3);
    node2 = new TreeNode(2, node4, node5);
    node3 = new TreeNode(6);
    
    TreeNode tree1 = new TreeNode(4, node2, node3);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");
    System.out.println("getMinimumDifference(tree1) = " + 
                       getMinimumDifference(tree1));

    //  root = [1,0,48,null,null,12,49] => 1
    //      1
    //  0       48
    //       12    49
    node4 = new TreeNode(12);
    node5 = new TreeNode(49);
    node3 = new TreeNode(48, node4, node5);
    node2 = new TreeNode(0);

    TreeNode tree2 = new TreeNode(1, node2, node3);

    System.out.println("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("getMinimumDifference(tree2) = " + 
                     getMinimumDifference(tree2));

    // root = [236,104,701,null,227,null,911] = 9
    //           236
    //    104          701
    //       227             911

    node4 = new TreeNode(227);
    node2 = new TreeNode(104, null, node4);
    node5 = new TreeNode(911);
    node3 = new TreeNode(701, null, node5);

    TreeNode tree3 = new TreeNode(236, node2, node3);

    System.out.println("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("getMinimumDifference(tree3) = " + 
                        getMinimumDifference(tree3));

  }
}