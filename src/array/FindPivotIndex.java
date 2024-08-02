package array;
import java.util.Arrays;

public class FindPivotIndex
{
  public static int pivotIndex(int[] nums)
  {
    int sum = 0;

    for (int i = nums.length - 1; i > 0; i--) {
      sum += nums[i];
    }
    if (sum == 0) {
      return 0;
    }

    int sumL = 0;
    int sumR = 0;
    int p = 1;
    sumL = nums[0];
    
    for (int i = p + 1; i < nums.length; i++) {
      sumR += nums[i];
    }

    while (p < nums.length - 1) {
      if (sumL == sumR) {
        return p;
      }
      sumL += nums[p];
      p++;
      sumR -= nums[p];
    } 

    sum = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      sum += nums[i];
    }
    if (sum == 0) {
      return nums.length - 1;
    }

    return -1;
  }

  public static int pivotIndexOpt(int[] nums) {

      // we want the left most...
      int leftSum = 0;
      int rightSum = 0;
      for (int num: nums) {
          rightSum += num;
      }
      // 1 7 3 6 5 6 

      // 0    27
      // 1    20
      // 8    17
      // 11   11
      for (int i = 0; i < nums.length; i++) {
          rightSum -= nums[i];
          if (leftSum == rightSum) {
              return i;
          }
          leftSum += nums[i];
      }
      return -1;
  }
  
  public static void readme()
  {
    String str = "Given an array of integers nums, calculate the pivot index of this array.\n\n";

    str += "The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.\n\n";

    str += "If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.\n\n";

    str += "Return the leftmost pivot index. If no such index exists, return -1.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindPivotIndex.readme();

    // nums = [1,7,3,6,5,6] => 3
    int [] nums1 = {1,7,3,6,5,6};
    System.out.println("pivotIndex(" + Arrays.toString(nums1) + ") = " +
                       pivotIndex(nums1));

    // nums = [1,2,3] => -1
    int [] nums2 = {1,2,3};
    System.out.println("pivotIndex(" + Arrays.toString(nums2) + ") = " +
                       pivotIndex(nums2));

    // nums = [2,1,-1] => 0
    int [] nums3 = {2,1,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums3) + ") = " +
                       pivotIndex(nums3));

    // nums = [-1,-1,-1,-1,-1,0] => 2
    int [] nums4 = {-1,-1,-1,-1,-1,0};
    System.out.println("pivotIndex(" + Arrays.toString(nums4) + ") = " +
                       pivotIndex(nums4));

    // nums = [-1,-1,-1,0,-1,-1] => 2
    int [] nums5 = {-1,-1,-1,0,-1,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums5) + ") = " +
                       pivotIndex(nums5));

    // nums = [-1,-1,-1,0,1,-1] => 1
    int [] nums6 = {-1,-1,-1,0,1,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums6) + ") = " +
                       pivotIndex(nums6));

    int [] nums7 = {-1,-1,-1,-1,-1,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums7) + ") = " +
                       pivotIndex(nums7));

    int [] nums8 = {-1,-1,0,1,0,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums8) + ") = " +
                        pivotIndex(nums8));

    int [] nums9 = {-1,-1,0,-1,-1,-1};
    System.out.println("pivotIndex(" + Arrays.toString(nums9) + ") = " +
                        pivotIndex(nums9));

    int [] nums10 = {-1,-1,0,0,-1,0};
    System.out.println("pivotIndex(" + Arrays.toString(nums10) + ") = " +
                        pivotIndex(nums10));

    int [] nums11 = {-1,-1,0,1,1,0};
    System.out.println("pivotIndex(" + Arrays.toString(nums11) + ") = " +
                        pivotIndex(nums11));

    int [] nums12 = {-1,-1,1,1,0,0};
    System.out.println("pivotIndex(" + Arrays.toString(nums12) + ") = " +
                        pivotIndex(nums12));
    System.out.println("pivotIndexOpt(" + Arrays.toString(nums12) + ") = " +
                        pivotIndexOpt(nums12));

  }
}