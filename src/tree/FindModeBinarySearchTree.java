package tree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindModeBinarySearchTree
{
  public static int[] findMode(TreeNode root)
  {
    List<Integer> list = new ArrayList<>();
    
    binaryTreeInorder(root, list);
    //System.out.println(Arrays.toString(list.toArray()));
    //list = [1, 1, 2, 2, 2, 3, 3, 3, 4]
    int last = list.get(0);
    int num = 1;
    int mode = 1;
    int[] array = new int[list.size()];
    int count = 0;
    array[count++] = last;
    
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) == last) {
        num++;
        if (num > mode) {
          if (array[count] != last) {
            mode = num;
            array[0] = last;
            count = 1;
          }
        } else if (num == mode) {
          if (array[count] != last) {
            mode = num;
            array[count++] = last;
          }
        }
      } else {
        if (num > mode) {
          mode = num;
        }
        last = list.get(i);
        num = 1;
        if (num == mode) {
          array[count++] = last;
        }
      }
    }
    //System.out.println("count = " + count);
    //System.out.println(Arrays.toString(array));

    int[] ans = new int[count];
    for (int i = 0; i < count; i++) {
      ans[i] = array[i];
    }
    return ans;
    //return binaryTreeInorder(root, false);
  }

  public static void binaryTreeInorder(TreeNode btree, List<Integer> list) 
  {
    if (btree == null) {
      return;
    }

    if (btree != null) {
      binaryTreeInorder(btree.left, list);
      list.add(btree.val);
      binaryTreeInorder(btree.right, list);
    }
  }

  private static int currentVal;
  private static int currentCount = 0;
  private static int maxCount = 0;
  private static List<Integer> modes = new ArrayList<>();

  public static int[] findModeOpt(TreeNode root) 
  {
      inOrderTraversal(root);
      int[] result = new int[modes.size()];
      for (int i = 0; i < modes.size(); i++) {
          result[i] = modes.get(i);
      }
      return result;
  }

  private static void inOrderTraversal(TreeNode node) {
      if (node == null) return;

      inOrderTraversal(node.left);

      currentCount = (node.val == currentVal) ? currentCount + 1 : 1;
      if (currentCount == maxCount) {
          modes.add(node.val);
      } else if (currentCount > maxCount) {
          maxCount = currentCount;
          modes.clear();
          modes.add(node.val);
      }
      currentVal = node.val;

      inOrderTraversal(node.right);
  }

  public static void readme()
  {
    String str = "Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.\n\n";

    str += "If the tree has more than one mode, return them in any order.\n\n";
    
    str += "Assume a BST is defined as follows:\n\n";

    str += "The left subtree of a node contains only nodes with keys less than or equal to the node's key.\n\n";

    str += "The right subtree of a node contains only nodes with keys greater than or equal to the node's key.\n\n";

    str += "Both the left and right subtrees must also be binary search trees.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindModeBinarySearchTree.readme();
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;
    // root = [1,null,2,2] => [2]
    //   1
    //      2
    //    2
    node3 = new TreeNode(2);
    node2 = new TreeNode(2, node3, null);
    TreeNode tree1 = new TreeNode(1, null, node2);
    System.out.print("Tree1: ");
    tree1.show();
    System.out.println("");

    System.out.println("findMode(tree1) = " +  
                       Arrays.toString(findMode(tree1)));
    
    // root = [3,9,20,null,null,15,7] => 24
    //      1
    //   1      2
    //       2     3
    //     2  2  3   4
    node6 = new TreeNode(2);
    node7 = new TreeNode(2);
    node4 = new TreeNode(2, node6, node7);
    node8 = new TreeNode(3);
    node9 = new TreeNode(4);
    node5 = new TreeNode(3, node8, node9);
    node3 = new TreeNode(2, node4, node5);
    node2 = new TreeNode(1);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    System.out.print("Tree2: ");
    tree2.show();
    System.out.println("");

    System.out.println("findMode(tree2) = " +  
                        Arrays.toString(findMode(tree2)));

    // root = [0]
    TreeNode tree3 = new TreeNode(0);
    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("findMode(tree3) = " +  
                        Arrays.toString(findMode(tree3)));

    // root = [1,2]
    node2 = new TreeNode(2);
    TreeNode tree4 = new TreeNode(1, null, node2);
    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("findMode(tree4) = " +  
                        Arrays.toString(findMode(tree4)));

    // root = [2,3,4,5,6]
    node6 = new TreeNode(6);
    node5 = new TreeNode(5, null, node6);
    node4 = new TreeNode(4, null, node5);
    node3 = new TreeNode(3, null, node4);

    TreeNode tree5 = new TreeNode(2, null, node3);
    System.out.print("Tree 5: ");
    tree5.show();
    System.out.println("");

    System.out.println("findMode(tree5) = " +  
                        Arrays.toString(findMode(tree5)));

    // [1,0,1,0,0,1,1,0]
    //      1
    //    0   1
    //  0  0 1  1
    // 0

    node8 = new TreeNode(0);
    node4 = new TreeNode(0, node8, null);
    node5 = new TreeNode(0);
    node6 = new TreeNode(1);
    node7 = new TreeNode(1);
    node3 = new TreeNode(1, node6, node7);
    node2 = new TreeNode(0, node4, node5);
    TreeNode tree6 = new TreeNode(1, node2, node3);
    System.out.print("Tree6: ");
    tree6.show();
    System.out.println("");

    System.out.println("findMode(tree6) = " +  
                        Arrays.toString(findMode(tree6)));

    System.out.println("findModeOpt(tree6) = " +  
                        Arrays.toString(findModeOpt(tree6)));

    /*
    // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1

    node7 = new TreeNode(7);
    node8 = new TreeNode(2);
    node4 = new TreeNode(11, node7, node8);
    node2 = new TreeNode(4, node4, null);
    node9 = new TreeNode(1);
    node6 = new TreeNode(4, null, node9);
    node5 = new TreeNode(13);
    node3 = new TreeNode(8, node5, node6);
    TreeNode tree1 = new TreeNode(5, node2, node3);
    int targetSum = 22;

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree1) = " +  
                       sumOfLeftLeaves(tree1));

    // root = [1,2,3]
    //    1
    //  2   3
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    targetSum = 5;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree2) = " +  
                       sumOfLeftLeaves(tree2));

    // Input: root = [1]
    TreeNode tree3 = new TreeNode(1);
    targetSum = 0;
    System.out.print("Tree 3: ");
    //tree3.show();
    System.out.println("");

    System.out.println("sumOfLeftLeaves(tree3) = " +  
                       sumOfLeftLeaves(tree3));
    */
  }
}