package tree;

public class SearchInBinarySearchTree
{
  public static TreeNode searchBST(TreeNode root, int val)
  {
    TreeNode current = root;
    while (current != null) {
      if (val > current.val) {
        current = current.right;
      } else if (val < current.val) {
        current = current.left;
      } else {
        return current;
      }
    }

    return current;
  }

  public static void readme()
  {
    String str = "You are given the root of a binary search tree (BST) and an integer val.\n\n";

    str += "Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.\n";
    
    System.out.println(str);
  }

  public static void main()
  {

    SearchInBinarySearchTree.readme();

    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    int val;

    // root = [4,2,7,1,3], val = 2 => [2,1,3]
    //    4
    //  2   7
    // 1 3
    node1 = new TreeNode(1);
    node3 = new TreeNode(3);
    node2 = new TreeNode(2, node1, node3);
    node7 = new TreeNode(7);
    TreeNode tree1 = new TreeNode(4, node2, node7);
    val = 2;
    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("searchBST(tree1, " + val + ") = ");
    TreeNode tree2 = searchBST(tree1,val);
    System.out.println("Tree 2: ");
    tree2.show();
    System.out.println("");

    // root = [4,2,7,1,3], val = 5 => []
    node1 = new TreeNode(1);
    node3 = new TreeNode(3);
    node2 = new TreeNode(2, node1, node3);
    node7 = new TreeNode(7);
    TreeNode tree3 = new TreeNode(4, node2, node7);
    val = 5;
    System.out.println("Tree 3: ");
    tree1.show();
    System.out.println("");

    System.out.println("searchBST(tree3, " + val + ") = ");
    TreeNode tree4 = searchBST(tree3, val);
    System.out.println("Tree 4: ");
    if (tree4 != null) {
      tree4.show();
    }
    System.out.println("");

  }
}