package sorting;

import java.util.Arrays;

public class ArrayPartition
{
  public static int arrayPairSum(int[] nums)
  {
    Arrays.sort(nums);

    int sum = 0;
    for (int i = nums.length - 1; i >= 0; i = i - 2) {
        sum += nums[i-1];
    }
    return sum;
  }

  public static int arrayPairSumOpt(int[] nums) 
  {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      max = Math.max(num, max);
      min = Math.min(num, min);
    }
    int[] counts = new int[max - min + 1];
    for (int num : nums) {
      counts[num - min]++;
    }
    int res = 0;
    int idx = 0;
    for (int i = 0; i < nums.length / 2; i++) {
      while (counts[idx] == 0) {
        idx++;
      }
      res += idx;
      counts[idx]--;
      while (counts[idx] == 0) {
        idx++;
      }
      counts[idx]--;
    }
    return res + nums.length / 2 * min;
  }

  public static void readme()
  {
    String str = "Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ArrayPartition.readme();

    // nums = [1,4,3,2] => 4
    int [] nums1 = {1,4,3,2};
    System.out.println("arrayPairSum(" + Arrays.toString(nums1) + ") = " +
                        arrayPairSum(nums1));

    // nums = [6,2,6,5,1,2] => 9
    int [] nums2 = {6,2,6,5,1,2};
    System.out.println("arrayPairSum(" + Arrays.toString(nums2) + ") = " +
                        arrayPairSum(nums2));

    System.out.println("arrayPairSumOpt(" + Arrays.toString(nums2) + ") = " +
                        arrayPairSumOpt(nums2));

  }
}