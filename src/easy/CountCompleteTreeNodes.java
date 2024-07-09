package easy;
import java.util.List;
import java.util.ArrayList;

public class CountCompleteTreeNodes
{
  public static int countNodes(TreeNode root)
  {
    List<Integer> list = new ArrayList<>();

    binaryTreeInorder(root, list);

    return list.size();
  }

  public static void binaryTreeInorder(TreeNode btree, List<Integer> list) 
  {
    if (btree != null) {
      binaryTreeInorder(btree.left, list);
      list.add(btree.val);
      binaryTreeInorder(btree.right, list);
    }
  }

  public static int countNodesOpt(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int leftDepth = getDepth(root.left);
    int rightDepth = getDepth(root.right);

    if (leftDepth == rightDepth) {
        // Left subtree is a perfect binary tree.
        return (1 << leftDepth) + countNodesOpt(root.right);
    } else {
        // Right subtree is a perfect binary tree.
        return (1 << rightDepth) + countNodesOpt(root.left);
    }
  }

  private static int getDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
        node = node.left;
        depth++;
    }
    return depth;
  }
  
  public static void readme()
  {
    String str = "Given the root of a complete binary tree, return the number of the nodes in the tree.\n\n";

    str += "According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.\n\n";

    str += "Design an algorithm that runs in less than O(n) time complexity.\n";
    
    System.out.println(str);
  }

  public static void main()
  {

    BinaryTreeInorderTraversal.readme();

    //  root = [1,2,3,4,5,6] => 6
    //       1
    //    2      3
    // 4    5  6
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    
    node4 = new TreeNode(4);
    node5 = new TreeNode(5);
    node6 = new TreeNode(6);
    node2 = new TreeNode(2, node4, node5);
    node3 = new TreeNode(3, node6, null);
    
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");
    
    System.out.println("countNodes(tree1) = " + CountCompleteTreeNodes.countNodes(tree1));

    System.out.println("countNodesOpt(tree1) = " + CountCompleteTreeNodes.countNodesOpt(tree1));

  }
}