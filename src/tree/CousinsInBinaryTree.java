package tree;

public class CousinsInBinaryTree
{
  public static boolean isCousins(TreeNode root, int x, int y)
  {
    int[] resX = getDepthParent(root, x, 0, -1);
    int[] resY = getDepthParent(root, y, 0, -1);
    if (resX[0] == resY[0] && resX[1] != resY[1]) {
      return true;
    } else {
      return false;
    }
  }

  public static int[] getDepthParent(TreeNode btree, int val, 
                                     int depth, int parent) 
  {
    if (btree == null) {
      return new int [] {-1,-1};
    }
    if (btree.val == val) {
      return new int [] {depth, parent};
    }
    int[] res = getDepthParent(btree.left, val, depth + 1, btree.val);
    if (res[1] > 0) {
      return res;
    }
    res = getDepthParent(btree.right, val, depth + 1, btree.val);
    if (res[1] > 0) {
      return res;
    }
    return new int [] {-1,-1};
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.\n";

    str += "Two nodes of a binary tree are cousins if they have the same depth with different parents.\n\n";

    str += "Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    CousinsInBinaryTree.readme();
    
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    int x;
    int y;
    
    // root = [1,2,3,4], x = 4, y = 3 => false
    //            1
    //      2            3
    //  4

    node4 = new TreeNode(4);
    node2 = new TreeNode(2, node4, null);
    node3 = new TreeNode(3);
    TreeNode tree1 = new TreeNode(1, node2, node3);
    x = 4;
    y = 3;

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isCousins(tree1, " + x + ", " + y + ") = " +  
                       isCousins(tree1, x, y));

    // root = [1,2,3,null,4,null,5], x = 5, y = 4 => true
    //            1
    //      2            3
    //         4             5

    node4 = new TreeNode(4);
    node2 = new TreeNode(2, null, node4);
    node5 = new TreeNode(5);
    node3 = new TreeNode(3, null, node5);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    x = 5;
    y = 4;

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("isCousins(tree2, " + x + ", " + y + ") = " +  
                       isCousins(tree2, x, y));


  }
}