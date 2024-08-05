package tree;

public class MinimumDistanceBSTNodes
{
  private static int minDiff;
  private static int lastVal;

  public static int minDiffInBST(TreeNode root)
  {
    minDiff = Integer.MAX_VALUE;
    lastVal = -1;
    binaryTreeInorder(root);
    //System.out.println("sum = " + sum);
    return minDiff;
  }
  //     4 
  //   2   6
  // 1  3

  //       1 
  //  0        48 
  //        12     49

  //         90
  //    69   
  // 49   89
  //    52

  public static void binaryTreeInorder(TreeNode btree) 
  {
    if (btree == null) {
      return;
    }

    binaryTreeInorder(btree.left);

    if (lastVal != -1) {
      minDiff = Math.min(btree.val - lastVal, minDiff);
    }
    lastVal = btree.val;
    
    binaryTreeInorder(btree.right);
  }


  public static void readme()
  {
    String str = "Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumDistanceBSTNodes.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node0;
    TreeNode node12;
    TreeNode node48;
    TreeNode node49;

    // root = [4,2,6,1,3] => 1
    //     4 
    //   2   6
    // 1  3
    node1 = new TreeNode(1);
    node3 = new TreeNode(3);
    node2 = new TreeNode(2, node1, node3);
    node6 = new TreeNode(6);
    
    TreeNode tree1 = new TreeNode(4, node2, node6);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("minDiffInBST(tree1) = " +  
                       minDiffInBST(tree1));


    // root = [1,0,48,null,null,12,49] => 1
    //           1 
    //      0        48 
    //            12     49

    node12 = new TreeNode(12);
    node49 = new TreeNode(49);
    node48 = new TreeNode(48, node12, node49);

    node0 = new TreeNode(0);
    TreeNode tree2 = new TreeNode(1, node0, node48);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("minDiffInBST(tree2) = " +  
                       minDiffInBST(tree2));

    // 90,69,null,49,89,null,52 => 1
    //          90
    //     69   
    // 49       89
    //   52
    TreeNode node69;
    TreeNode node89; 
    TreeNode node52;
    node52 = new TreeNode(52);
    node49 = new TreeNode(49, null, node52);
    node89 = new TreeNode(89);
    node69 = new TreeNode(69, node49, node89);

    TreeNode tree3 = new TreeNode(90, node69, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("minDiffInBST(tree3) = " +  
                       minDiffInBST(tree3));
  }
}