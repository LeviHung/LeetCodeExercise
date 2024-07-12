package tree;
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

  public static void main()
  {
    BinaryTreePostorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreePostorderTraversal.postorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreePostorderTraversal.postorderTraversal(tree2);
    System.out.println(list2);

    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreePostorderTraversal.postorderTraversal(tree3);
    System.out.println(list3);
  }
}