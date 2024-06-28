package easy;

public class SymmetricTree
{
  public static boolean isSymmetric(TreeNode root)
  {
    boolean isSym = true;
    isSym = symmetricTreeInorder(root.left, root.right);
    return isSym;
  }

  public static boolean symmetricTreeInorder(TreeNode p, TreeNode q) 
  {
    if (p != null && q != null) {
      if (symmetricTreeInorder(p.left, q.right) == false) {
        return false;
      }

      if (p.val != q.val) {
        return false;
      }

      if (symmetricTreeInorder(p.right, q.left) == false) {
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

  public static void readme()
  {
    String str = "Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).\n";

    System.out.println(str);
  }
}