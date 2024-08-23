package tree;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindACorrespondingNodeInACloneTree
{
  public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    TreeNode res = help(cloned, target.val);

    return res;        
  }

  public static TreeNode help(TreeNode btree, int val) {
    if (btree == null) {
        return null;
    }

    if (val == btree.val) {
        return btree;
    }
    TreeNode res = help(btree.left, val);
    if (res != null) {
        return res;
    }
    res = help(btree.right, val);
    if (res != null) {
        return res;
    }

    return null;
  }

  public static TreeNode getTargetCopyOpt(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if(cloned == null) return null;
    if(cloned.val == target.val)
        return cloned;
    TreeNode leftResult =  getTargetCopyOpt(original,cloned.left,target); 
    if(leftResult != null)
        return leftResult;
    return getTargetCopyOpt(original,cloned.right,target);

  }

  public static void readme()
  {
    String str = "Given two binary trees original and cloned and given a reference to a node target in the original tree.\n\n";

    str += "The cloned tree is a copy of the original tree.\n\n";

    str += "Return a reference to the same node in the cloned tree.\n\n";

    str += "Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindACorrespondingNodeInACloneTree.readme();
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode node4;
    TreeNode node5;
    TreeNode node6;
    TreeNode node7;
    TreeNode node8;
    TreeNode node19;
    TreeNode target;
    // Input: tree = [7,4,3,null,null,6,19], target = 3
    // Output: 3

    // => true
    //        7
    //   4       3
    //          6  19

    node6 = new TreeNode(6);
    node19 = new TreeNode(19);
    node3 = new TreeNode(3, node6, node19);
    node4 = new TreeNode(4);

    TreeNode tree1 = new TreeNode(7, node4, node3);
    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    node6 = new TreeNode(6);
    node19 = new TreeNode(19);
    node3 = new TreeNode(3, node6, node19);
    node4 = new TreeNode(4);
    TreeNode tree2 = new TreeNode(7, node4, node3);
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");
    target = new TreeNode(3);
    System.out.println("getTargetCopy(tree1, tree2, target) = ");
    TreeNode tree3 = getTargetCopy(tree1, tree2, target);
    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");


    // Input: tree = [7], target =  7
    // Output: 7
    TreeNode tree4 = new TreeNode(7);
    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    TreeNode tree5 = new TreeNode(7);
    System.out.print("Tree 5: ");
    tree5.show();
    System.out.println("");
    target = new TreeNode(7);

    System.out.println("getTargetCopy(tree4, tree5, target) = ");
    TreeNode tree6 = getTargetCopy(tree4, tree5, target);
    System.out.print("Tree 6: ");
    tree6.show();
    System.out.println("");

  }
}