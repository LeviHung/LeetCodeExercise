package tree;

public class SumOfRootToLeafBinaryNumbers
{
  private static int totalSum;
  public static int sumRootToLeaf(TreeNode root) {
    totalSum = 0;
    sumInorder(root, 0);
    return totalSum;
  }

  public static void sumInorder(TreeNode btree, int sum) {
    if (btree == null) {
      return;
    }
    sum = sum + btree.val;
    if (btree.left == null && btree.right == null) {
      totalSum += sum;
    } else {
      sumInorder(btree.left, sum * 2);
      sumInorder(btree.right, sum * 2);
    }
  }

  public static int sumRootToLeafOpt(TreeNode root) {
    return helper(root,0);
  }
  private static int helper(TreeNode node,int sum){
    if(node==null){
        return 0;
    }
    sum=(2*sum)+node.val;
    if(node.left==null && node.right==null){
        return sum;
    }
    return helper(node.left,sum)+helper(node.right,sum);
  }

  public static void readme()
  {
    String str = "You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.\n\n";

    str += "For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.\n\n";
    str += "For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.\n\n";
    str += "The test cases are generated so that the answer fits in a 32-bits integer.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    SumOfRootToLeafBinaryNumbers.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;

    // root = [1,0,1,0,1,0,1] => 22
    //      1 
    //   0     1
    // 0  1   0  1
    node4 = new TreeNode(0);
    node5 = new TreeNode(1);
    node2 = new TreeNode(0, node4, node5);
    node6 = new TreeNode(0);
    node7 = new TreeNode(1);
    node3 = new TreeNode(1, node6, node7);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("sumRootToLeaf(tree1) = " +  
                       sumRootToLeaf(tree1));


    TreeNode tree2 = new TreeNode(1, node2, node3);
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("sumRootToLeafOpt(tree2) = " +  
                       sumRootToLeafOpt(tree2));

    //root = [0] => 0
    TreeNode tree3 = new TreeNode(0);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("sumRootToLeaf(tree3) = " +  
                       sumRootToLeaf(tree3));

  }
}