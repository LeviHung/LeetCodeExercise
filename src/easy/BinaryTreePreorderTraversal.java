package easy;
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
}