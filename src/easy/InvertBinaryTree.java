package easy;
import java.util.List;
import java.util.ArrayList;

public class InvertBinaryTree
{
  //    2               2
  //  1   3     =>   3     1
  public static TreeNode invertTree(TreeNode root)
  {
    binaryTreeInvert(root);

    return root;
  }

  public static void binaryTreeInvert(TreeNode btree) 
  {
    if (btree != null) {
      TreeNode tmp = btree.left;
      btree.left = btree.right;
      btree.right = tmp;
            
      binaryTreeInvert(btree.left);

      binaryTreeInvert(btree.right);
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, invert the tree, and return its root.\n\n";

    System.out.println(str);
  }

  public static void main()
  {

    InvertBinaryTree.readme();

    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;


    // root = [2,1,3]
    //    2               2
    //  1   3     =>   3     1
    node2 = new TreeNode(1);
    node3 = new TreeNode(3);
    TreeNode tree3 = new TreeNode(2, node2, node3);

    System.out.println("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("invertTree(tree3) = ");
    TreeNode tree4 = InvertBinaryTree.invertTree(tree3);
    System.out.println("Tree 4: ");
    tree4.show();
    System.out.println("");

    //  root = [4,2,7,1,3,6,9]
    //       4                        4
    //    2      7         =>    7         2
    // 1    3  6   9          9    6     3    1
    node4 = new TreeNode(1);
    node5 = new TreeNode(3);
    node6 = new TreeNode(6);
    node7 = new TreeNode(9);

    node2 = new TreeNode(2, node4, node5);
    node3 = new TreeNode(7, node6, node7);

    TreeNode tree1 = new TreeNode(4, node2, node3);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("invertTree(tree1) = ");
    TreeNode tree2 = InvertBinaryTree.invertTree(tree1);
    System.out.println("Tree 2: ");
    tree2.show();
    System.out.println("");


  }
}