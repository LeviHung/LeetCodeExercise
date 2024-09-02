package recursion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import tree.TreeNode;

public class AllPossibleFullBinaryTrees
{
    static HashMap<Integer, List<TreeNode>> map = new HashMap<>();

    public static List<TreeNode> allPossibleFBT(int n) {
          if (map.containsKey(n)) {
              return map.get(n);
          }
          List <TreeNode> list = new ArrayList<>();
          if (n % 2 == 0) {
              return list;
          }
          if (n == 1) {
              list.add(new TreeNode(0));
              map.put(1, list);
              return list;
          }
    
          for (int i = 1; i < n; i = i + 2) {
              int j = n - i - 1;
              List <TreeNode> left = allPossibleFBT(i);
              List <TreeNode> right = allPossibleFBT(j);
    
              for (TreeNode l: left) {
                  for (TreeNode r: right) {
                      TreeNode root = new TreeNode(0);
                      root.left = l;
                      root.right = r;
                      list.add(root);
                  }
              }
          } 
          map.put(n, list);
          return list;
    }

  public static void readme()
  {
    String str = "Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.\n\n";

    str += "Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.\n\n";

    str += "A full binary tree is a binary tree where each node has exactly 0 or 2 children.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AllPossibleFullBinaryTrees.readme();
    int n;
      
    // Input: n = 7
    // Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
    n = 7;
    System.out.println("allPossibleFBT(" + n + ") = ");
    List<TreeNode> list1 = allPossibleFBT(n);
    TreeNode tree1;
    for (int i = 0; i < list1.size(); i++) {
        tree1 = list1.get(i);
        tree1.show();
        System.out.println("");
    }

      // Input: n = 3
      // Output: [[0,0,0]]
      n = 3;
      System.out.println("allPossibleFBT(" + n + ") = ");
      List<TreeNode> list2 = allPossibleFBT(n);
      TreeNode tree2;
      for (int i = 0; i < list2.size(); i++) {
          tree2 = list2.get(i);
          tree2.show();
          System.out.println("");
      }

  }
}