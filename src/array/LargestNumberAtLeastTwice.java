package array;
import java.util.Arrays;

public class LargestNumberAtLeastTwice
{
  public static int dominantIndex(int[] nums)
  {
    // [3,6,1,0]
    // [1,2,3,4]
    int fMax = 0;
    int sMax = 0;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > sMax) {
        if (nums[i] > fMax) {
          sMax = fMax;
          fMax = nums[i];
          index = i;
        } else {
          sMax = nums[i];
        }
      }  
    }
    if (fMax >= sMax * 2) {
      return index;
    } else {
      return -1;
    }
  }

  public static void readme()
  {
    String str = "You are given an integer array nums where the largest integer is unique.\n\n";

    str += "Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LargestNumberAtLeastTwice.readme();

    // nums = [3,6,1,0] => 1
    int [] nums1 = {3,6,1,0};
    System.out.println("dominantIndex(" + Arrays.toString(nums1) + ") = " +
                       dominantIndex(nums1));

    // nums = [1,2,3,4] => -1
    int [] nums2 = {1,2,3,4};
    System.out.println("dominantIndex(" + Arrays.toString(nums2) + ") = " +
                        dominantIndex(nums2));

  }
}