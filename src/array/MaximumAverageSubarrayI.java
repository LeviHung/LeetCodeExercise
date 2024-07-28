package array;
import java.util.Arrays;

public class MaximumAverageSubarrayI
{
  public static double findMaxAverage(int[] nums, int k)
  {
    double avg = 0;
    int sum = 0;
    int max;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    max = sum;
    
    for (int i = 1; i < nums.length - k + 1; i++) {
      sum = sum - nums[i-1] + nums[i + k - 1];
      max = Math.max(sum, max);
    }
    
    avg = (double)max / k;
    return avg;
  }

  public static double findMaxAverageOpt(int[] nums, int k) 
  {
      int n = nums.length;
      int maxSum = Integer.MIN_VALUE;
      int sum=0;
      for(int i=0;i<k;i++){
          sum+=nums[i];
      }
      int left=0, right=k;
      while(right<n){
          maxSum = Math.max(maxSum,sum);
          sum-=nums[left++];
          sum+=nums[right++];
      }
      maxSum = Math.max(maxSum,sum);
      return Double.valueOf(maxSum)/k;
  }
  
  public static void readme()
  {
    String str = "You are given an integer array nums consisting of n elements, and an integer k.\n\n";

    str += "Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximumAverageSubarrayI.readme();
    int k;
    // nums = [1,12,-5,-6,50,3], k = 4 => 12.75000
    int [] nums1 = {1,12,-5,-6,50,3};
    k = 4;
    System.out.println("findMaxAverage(" + Arrays.toString(nums1) + 
                       ", " + k + ") = " +
                       findMaxAverage(nums1, k));

    // nums = [5], k = 1 => 5.00000
    int [] nums2 = {5};
    k = 1;
    System.out.println("findMaxAverage(" + Arrays.toString(nums2) + 
                       ", " + k + ") = " +
                       findMaxAverage(nums2, k));

    System.out.println("findMaxAverageOpt(" + Arrays.toString(nums2) + 
                       ", " + k + ") = " +
                       findMaxAverageOpt(nums2, k));

  }
}