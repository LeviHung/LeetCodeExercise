package sorting;
import java.util.Arrays;

public class SortArrayByParity
{
  public static int[] sortArrayByParity(int[] nums)
  {
    int[] evenNums = new int[nums.length];
    int[] oddNums = new int[nums.length];
    int evenSize = 0;
    int oddSize = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        evenNums[evenSize++] = nums[i];
      } else {
        oddNums[oddSize++] = nums[i];
      }
    } 
    for (int i = 0; i < oddSize; i++) {
      evenNums[evenSize + i] = oddNums[i];
    }
     
    return evenNums;
  }

  public static int[] sortArrayByParityOpt(int[] nums) 
  {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      // Move left pointer to the right as long as the element is even
      while (left < right && nums[left] % 2 == 0) {
          left++;
      }
      // Move right pointer to the left as long as the element is odd
      while (left < right && nums[right] % 2 == 1) {
          right--;
      }
      // Swap the elements at left and right pointers
      if (left < right) {
          int temp = nums[left];
          nums[left] = nums[right];
          nums[right] = temp;
      }
    }

    return nums;
  }
  
  public static void readme()
  {
    String str = "Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.\n\n";

    str += "Return any array that satisfies this condition.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SortArrayByParity.readme();

    // nums = [3,1,2,4] => [2,4,3,1]
    int [] nums1 = {3,1,2,4};
    System.out.println("sortArrayByParity(" + Arrays.toString(nums1) + 
       ") = " +
       Arrays.toString(sortArrayByParity(nums1)));

    System.out.println("sortArrayByParityOpt(" + Arrays.toString(nums1) + 
                       ") = " +
                       Arrays.toString(sortArrayByParityOpt(nums1)));

    // nums = [0] => [0]
    int [] nums2 = {0};
    System.out.println("sortArrayByParity(" + Arrays.toString(nums2) + 
                       ") = " +
                       Arrays.toString(sortArrayByParity(nums2)));

  }
}