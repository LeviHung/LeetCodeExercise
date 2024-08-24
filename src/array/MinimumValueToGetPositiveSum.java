package array;
import java.util.Arrays;

public class MinimumValueToGetPositiveSum
{
  public static int minStartValue(int[] nums) {
      int min = Integer.MAX_VALUE;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
          if (sum < min) {
              min = sum;
          }
      }
      if (min >= 0) {
          return 1;
      } 

      return min * (-1) + 1;
  }

  public static void readme()
  {
    String str = "Given an array of integers nums, you start with an initial positive value startValue.\n\n";

    str += "In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).\n\n";

    
    str += " Return the minimum positive value of startValue such that the step by step sum is never less than 1.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumValueToGetPositiveSum.readme();

    // Input: nums = [-3,2,-3,4,2]
    // Output: 5
    int [] nums1 = {-3,2,-3,4,2};
    System.out.println("minStartValue(" + Arrays.toString(nums1) + ") = " +
                       minStartValue(nums1));

    // Input: nums = [1,2]
    // Output: 1
    int [] nums2 = {1,2};
    System.out.println("minStartValue(" + Arrays.toString(nums2) + ") = " +
                       minStartValue(nums2));


    // Input: nums = [1,-2,-3]
    // Output: 5
    int [] nums3 = {1,-2,-3};
    System.out.println("minStartValue(" + Arrays.toString(nums3) + ") = " +
                       minStartValue(nums3));


  }
}