package tree;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths
{
  public static List<String> binaryTreePaths(TreeNode root)
  {
    //       1
    //    2      3
    //      5  
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();

    binaryTreeInorder(root, list, sb);

    return list;
  }

  // Use final to get better for runtime (6ms => 2ms)
  public static void binaryTreeInorder(final TreeNode btree, 
                                       final List<String> list,
                                       final StringBuilder sb) 
  {
    if (btree != null) {
      int tmp = sb.length();
      if (btree.left == null && btree.right == null) {
        sb.append(btree.val);
        list.add(sb.toString());
      }

      //StringBuilder sbParent = new StringBuilder(sb);
      sb.append(btree.val);
      sb.append("->");

      if (btree.left != null) {
        binaryTreeInorder(btree.left, list, sb);
      }
      if (btree.right != null) {
        binaryTreeInorder(btree.right, list, sb);
      }
      sb.setLength(tmp);
    }
  }

  public static List<String> binaryTreePathsOpt(final TreeNode root) 
  {
    final List<String> result = new ArrayList<>();

    helper(result, new StringBuilder(), root);

    return result;
  }

  private static void helper(final List<String> result, 
                             final StringBuilder sb, 
                             final TreeNode root) 
  {
    final int tmp = sb.length();

    if (root.left == null && root.right == null) {
        sb.append(root.val);
        result.add(sb.toString());
    } else {
        sb.append(root.val);
        sb.append("->");

        if (root.right != null)
            helper(result, sb, root.right);

        if (root.left != null)
            helper(result, sb, root.left);
    }

    sb.setLength(sb.length() - (sb.length() - tmp));
  }

  public static void readme()
  {
    String str = "Given the root of a binary tree, return all root-to-leaf paths in any order.\n\n";

    str += "A leaf is a node with no children.\n";

    System.out.println(str);
  }

  public static void main()
  {

    BinaryTreePaths.readme();

    //  root = [1,2,3,null,5] => ["1->2->5","1->3"]
    //       1
    //    2      3
    //      5  
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;

    node4 = new TreeNode(5);
    node2 = new TreeNode(2, null, node4);
    node3 = new TreeNode(3, null, null);

    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.println("Tree 1: ");
    tree1.show();
    System.out.println("");
    System.out.println("binaryTreePaths(tree1) = ");

    List <String> list = BinaryTreePaths.binaryTreePaths(tree1);

    for(int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println("binaryTreePathsOpt(tree1) = ");
    List <String> list2 = BinaryTreePaths.binaryTreePathsOpt(tree1);

    for(int i = 0; i < list2.size(); i++) {
      System.out.println(list2.get(i));
    }

  }
}