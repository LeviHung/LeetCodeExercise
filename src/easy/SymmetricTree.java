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

  public static void main()
  {
    SymmetricTree.readme();

    //  root = [1,2,2,3,4,4,3] => true
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(2, node6, node7);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isSymmetric(tree1) = " +  
                       SymmetricTree.isSymmetric(tree1));

    // root = [1,2,2,null,3,null,3] => false
    node4 = new TreeNode(3);
    node5 = new TreeNode(3);
    node2 = new TreeNode(2, null, node4);
    node3 = new TreeNode(2, null, node5);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    tree2.show();
    System.out.println("");
    System.out.println("isSymmetric(tree2) = " +  
                       SymmetricTree.isSymmetric(tree2));
  }
}