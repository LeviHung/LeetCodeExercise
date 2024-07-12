package array;
import java.util.Arrays;

public class MissingNumber
{
  public static int missingNumber(int[] nums) 
  {
    int [] array = new int [nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      array[nums[i]] = 1;
    }
    for (int i = 0; i < nums.length + 1; i++) {
      if (array[i] != 1) {
        return i;
      }
    }
    
    return 0;
  }

  public static void readme()
  {
    String str = "Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    MissingNumber.readme();

    // nums = [3,0,1] => 2
    int[] nums1 = {3,0,1};
    System.out.println("missingNumber(" + Arrays.toString(nums1) + ") = " + 
                       missingNumber(nums1));

    // nums = [0,1] => 2
    int[] nums2 = {0,1};
    System.out.println("missingNumber(" + Arrays.toString(nums2) + ") = " + 
                       missingNumber(nums2));

    // nums = [9,6,4,2,3,5,7,0,1] => 8
    int[] nums3 = {9,6,4,2,3,5,7,0,1};
    System.out.println("missingNumber(" + Arrays.toString(nums3) + ") = " + 
                       missingNumber(nums3));
  }
}