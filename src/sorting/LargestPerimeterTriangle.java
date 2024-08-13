package sorting;

import java.util.Arrays;

public class LargestPerimeterTriangle
{
  public static int largestPerimeter(int[] nums) 
  {
    Arrays.sort(nums);

    for (int i = nums.length - 1; i >=2; i--) {
      if (nums[i] < nums[i-1] + nums[i-2]) {
        return nums[i] + nums[i-1] + nums[i-2];
      }
    }

      return 0;
  }

  public static void readme()
  {
    String str = "Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LargestPerimeterTriangle.readme();

    // nums = [2,1,2] => 5
    int [] nums1 = {2,1,2};
    System.out.println("largestPerimeter(" + Arrays.toString(nums1) + ") = " +
                       largestPerimeter(nums1));

    // nums = [1,2,1,10] => 0
    int [] nums2 = {1,2,1,10};
    System.out.println("largestPerimeter(" + Arrays.toString(nums2) + ") = " +
                       largestPerimeter(nums2));

  }
}