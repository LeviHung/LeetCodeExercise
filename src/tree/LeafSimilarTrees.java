package tree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LeafSimilarTrees
{
  public static boolean leafSimilar(TreeNode root1, TreeNode root2)
  {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    boolean res = false;
    
    binaryTreePreorder(root1, list1);
    
    binaryTreePreorder(root2, list2);
  
    return list1.equals(list2);
  }

  public static void binaryTreePreorder(TreeNode btree, List<Integer> list) 
  {
    if (btree == null) {
      return;
    }

    if (btree.left == null && btree.right == null) {
      list.add(btree.val);
    }
    binaryTreePreorder(btree.left, list);

    binaryTreePreorder(btree.right, list);

  }

  public static void readme()
  {
    String str = "Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.\n\n";

    str += "For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).\n\n";

    str += "Two binary trees are considered leaf-similar if their leaf value sequence is the same.\n\n";

    str += "Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LeafSimilarTrees.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;

    // root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
    // => true
    //        3
    //   5       1
    // 6   2    9  8
    //   7  4

    //        3
    //   5       1 
    // 6   7    4   2
    //            9  8

    node7 = new TreeNode(7);
    node4 = new TreeNode(4);
    node2 = new TreeNode(2, node7, node4);
    node6 = new TreeNode(6);
    node5 = new TreeNode(5, node6, node2);
    node9 = new TreeNode(9);
    node8 = new TreeNode(8);
    node1 = new TreeNode(1, node9, node8);
    
    TreeNode tree1 = new TreeNode(3, node5, node1);
    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    node6 = new TreeNode(6);
    node7 = new TreeNode(7);
    node5 = new TreeNode(5, node6, node7);
    node9 = new TreeNode(9);
    node8 = new TreeNode(8);
    node2 = new TreeNode(2, node9, node8);
    node4 = new TreeNode(4);
    node1 = new TreeNode(1, node4, node2);

    TreeNode tree2 = new TreeNode(3, node5, node1);
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("leafSimilar(tree2) = " +  
                       leafSimilar(tree1, tree2));


    // root1 = [1,2,3], root2 = [1,3,2] => false
    //    1
    // 2     3
    //    1
    // 3     2
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree3 = new TreeNode(1, node2, node3);
    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    node2 = new TreeNode(2);
    node3 = new TreeNode(3);

    TreeNode tree4 = new TreeNode(1, node3, node2);
    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("leafSimilar(tree4) = " +  
                       leafSimilar(tree3, tree4));

    
  }
}