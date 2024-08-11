package sorting;
import java.util.Arrays;

public class SortArrayByParityII
{
  public static int[] sortArrayByParityII(int[] nums)
  {
    int tmp;
    int right = nums.length - 1;

    for (int i = 0; i < nums.length; i=i+2) {
      if (nums[i] % 2 == 1) {
        while (nums[right] % 2 == 1) {
          right = right - 2;
        }
        tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;
      }
    }
    return nums;
  }

  public static void readme()
  {
    String str = "Given an array of integers nums, half of the integers in nums are odd, and the other half are even.\n\n";

    str += "Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.\n\n";

    str += "Return any answer array that satisfies this condition.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SortArrayByParityII.readme();

    // nums = [4,2,5,7] => [4,5,2,7]
    int [] nums1 = {4,2,5,7};
    System.out.println("sortArrayByParityII(" + Arrays.toString(nums1) + 
       ") = " +
       Arrays.toString(sortArrayByParityII(nums1)));

    // nums = [2,3] => [2,3]
    int [] nums2 = {2,3};
    System.out.println("sortArrayByParityII(" + Arrays.toString(nums2) + 
                       ") = " +
                       Arrays.toString(sortArrayByParityII(nums2)));

  }
}