package tree;

public class UnivaluedBinaryTree
{
  static int uniValue = -1;
  public static boolean isUnivalTree(TreeNode root)
  {
    if (root == null) {
      return true;
    }
    if (root.val != uniValue) {
      if (uniValue == -1) {
        uniValue = root.val;
      } else {
        return false;
      }
    }

    boolean isUni;
    isUni = isUnivalTree(root.left);
    if (isUni == false) {
      return false;
    }

    isUni = isUnivalTree(root.right);
    if (isUni == false) {
      return false;
    }
    return true;
  }

  public static void readme()
  {
    String str = "A binary tree is uni-valued if every node in the tree has the same value.\n\n";

    str += "Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.\n";

    System.out.println(str);
  }

  public static void main()
  {
    UnivaluedBinaryTree.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;

    // root = [1,1,1,1,1,null,1] => true
    //    1
    //  1    1
    // 1  1    1
    node6 = new TreeNode(1);
    node4 = new TreeNode(1);
    node5 = new TreeNode(1);
    node2 = new TreeNode(1, node4, node5);
    node3 = new TreeNode(1, null, node6);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isUnivalTree(tree1) = " +  
                       isUnivalTree(tree1));


    // root = [2,2,2,5,2] => false
    //    2 
    //  2   2
    // 5 2

    node4 = new TreeNode(5);
    node5 = new TreeNode(2);
    node2 = new TreeNode(2, node4, node5);
    node3 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(2, node2, node3);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("isUnivalTree(tree2) = " +  
                       isUnivalTree(tree2));

  }
}