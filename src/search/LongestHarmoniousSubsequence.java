package search;
import java.util.Arrays;

public class LongestHarmoniousSubsequence
{
  public static int findLHS(int[] nums) 
  {
    // [1,2,2,2,3,3,5,7]
    Arrays.sort(nums);

    int max = 0;
    int count = 0;
    int i = 0;
    int index;
    boolean hasHarm = false;
    while (i < nums.length - 1) {
        index = i + 1;
        
        while (nums[i] == nums[index]) {
          index++;
          if (index > nums.length - 1) {
              break;
          }
        }
        if (index < nums.length ) {
          while (nums[i] == nums[index] - 1) {
          hasHarm = true;
          index++;
            if (index > nums.length - 1) {
              break;
            }
          }
        }
        
        count = index - i;
        if (hasHarm) {
          max = Math.max(count, max);
          hasHarm = false;
        }
        i++;
    }

    return max;
  }

  public static int findLHSOpt(int[] nums) 
  {
    Arrays.sort(nums);
    int l = 0;
    int m = 0;
    for (int r = 0; r < nums.length; r++) {
      while (nums[r] - nums[l] > 1) {
        l++;
      }

      if (nums[r] - nums[l] == 1) {
        m = Math.max(m, r - l + 1);
      }
    }
    return m;
  }
    
  public static void readme()
  {
    String str = "We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.\n\n";

    str += "Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.\n\n";

    str += "A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    LongestHarmoniousSubsequence.readme();

    // nums = [1,3,2,2,5,2,3,7] => 5
    int [] nums1 = {1,3,2,2,5,2,3,7};
    System.out.println("findLHS(" + Arrays.toString(nums1) + ") = " +
                       findLHS(nums1));

    // nums = [1,2,3,4] => 2
    int [] nums2 = {1,2,3,4};
    System.out.println("findLHS(" + Arrays.toString(nums2) + ") = " +
                       findLHS(nums2));

    // nums = [1,1,1,1] => 0
    int [] nums3 = {1,1,1,1};
    System.out.println("findLHS(" + Arrays.toString(nums3) + ") = " +
                       findLHS(nums3));
      
    // nums = [1,2] => 2
    int [] nums4 = {1,2};
    System.out.println("findLHS(" + Arrays.toString(nums4) + ") = " +
                        findLHS(nums4));

    // nums = [1,4,1,3,1,-14,1,-13]
    int [] nums5 = {1,4,1,3,1,-14,1,-13};
    System.out.println("findLHS(" + Arrays.toString(nums5) + ") = " +
                        findLHS(nums5));
    System.out.println("findLHSOpt(" + Arrays.toString(nums5) + ") = " +
                        findLHSOpt(nums5));

  }
}