package easy;

public class SameTree
{
  public static boolean isSameTree(TreeNode p, TreeNode q)
  {
    boolean isSame = true;
    isSame = sameTreeInorder(p, q);
    return isSame;
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

  public static void readme()
  {
    String str = "Given the roots of two binary trees p and q, write a function to check if they are the same or not.\n\n";

    str += "Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.";

    System.out.println(str);
  }
}