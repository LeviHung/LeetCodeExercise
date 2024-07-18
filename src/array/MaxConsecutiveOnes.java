package array;

import java.util.Arrays;

public class MaxConsecutiveOnes
{
  private static int findMaxConsecutiveOnes(int[] nums)
  {
    int count = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
        if (count > max) {
          max = count;
        }
      } else {
        count = 0;
      }
    }
    
    return max;
  }

  private static int findMaxConsecutiveOnesOpt(int[] nums)
  {
    int cnt = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) 
          cnt++;  
      else {
        max = Math.max(cnt,max);
          cnt = 0;
      }
    }
    max = Math.max(cnt,max);
    return max;
  }

  public static void readme()
  {
    String str = "Given a binary array nums, return the maximum number of consecutive 1's in the array.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaxConsecutiveOnes.readme();

    // nums = [1,1,0,1,1,1] => 3
    int[] nums1 = {1,1,0,1,1,1};
    System.out.println("findMaxConsecutiveOnes(" + Arrays.toString(nums1) + 
                       ") = " + findMaxConsecutiveOnes(nums1));

    // nums = [1,0,1,1,0,1] => 2
    int[] nums2 = {1,0,1,1,0,1};
    System.out.println("findMaxConsecutiveOnes(" + Arrays.toString(nums2) + 
                       ") = " + findMaxConsecutiveOnes(nums2));

  }

}