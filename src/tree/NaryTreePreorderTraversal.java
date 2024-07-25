package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NaryTreePreorderTraversal
{
  public static List<Integer> preorder(Node root)
  {
    List <Integer> list = new ArrayList<>();
    
    naryTreePreorder(root, list);

    return list;
  }

  public static void naryTreePreorder(Node ntree, List<Integer> list) 
  {
    if (ntree == null) {
      return;
    }

    list.add(ntree.val);
    if (ntree.children != null) {
      for (int i = 0; i < ntree.children.size(); i++) {
        naryTreePreorder(ntree.children.get(i), list);
      }
    }
  }

  public static void readme()
  {
    String str = "Given the root of an n-ary tree, return the preorder traversal of its nodes' values.\n\n";

    str += "Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples).\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximumDepthNaryTree.readme();

    Node node2;
    Node node3;
    Node node4;
    Node node5;
    Node node6;
    Node node7;
    Node node8;
    Node node9;
    Node node10;
    Node node11;
    Node node12;
    Node node13;
    Node node14;

    List <Node> list1;
    List <Node> list2;
    List <Node> list3;
    List <Node> list4;
    List <Node> list5;
    List <Node> list7;
    List <Node> list8;
    List <Node> list9;
    List <Node> list11;
    // root = [1,null,3,2,4,null,5,6] => [1,3,5,6,2,4]
    //          1
    //    3     2     4
    //  5  6
    node5 = new Node(5);
    node6 = new Node(6);
    list1 = new ArrayList<>();
    list1.add(node5);
    list1.add(node6);

    node3 = new Node(3, list1);
    node2 = new Node(2, null);
    node4 = new Node(4, null);

    list2 = new ArrayList<>();
    list2.add(node3);
    list2.add(node2);
    list2.add(node4);

    Node tree1 = new Node(1, list2);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("preorder(tree1) = ");  
    List<Integer> res1 = preorder(tree1);
    System.out.println(Arrays.toString(res1.toArray()));


    // root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14] => [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
    //             1
    //   2      3         4        5
    //         6  7       8     9    10
    //            11     12     13  
    //            14
    list1 = new ArrayList<>();
    list3 = new ArrayList<>();
    list4 = new ArrayList<>();
    list5 = new ArrayList<>();
    list7 = new ArrayList<>();
    list8 = new ArrayList<>();
    list9 = new ArrayList<>();
    list11 = new ArrayList<>();


    node13 = new Node(13);
    list9.add(node13);
    node9 = new Node(9, list9);
    node10 = new Node(10);
    list5.add(node9);
    list5.add(node10);
    node5 = new Node(5, list5);

    node12 = new Node(12);
    list8.add(node12);
    node8 = new Node(8, list8);
    list4.add(node8);
    node4 = new Node(4, list4);


    node14 = new Node(14);
    list11.add(node14);

    node11 = new Node(11, list11);
    list7.add(node11);
    node7 = new Node(7, list7);
    node6 = new Node(6);

    list3.add(node6);
    list3.add(node7);

    node2 = new Node(2);
    node3 = new Node(3, list3);
    node4 = new Node(4, list4);
    node5 = new Node(5, list5);

    list1.add(node2);
    list1.add(node3);
    list1.add(node4);
    list1.add(node5);
    Node tree2 = new Node(1, list1);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("preorder(tree2 = ");  
    List<Integer> res2 = preorder(tree2);
    System.out.println(Arrays.toString(res2.toArray()));
  }
}