package easy;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePostorderTraversal
{
  public static List<Integer> postorderTraversal(TreeNode root)
  {
    List<Integer> list = new ArrayList<>();

    binaryTreePostorder(root, list);

    return list;
  }

  public static void binaryTreePostorder(TreeNode btree, List<Integer> list) 
  {
    if (btree != null) {
      binaryTreePostorder(btree.left, list);
      binaryTreePostorder(btree.right, list);
      list.add(btree.val);
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return the postorder traversal of its nodes' values.\n";

    System.out.println(str);
  }
}