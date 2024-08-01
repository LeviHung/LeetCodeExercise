package search;
import java.util.Arrays;

public class BinarySearch
{
  public static int search(int[] nums, int target)
  {
    
    int l = 0;
    int r = nums.length - 1;
    int m = 0;
    while (l <= r) {
      m = (r - l) / 2 + l;
      if (nums[m] == target) {
        return m;
      } else if (nums[m] > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return -1;
  }

  public static void readme()
  {
    String str = "Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.\n\n";

    str += "You must write an algorithm with O(log n) runtime complexity.\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinarySearch.readme();
    int target;
    // nums = [-1,0,3,5,9,12], target = 9 => 4
    int [] nums1 = {-1,0,3,5,9,12};
    target = 9;
    System.out.println("findLHS(" + Arrays.toString(nums1) + ", " +
                       target +") = " +
                       search(nums1, target));

    // nums = [-1,0,3,5,9,12], target = 2 => -1
    int [] nums2 = {-1,0,3,5,9,12};
    target = 2;
    System.out.println("findLHS(" + Arrays.toString(nums2) + ", " +
                       target +") = " +
                       search(nums2, target));

    // nums = [-1,0,3,5,9,12], target = 2 => -1
    int [] nums3 = {5};
    target = 5;
    System.out.println("findLHS(" + Arrays.toString(nums3) + ", " +
                       target +") = " +
                       search(nums3, target));

    int [] nums4 = {2, 5};
    target = 5;
    System.out.println("findLHS(" + Arrays.toString(nums4) + ", " +
                       target +") = " +
                       search(nums4, target));

  }
}