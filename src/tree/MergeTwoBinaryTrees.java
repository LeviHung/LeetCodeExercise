package tree;

import java.util.List;
import java.util.ArrayList;

public class MergeTwoBinaryTrees
{
  public static TreeNode mergeTrees(TreeNode root1, TreeNode root2)
  {
    //      1            2
    //    3   2      1      3
    //   5             4      7

    if (root1 == null && root2 == null) {
      return null;
    }

    if (root1 == null) {
      return root2;
    }

    if (root2 == null) {
      return root1;
    }

    TreeNode btree;
    btree = new TreeNode(root1.val + root2.val);
    btree.left  = mergeTrees(root1.left, root2.left);
    btree.right = mergeTrees(root1.right, root2.right);

    return btree;
  }
  
  public static void readme()
  {
    String str = "You are given two binary trees root1 and root2.\n\n";

    str += "Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.\n\n";

    str += "Return the merged tree.\n\n";

    str += "Note: The merging process must start from the root nodes of both trees.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    MergeTwoBinaryTrees.readme();
    TreeNode node0;
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node7;
    
    // root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7] 
    // => [3,4,5,5,4,null,7]
    //      1            2
    //    3   2      1      3
    //   5             4      7
    node5 = new TreeNode(5);
    node3 = new TreeNode(3, node5, null);
    node2 = new TreeNode(2);
    TreeNode tree1 = new TreeNode(1, node3, node2);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    node4 = new TreeNode(4);
    node1 = new TreeNode(1, null, node4);
    node7 = new TreeNode(7);
    node3 = new TreeNode(3, null, node7);
    TreeNode tree2 = new TreeNode(2, node1, node3);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    TreeNode tree3 = mergeTrees(tree1, tree2);
    System.out.println("mergeTrees(tree1, tree2) = ");  
    tree3.show();
    System.out.println("");


    // root1 = [1], root2 = [1,2] => [2,2]
    TreeNode tree4 = new TreeNode(1);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    node2 = new TreeNode(2);
    TreeNode tree5 = new TreeNode(1, node2, null);

    System.out.print("Tree 5: ");
    tree5.show();
    System.out.println("");
    TreeNode tree6 = mergeTrees(tree4, tree5);
    System.out.println("mergeTrees(tree4, tree5) = ");  
    tree6.show();
    System.out.println("");

  }
}