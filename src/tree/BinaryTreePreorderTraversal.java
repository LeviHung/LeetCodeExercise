package tree;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePreorderTraversal
{
  public static List<Integer> preorderTraversal(TreeNode root)
  {
    List<Integer> list = new ArrayList<>();

    binaryTreePreorder(root, list);

    return list;
  }

  public static void binaryTreePreorder(TreeNode btree, List<Integer> list) 
  {
    if (btree != null) {
      list.add(btree.val);
      binaryTreePreorder(btree.left, list);
      binaryTreePreorder(btree.right, list);
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return the preorder traversal of its nodes' values.\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinaryTreePreorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreePreorderTraversal.preorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreePreorderTraversal.preorderTraversal(tree2);
    System.out.println(list2);

    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreePreorderTraversal.preorderTraversal(tree3);
    System.out.println(list3);

  }
}