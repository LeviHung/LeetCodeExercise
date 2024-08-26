package array;
import java.util.Arrays;

public class RunningSumOfOneDArray
{
    public static  int[] runningSum(int[] nums) {
        int[] sums = new int [nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i-1];
        }

        return sums;
    }

  public static void readme()
  {
    String str = "Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).\n\n";

    str += "Return the running sum of nums.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RunningSumOfOneDArray.readme();

    // Input: nums = [1,2,3,4]
    // Output: [1,3,6,10]
    int [] nums1 = {1,2,3,4};
    System.out.println("runningSum(" + Arrays.toString(nums1) + ") = " +
                       Arrays.toString(runningSum(nums1)));

      // Input: nums = [1,1,1,1,1]
      // Output: [1,2,3,4,5]
      int [] nums2 = {1,1,1,1,1};
      System.out.println("runningSum(" + Arrays.toString(nums2) + ") = " +
                         Arrays.toString(runningSum(nums2)));

      // Input: nums = [3,1,2,10,1]
      // Output: [3,4,6,16,17]
      int [] nums3 = {3,1,2,10,1};
      System.out.println("runningSum(" + Arrays.toString(nums3) + ") = " +
                         Arrays.toString(runningSum(nums3)));

  }
}