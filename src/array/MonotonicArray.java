package array;
import java.util.Arrays;

public class MonotonicArray
{
  public static boolean isMonotonic(int[] nums)
  {
    boolean isInc = false;
    if (nums[nums.length - 1] > nums[0]) {
      isInc = true;
    }
    
    if (isInc == true) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i+1]) {
          return false;
        }
      }
    } else {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] < nums[i+1]) {
          return false;
        }
      }
    }
    return true;
    
    /*
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i+1] && isInc == false) {
          return false;
      } else if (nums[i] > nums[i+1] && isInc == true) {
          return false;
      }
    }
    return true;
    */

    /*
    if (nums.length == 1) {
      return true;
    }
    int inc = 0; // 1 (inc) or 2 (dec)
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
          continue;
      }

      if (nums[i] < nums[i+1]) {
          if (inc == 2) {
              return false;
          }
          inc = 1;
      } else if (nums[i] > nums[i+1]) {
          if (inc == 1) {
              return false;
          }
          inc = 2;
      } 
    } 
    return true;  
    */   
  }

  public static void readme()
  {
    String str = "An array is monotonic if it is either monotone increasing or monotone decreasing.\n\n";

    str += "An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].\n\n";
    
    str += "Given an integer array nums, return true if the given array is monotonic, or false otherwise.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    MonotonicArray.readme();

    // nums = [1,2,2,3] => true
    int [] nums1 = {1,2,2,3};
    System.out.println("isMonotonic(" + Arrays.toString(nums1) + ") = " +
                       isMonotonic(nums1));

    // nums = [6,5,4,4] => true
    int [] nums2 = {6,5,4,4};
    System.out.println("isMonotonic(" + Arrays.toString(nums2) + ") = " +
                       isMonotonic(nums2));

    // nums = [1,3,2] => false
    int [] nums3 = {1,3,2};

    System.out.println("isMonotonic(" + Arrays.toString(nums3) + ") = " +
                       isMonotonic(nums3));

  }
}