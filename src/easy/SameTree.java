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

  public static void main()
  {
    SameTree.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    TreeNode node4 = new TreeNode(2);
    TreeNode node5 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node4, node5);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    SameTree.isSameTree(tree1, tree2);

    System.out.println("isSameTree(tree1, tree2) = " +  
                     SameTree.isSameTree(tree1, tree2));


    TreeNode node6 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node6, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    TreeNode node7 = new TreeNode(2);
    TreeNode tree4 = new TreeNode(1, null, node7);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    SameTree.isSameTree(tree3, tree4);

    System.out.println("isSameTree(tree3, tree4) = " +  
                     SameTree.isSameTree(tree3, tree4));
  }
}