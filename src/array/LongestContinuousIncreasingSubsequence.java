package array;
import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence
{
  public static int findLengthOfLCIS(int[] nums) 
  {
    int count = 0;
    int max = 0;
    count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i-1]) {
        count++;

      } else {
        max = Math.max(max, count);
        count = 1;
        if (max >= nums.length - i)
          break;
      }
    }
    
    max = Math.max(max, count);
    return max;
  }

  public static int findLengthOfLCISOpt(int[] nums) 
  {
     return helper(nums,0,1);
  }

  private static int helper(int[] nums,int index,int max)
  {
    if(index>=nums.length-1){
        return max;
    }

    int maxLen = 1;

    for(int i=index;i<nums.length-1;i++){
      if(nums[i]<nums[i+1]){
          maxLen++;
      }
      else{
          break;
      }
    }

    max = Math.max(maxLen,max);

    return helper(nums,index+maxLen,max);
  }

  public static void readme()
  {
    String str = "Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.\n\n";

    str += "A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].\n";

    System.out.println(str);
  }

  public static void main()
  {
    LongestContinuousIncreasingSubsequence.readme();

    // nums = [1,3,5,4,7] => 3
    int [] nums1 = {1,3,5,4,7};
    System.out.println("findLengthOfLCIS(" + Arrays.toString(nums1) + ") = " +
                       findLengthOfLCIS(nums1));

    // nums = [2,2,2,2,2] => 1
    int [] nums2 = {2,2,2,2,2};
    System.out.println("findLengthOfLCIS(" + Arrays.toString(nums2) + ") = " +
                       findLengthOfLCIS(nums2));
    
    System.out.println("findLengthOfLCISOpt(" + Arrays.toString(nums2) + ") = " +
                       findLengthOfLCISOpt(nums2));

  }
}