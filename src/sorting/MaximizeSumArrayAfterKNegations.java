package sorting;
import java.util.Arrays;

public class MaximizeSumArrayAfterKNegations
{
  public static int largestSumAfterKNegations(int[] nums, int k)
  {
    int[] number = new int [201];
    for (int i = 0; i < nums.length; i++) {
      number[nums[i] + 100]++;
    }
    int index = 0;
    while( k > 0) {
      while (number[index] == 0) {
        index++;
      }

      if (index < 100) {
        number[index]--;
        number[200 - index]++;
        k--;
      } else if (index == 100) {
        k = 0;
      } else {
        if (k % 2 == 0)
          k = 0;
        else {
          number[index]--;
          number[200 - index]++;
          k = 0;
        }
      }
    }
    int sum = 0;
    for (int i = 0; i < number.length; i++) {
      sum += (i - 100) * number[i];
    }
    return sum;
  }

  public static void readme()
  {
    String str = "Given an integer array nums and an integer k, modify the array in the following way:\n\n";

    str += "choose an index i and replace nums[i] with -nums[i].\n\n";
    str += "You should apply this process exactly k times. You may choose the same index i multiple times.\n\n";
    str += "Return the largest possible sum of the array after modifying it in this way.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximizeSumArrayAfterKNegations.readme();

    int k;
    // nums = [4,2,3], k = 1 => 5
    int [] nums1 = {4, 2, 3};
    k = 1;
    System.out.println("largestSumAfterKNegations(" + Arrays.toString(nums1) +
                       ", " + k + ") = " + 
                       largestSumAfterKNegations(nums1, k));

    // nums = [3,-1,0,2], k = 3 = 6
    int [] nums2 = {3,-1,0,2};
    k = 3;
    System.out.println("largestSumAfterKNegations(" + Arrays.toString(nums2) +
                       ", " + k + ") = " + 
                       largestSumAfterKNegations(nums2, k));

    // nums = [2,-3,-1,5,-4], k = 2 => 13
    int [] nums3 = {2,-3,-1,5,-4};
    k = 2;
    System.out.println("largestSumAfterKNegations(" + Arrays.toString(nums3) +
                       ", " + k + ") = " + 
                       largestSumAfterKNegations(nums3, k));

  }
}