package tree;

public class SecondMinimumNodeBinaryTree
{
  static long firstMinimum;
  static long secondMinimum;
  
  public static int findSecondMinimumValue(TreeNode root)
  {
    firstMinimum = Long.MAX_VALUE;
    secondMinimum = Long.MAX_VALUE;

    binaryTreeInorder(root);
    //System.out.println("sum = " + sum);
    if (secondMinimum == Long.MAX_VALUE) {
      return -1;
    } else {
      return (int)secondMinimum;
    }
  }

  public static void binaryTreeInorder(TreeNode btree) 
  {
    if (btree == null) {
      return;
    }
    binaryTreeInorder(btree.left);
    
    if (btree.val < firstMinimum) {
      secondMinimum = firstMinimum;
      firstMinimum = btree.val;
    } else if (btree.val < secondMinimum) {
      if (btree.val != firstMinimum) {
        secondMinimum = btree.val;
      }
    }
    
    binaryTreeInorder(btree.right);
    return;
  }


  public static void readme()
  {
    String str = "Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.\n\n";

    str += "Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.\n";

    str += "If no such second minimum value exists, output -1 instead.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SecondMinimumNodeBinaryTree.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;

    // root = [2,2,5,null,null,5,7] => 5
    //    2
    //  2    5
    //     5   7
    node2 = new TreeNode(2);
    node4 = new TreeNode(5);
    node5 = new TreeNode(7);
    node3 = new TreeNode(5, node4, node5);
    TreeNode tree1 = new TreeNode(2, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("findSecondMinimumValue(tree1) = " +  
                       findSecondMinimumValue(tree1));


    // root = [2,2,2] => -1
    //   2 
    // 2   2
    
    node2 = new TreeNode(2147483647);
    node3 = new TreeNode(2147483647);
    TreeNode tree2 = new TreeNode(2147483647, node2, node3);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("findSecondMinimumValue(tree2) = " +  
                        findSecondMinimumValue(tree2));

  }
}