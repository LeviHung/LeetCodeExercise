package tree;

import java.util.HashSet;

public class TwoSumIV
{
  private static HashSet<Integer> set;
  public static boolean findTarget(TreeNode root, int k)
  {
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1
    set = new HashSet<>();

    return binaryTreeInorder(root, k);
  }

  public static boolean binaryTreeInorder(TreeNode btree, int target) 
  {
    if (btree == null) {
      return false;
    }
    if (set.contains(btree.val) == true) {
      return true;
    }

    set.add(target - btree.val);

    if (binaryTreeInorder(btree.left, target) == true){
      return true;
    }
    if (binaryTreeInorder(btree.right, target) == true) {
      return true;
    }

    return false;
  }

  public static boolean findTargetOpt(TreeNode root, int k) {

     return findTarget(root, k, root);

  }

  public static boolean findTarget(TreeNode root, int k, TreeNode node)
  {
      if(root == null)
      {
          return false;
      }        

      boolean isFound = false;
      boolean left = findTarget(root.left, k, node);
      int subNum = k - root.val;
      if(subNum > root.val)
      {
          isFound = find(node, subNum);
          if(isFound)
          {
              return true;
          }
      }
      boolean right = findTarget(root.right, k, node);

      return left || right || isFound;
  }

  public static boolean find(TreeNode root, int num)
  {
      if(root == null)
      {
          return false;
      }

      if(root.val == num)
      {
          return true;
      }
      else if(root.val > num)
      {
          return find(root.left, num);
      }
      return find(root.right, num);
  }
  
  public static void readme()
  {
    String str = "Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.\n";

    System.out.println(str);
  }

  public static void main()
  {
    TwoSumIV.readme();
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    int k;
    // root = [5,3,6,2,4,null,7], k = 9 => true
    //            5
    //      3            6
    //  2      4             7


    node2 = new TreeNode(2);
    node4 = new TreeNode(4);
    node3 = new TreeNode(3, node2, node4);
    node7 = new TreeNode(7);
    node6 = new TreeNode(6, null, node7);
    TreeNode tree1 = new TreeNode(5, node3, node6);
    k = 9;

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("findTarget(tree1, " + k + ") = " +  
                       findTarget(tree1, k));

    // root = [5,3,6,2,4,null,7], k = 28 => false
    node2 = new TreeNode(2);
    node4 = new TreeNode(4);
    node3 = new TreeNode(3, node2, node4);
    node7 = new TreeNode(7);
    node6 = new TreeNode(6, null, node7);
    TreeNode tree2 = new TreeNode(5, node3, node6);
    k = 28;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("findTarget(tree2, " + k + ") = " +  
                       findTarget(tree2, k));

    System.out.println("findTargetOpt(tree2, " + k + ") = " +  
                       findTargetOpt(tree2, k));

  }
}