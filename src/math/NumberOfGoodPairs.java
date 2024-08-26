package math;
import java.util.Arrays;

public class NumberOfGoodPairs
{
  public static int numIdenticalPairs(int[] nums) {
      int res = 0;
      int[] freq = new int [100 + 1];
      for (int val: nums) {
          freq[val]++;
      }
      for (int i = 1; i < freq.length; i++) {
          if (freq[i] > 1) {
              res = res + freq[i] * (freq[i] - 1) / 2;
          }
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given an array of integers nums, return the number of good pairs.\n\n";

    str += "A pair (i, j) is called good if nums[i] == nums[j] and i < j.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfGoodPairs.readme();

    // Input: nums = [1,2,3,1,1,3]
    // Output: 4
    int [] nums1 = {1,2,3,1,1,3};
    System.out.println("numIdenticalPairs(" + Arrays.toString(nums1) + ") = " +
                       numIdenticalPairs(nums1));

    // Input: nums = [1,1,1,1]
    // Output: 6
    int [] nums2 = {1,1,1,1};
    System.out.println("numIdenticalPairs(" + Arrays.toString(nums2) + ") = " +
                       numIdenticalPairs(nums2));

    // Input: nums = [1,2,3]
    // Output: 0
    int [] nums3 = {1,2,3};
    System.out.println("numIdenticalPairs(" + Arrays.toString(nums3) + ") = " +
                       numIdenticalPairs(nums3));

  }
}