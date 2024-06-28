package easy;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversal
{
  public static List<Integer> inorderTraversal(TreeNode root)
  {
    List<Integer> list = new ArrayList<>();

    binaryTreeInorder(root, list);
    
    return list;
  }

  public static void binaryTreeInorder(TreeNode btree, List<Integer> list) 
  {
    if (btree != null) {
      binaryTreeInorder(btree.left, list);
      list.add(btree.val);
      binaryTreeInorder(btree.right, list);
    }
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return the inorder traversal of its nodes' values.\n";

    System.out.println(str);
  }
}