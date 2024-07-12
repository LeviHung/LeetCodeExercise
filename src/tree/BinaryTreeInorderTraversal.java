package tree;
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

  public static void main()
  {
    BinaryTreeInorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreeInorderTraversal.inorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreeInorderTraversal.inorderTraversal(tree2);
    System.out.println(list2);

    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreeInorderTraversal.inorderTraversal(tree3);
    System.out.println(list3);
  }
}