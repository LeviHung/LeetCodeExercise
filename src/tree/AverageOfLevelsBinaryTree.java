package tree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AverageOfLevelsBinaryTree
{
  private static int depth;

  public static List<Double> averageOfLevels(TreeNode root)
  {
    //    3
    // 9     20
    //    15     7
    List<List<Double>> list = new ArrayList<>();
    
    depth = 0;

    binaryTreeInorder(root, list);

    List<Double> res = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      double sum = 0;
      double size = list.get(i).size();
      for (int j = 0; j < size; j++) {
        sum += list.get(i).get(j);
      }
      res.add(sum / size);
      /*
      BigDecimal pi = new BigDecimal(sum / size);
      BigDecimal rounded = pi.setScale(5, RoundingMode.CEILING);
      res.add(rounded.doubleValue());
      */
    }
    //System.out.println(Arrays.toString(res.toArray()));
    return res;

  }

  public static void binaryTreeInorder(TreeNode btree, List<List<Double>> list) 
  {
    if (btree == null) {
      return;
    }
    if (list.size() <= depth) {
      List<Double> listSum = new ArrayList<>();
      listSum.add((double) btree.val);
      list.add(listSum);      
    } else { 
      list.get(depth).add((double) btree.val);
    }
    
    depth++;
    binaryTreeInorder(btree.left, list);

    binaryTreeInorder(btree.right, list);
    depth--;
  }

  public static List<Double> averageOfLevelsOpt(TreeNode root) 
  {
    List<Double> levelAvg = new ArrayList<>();
    if(root == null){
        return levelAvg;
    }
    avgLevel(root, levelAvg);
    return levelAvg;

  }
  public static void avgLevel(TreeNode root,List<Double> levelAvg)
  {
   if(root == null){
    return;
   }
   Queue<TreeNode> q = new LinkedList<>();
   q.add(root);
   while(!q.isEmpty()){
    int level = q.size();
    double avg = 0;

    for(int i = 0; i<level;i++){
        TreeNode currNode = q.remove();
        avg += currNode.val;
        if(currNode.left != null){
            q.add(currNode.left);
        }
        if(currNode.right != null){
            q.add(currNode.right);
        }

    }
    levelAvg.add(avg/level);
   }
  }
  public static void readme()
  {
    String str = "Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AverageOfLevelsBinaryTree.readme();
    TreeNode node7;
    TreeNode node9;
    TreeNode node15;
    TreeNode node20;
    TreeNode node1;
    TreeNode node2;
    // root = [3,9,20,null,null,15,7] => [3.00000,14.50000,11.00000]
    //    3
    // 9     20
    //    15   7
    node9 = new TreeNode(9);
    node15 = new TreeNode(15);
    node7 = new TreeNode(7);
    node20 = new TreeNode(20, node15, node7);
    TreeNode tree1 = new TreeNode(3, node9, node20);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("averageOfLevels(tree1) = ");
    List <Double> list1 = averageOfLevels(tree1);
    System.out.println(Arrays.toString(list1.toArray()));


    // root = [3,9,20,15,7] => [3.00000,14.50000,11.00000]
    //     3
    //  9     20
    //15   7
    node15 = new TreeNode(15);
    node7 = new TreeNode(7);
    node9 = new TreeNode(9, node15, node7);
    node20 = new TreeNode(20);
    TreeNode tree2 = new TreeNode(3, node9, node20);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("averageOfLevels(tree1) = ");
    List <Double> list2 = averageOfLevels(tree2);
    System.out.println(Arrays.toString(list2.toArray()));

    System.out.println("averageOfLevelsOpt(tree1) = ");
    List <Double> list3 = averageOfLevelsOpt(tree2);
    System.out.println(Arrays.toString(list3.toArray()));
    
  }
}