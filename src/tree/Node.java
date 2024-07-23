package tree;

import java.util.List;

public class Node 
{
  int val;
  List<Node> children;

  public Node() {}
  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
  
  public void show()
  {
    Node root = this;
    if (root == null) {
      System.out.print("This tree is null.");
      return;
    }
    show_inorder(root);
  }

  static void show_inorder(Node node) {
    if (node == null) 
      return;

    //          1
    //    3     2     4
    //  5  6
    System.out.print(node.val + " ");
    if (node.children != null) {
      for (int i = 0; i < node.children.size(); i++) {
        show_inorder(node.children.get(i));
      }
    }
  }

}