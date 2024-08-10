package math;

import java.util.Arrays;

public class SmallestRangeI
{
  public static int smallestRangeI(int[] nums, int k)
  {
    int min = 10000;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
      } 
      if (nums[i] < min) {
        min = nums[i];
      }
    }
    if ((max - k) < (min + k)) {
      return 0;
    } else {
      return (max - k) - (min + k);
    }
  }

  static int max(int[] nums)
  {
    int maxPos = 0;
    for(int i=1;i<nums.length;i++)
       if(nums[i] > nums[maxPos])
            maxPos = i;
    return maxPos;
  }
  
  static int min(int[] nums)
  {
    int minPos = 0;
    for(int i=1;i<nums.length;i++)
       if(nums[i] < nums[minPos])
            minPos = i;
    return minPos;
  }
  
  public static int smallestRangeIOpt(int[] nums, int k) 
  {
    if(nums.length == 1 || max(nums) - min(nums) == 0) return 0;
    if(k==0) return nums[max(nums)]-nums[min(nums)];
    int maxPos = max(nums);
    int minPos = min(nums);

    int median = (nums[maxPos]+nums[minPos])/2;
    int rqrd_k = nums[maxPos] - median;
    if(k >= rqrd_k) return 0;

    return nums[maxPos] - k -nums[minPos] - k ;

  }
  
  public static void readme()
  {
    String str = "You are given an integer array nums and an integer k.\n\n";

    str += "In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.\n\n";

    str += "The score of nums is the difference between the maximum and minimum elements in nums.\n\n";

    str += "Return the minimum score of nums after applying the mentioned operation at most once for each index in it.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SmallestRangeI.readme();
    int k;
    // nums = [1], k = 0 => 0
    int[] nums1 = {1};
    k = 0;
    System.out.println("smallestRangeI(" + Arrays.toString(nums1) +
                       ", " + k + ") = " + 
                       smallestRangeI(nums1, k));

    // nums = [0,10], k = 2 => 6
    int[] nums2 = {0, 10};
    k = 2;
    System.out.println("smallestRangeI(" + Arrays.toString(nums2) +
                       ", " + k + ") = " + 
                       smallestRangeI(nums2, k));

    // nums = [1,3,6], k = 3 => 0
    int[] nums3 = {1,3,6};
    k = 3;
    System.out.println("smallestRangeI(" + Arrays.toString(nums3) +
                       ", " + k + ") = " + 
                       smallestRangeI(nums3, k));

    System.out.println("smallestRangeIOpt(" + Arrays.toString(nums3) +
                       ", " + k + ") = " + 
                       smallestRangeIOpt(nums3, k));

  }
}