package tree;
import java.util.List;
import java.util.ArrayList;

public class IncreasingOrderSearchTree
{
  public static TreeNode increasingBST(TreeNode root)
  {
    List <Integer> list = new ArrayList<>();

    BSTinorder(root, list);

    TreeNode newTree = new TreeNode(list.get(0));
    TreeNode current = newTree;
    for (int i = 1; i < list.size(); i++) {
      TreeNode node = new TreeNode(list.get(i));
      current.right = node;
      current = node;
    }

    return newTree;
  }

  public static void BSTinorder(TreeNode btree, List<Integer> list) 
  {
    if (btree == null) {
      return;
    }
    BSTinorder(btree.left, list);

    list.add(btree.val);

    BSTinorder(btree.right, list);

  }

  public static void readme()
  {
    String str = "Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.\n\n";

    System.out.println(str);
  }

  public static void main()
  {

    IncreasingOrderSearchTree.readme();

    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node9;
    // root = [5,3,6,2,4,null,8,1,null,null,null,7,9] =>
    // [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
    // root = [2,1,3]
    //      5
    //   3    6
    // 2  4     8
    //1       7   9
    node1 = new TreeNode(1);
    node2 = new TreeNode(2, node1, null);
    node4 = new TreeNode(4);
    node3 = new TreeNode(3, node2, node4);
    node7 = new TreeNode(7);
    node9 = new TreeNode(9);
    node8 = new TreeNode(8, node7, node9);
    node6 = new TreeNode(6, null, node8);
    
    TreeNode tree1 = new TreeNode(5, node3, node6);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("increasingBST(tree1) = ");
    TreeNode tree2 = increasingBST(tree1);
    System.out.println("Tree 2: ");
    tree2.show();
    System.out.println("");

    // root = [5,1,7] => [1,null,5,null,7]
    //   5
    // 1   7
    node1 = new TreeNode(1);
    node7 = new TreeNode(7);


    TreeNode tree3 = new TreeNode(5, node1, node7);

    System.out.println("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("increasingBST(tree3) = ");
    TreeNode tree4 = increasingBST(tree3);
    System.out.println("Tree 4: ");
    tree4.show();
    System.out.println("");
  }
}