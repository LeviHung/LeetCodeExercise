package hashtable;

import java.util.Arrays;

public class HowManyNumbersAreSmallThanCurrent
{
  public static int[] smallerNumbersThanCurrent(int[] nums) {
      int [] freq = new int [101];
      int max = Integer.MIN_VALUE;
      for (int num: nums) {
          freq[num]++;
          max = Math.max(num, max);
      }
      int count = 0;
      int tmp = 0;
      for (int i = 0; i <= max; i++) {
          if (freq[i] > 0) {
              tmp = freq[i];
              freq[i] = count;
              count += tmp;
          }
      }
      int [] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
          res[i] = freq[nums[i]];
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].\n\n";

    str += "Return the answer in an array.\n";

    System.out.println(str);
  }

  public static void main()
  {
    HowManyNumbersAreSmallThanCurrent.readme();

    // Input: nums = [8,1,2,2,3]
    // Output: [4,0,1,1,3]

    int [] nums1 = {8,1,2,2,3};
    System.out.println("smallerNumbersThanCurrent(" + Arrays.toString(nums1) + ") = " +
                       Arrays.toString(smallerNumbersThanCurrent(nums1)));

    // Input: nums = [6,5,4,8]
    // Output: [2,1,0,3]

    int [] nums2 = {6,5,4,8};
    System.out.println("smallerNumbersThanCurrent(" + Arrays.toString(nums2) + ") = " +
                       Arrays.toString(smallerNumbersThanCurrent(nums2)));

    //Input: nums = [7,7,7,7]
    // Output: [0,0,0,0]

    int [] nums3 = {7,7,7,7};
    System.out.println("smallerNumbersThanCurrent(" + Arrays.toString(nums3) + ") = " +
                       Arrays.toString(smallerNumbersThanCurrent(nums3)));

  }
}