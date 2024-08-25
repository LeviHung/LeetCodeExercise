package sorting;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray
{
  public static int maxProduct(int[] nums) {
      int fMax = 0;
      int sMax = 0;
      for (int num: nums) {
          if (num > sMax) {
              if (num > fMax) {
                  sMax = fMax;
                  fMax = num;
              } else {
                  sMax = num;
              }
          }
      }
      return (fMax - 1) * (sMax - 1);
  }

  public static void readme()
  {
    String str = "Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximumProductOfTwoElementsInAnArray.readme();

    // Input: nums = [3,4,5,2]
    // Output: 12 
    int [] nums1 = {3,4,5,2};
    System.out.println("maxProduct(" + Arrays.toString(nums1) + ") = " +
                       maxProduct(nums1));

    // Input: nums = [1,5,4,5]
    // Output: 16
    int [] nums2 = {1,5,4,5};
    System.out.println("maxProduct(" + Arrays.toString(nums2) + ") = " +
                       maxProduct(nums2));

    // Input: nums = [3,7]
    // Output: 12
    int [] nums3 = {3,7};
    System.out.println("maxProduct(" + Arrays.toString(nums3) + ") = " +
                       maxProduct(nums3));

  }
}