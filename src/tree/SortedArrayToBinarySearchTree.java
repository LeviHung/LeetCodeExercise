package tree;

import java.util.Arrays;

public class SortedArrayToBinarySearchTree
{
  private static TreeNode root;
  
  public static TreeNode sortedArrayToBST(int[] nums)
  {
    root = null;
    
    convert(nums, 0, nums.length - 1);

    return root;
  }

  public static void convert(int nums[], int i, int k) 
  {
    //System.out.println("i = " + i + ", k = " + k);
    if (i > k) {
      return;
    }
    int j = (i + k) / 2; // Find the midpoint in the partition
    //System.out.println("j = " + j);
    insert(nums[j]);
    convert(nums, i, j - 1);
    convert(nums, j + 1, k);
  }
  
  public static void insert(int value)
  {
    if (root == null) {
      root = new TreeNode(value);
      return;
    } 

    TreeNode currentNode = root;
    while (true) {
      if (value < currentNode.val) {
        if (currentNode.left == null) {
          currentNode.left = new TreeNode(value);
          return;
        }
        currentNode = currentNode.left;

      } else {
        if(currentNode.right == null) {
          currentNode.right = new TreeNode(value);			
           return;
        }
        currentNode = currentNode.right;
      }
    }
  }

  public static TreeNode sortedArrayToBSTOpt(int[] nums)
  {
    return helper(nums, 0, nums.length - 1);
  }

  public static TreeNode helper(int[] nums, int l, int r)
  {
    if (l > r) {
      return null;
    }
    int m = (l + r) / 2;
    TreeNode root = new TreeNode(nums[m]);
    root.left = helper(nums, l, m - 1);
    root.right = helper(nums, m + 1, r);
    return root;
  }

  
  public static void readme()
  {
    String str = "Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SortedArrayToBinarySearchTree.readme();

    //nums1 = [-10,-3,0,5,9], => [0,-3,9,-10,null,5]
    int [] nums1 = {-10,-3,0,5,9};

    System.out.print("sortedArrayToBST(" + Arrays.toString(nums1) + 
                     ") = ");
    TreeNode tree1 = SortedArrayToBinarySearchTree.sortedArrayToBST(nums1);

    tree1.show();
    System.out.println("");

    tree1 = SortedArrayToBinarySearchTree.sortedArrayToBSTOpt(nums1);

    tree1.show();
    System.out.println("");
  }
}