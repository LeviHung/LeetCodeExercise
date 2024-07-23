package tree;

import java.util.List;
import java.util.ArrayList;

public class SubtreeOfAnotherTree
{
  static List<TreeNode> subTree;
  public static boolean isSubtree(TreeNode root, TreeNode subRoot)
  {
    boolean isSame = false;
    subTree = new ArrayList<>();
    
    binaryTreeInorder(root, subRoot.val);
    if (subTree.size() == 0)
      return false;

    for (int i = 0; i < subTree.size(); i++) {
      isSame = sameTreeInorder(subTree.get(i), subRoot);
      if (isSame == true)
        return isSame;
    }
    return isSame;
  }

  public static void binaryTreeInorder(TreeNode btree, int val) 
  {
    if (btree == null) {
      return;
    }
    binaryTreeInorder(btree.left, val);
    if (val == btree.val) {
      subTree.add(btree);
    }
    binaryTreeInorder(btree.right, val);
  }
  
  public static boolean sameTreeInorder(TreeNode p, TreeNode q) 
  {
    if (p != null && q != null) {
      if (sameTreeInorder(p.left, q.left) == false) {
        return false;
      }

      if (p.val != q.val) {
        return false;
      }

      if (sameTreeInorder(p.right, q.right) == false) {
        return false;
      }

      return true;

    } else if (p != null && q == null) {
      return false;

    } else if (p == null && q != null) {
      return false;
    }

    return true;
  }

  public static boolean isSubtreeOpt(TreeNode root, TreeNode subRoot) {
     if (root == null && subRoot == null) {
        return true;
    }
    if (root == null || subRoot == null) {
        return false;
    }

    boolean flag = false;
    if (root.val == subRoot.val) {
        flag = isSameTree(root.left, subRoot.left) && 
               isSubtreeOpt(root.right, subRoot.right);
    }

    return flag || isSubtreeOpt(root.left, subRoot) || isSubtreeOpt(root.right, subRoot);
  }

  private static boolean isSameTree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
        return true;
    }
    if (root == null || subRoot == null) {
        return false;
    }

    if (root.val != subRoot.val) {
        return false;
    }

    return isSameTree(root.left, subRoot.left) && 
           isSameTree(root.right, subRoot.right);
  }

  public static boolean isSubtreeEx(TreeNode root, TreeNode subRoot) {
    if (root == null) {
        return false;
    }
    if (isIdentical(root, subRoot)) {
        return true;
    }
    return isSubtreeEx(root.left, subRoot) || 
           isSubtreeEx(root.right, subRoot);
  }
  
  public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
        return true;
    }
    if (root == null ^ subRoot == null) {
        return false;
    }
    if (root.val == subRoot.val) {
        return isIdentical(root.right, subRoot.right) &&
               isIdentical(root.left, subRoot.left);
    }
    return false;
  }
  
  public static void readme()
  {
    String str = "Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.\n\n";

    str += "A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SubtreeOfAnotherTree.readme();
    TreeNode node0;
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;

    //  root = [3,4,5,1,2], subRoot = [4,1,2] => true
    //      3          4
    //    4   5      1   2
    //   1  2
    node1 = new TreeNode(1);
    node2 = new TreeNode(2);
    node4 = new TreeNode(4, node1, node2);
    node5 = new TreeNode(5);
    
    TreeNode tree1 = new TreeNode(3, node4, node5);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    node1 = new TreeNode(1);
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(4, node1, node2);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    SameTree.isSameTree(tree1, tree2);

    System.out.println("isSubtree(tree1, tree2) = " +  
                        isSubtree(tree1, tree2));


    // root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2] => false
    //         3
    //      4      5
    //   1     2    
    //       0
    node0 = new TreeNode(0);
    node2 = new TreeNode(2, node0, null);
    node1 = new TreeNode(1);
    node4 = new TreeNode(4, node1, node2);
    node5 = new TreeNode(5);
    
    TreeNode tree3 = new TreeNode(3, node4, node5);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    node1 = new TreeNode(1);
    node2 = new TreeNode(2);
    TreeNode tree4 = new TreeNode(4, node1, node2);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("isSubtree(tree3, tree4) = " +  
                        isSubtree(tree3, tree4));

    // root = [1, 1], subRoot = [1] => true
    node1 = new TreeNode(1);
    TreeNode tree5 = new TreeNode(1, node1, null);
    System.out.print("Tree 5: ");
    tree5.show();
    System.out.println("");

    TreeNode tree6 = new TreeNode(1);
    System.out.print("Tree 6: ");
    tree6.show();
    System.out.println("");
    
    System.out.println("isSubtree(tree5, tree6) = " +  
                        isSubtree(tree5, tree6));
    
    System.out.println("isSubtreeEx(tree5, tree6) = " +  
                        isSubtreeEx(tree5, tree6));

    System.out.println("isSubtreeOpt(tree5, tree6) = " +  
                        isSubtreeOpt(tree5, tree6));

  }
}