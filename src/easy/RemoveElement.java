package easy;

import java.util.Arrays;

public class RemoveElement
{
  public static int removeElement(int[] nums, int val) 
  {
    // nums = [3,2,2,3], val = 3 => 2, nums = [2,2,_,_]
    // nums = [0,1,2,2,3,0,4,2], val = 2 => 5, nums = [0,1,4,0,3]
    int number = 0;
    int checkIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[checkIndex] = nums[i];
        checkIndex++;
        number++;
      }
    }
    
    return number;
  }

  public static void readme()
  {
    String str = "Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.\n\n";

    str += "Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:\n\n";

    str += "Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.\n";
    str += "Return k.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RemoveElement.readme();

    //nums = [1,1,2]
    int [] nums = {3,2,2,3};
    int val = 3;
    System.out.println("removeElement(" + Arrays.toString(nums) + 
     ", " + val + ") = " + RemoveElement.removeElement(nums, val) + 
     " " + Arrays.toString(nums));

    //[0,0,1,1,1,2,2,3,3,4]
    int [] nums2 = {0,1,2,2,3,0,4,2};
    int val2 = 2;
    System.out.println("removeDuplicates(" + Arrays.toString(nums2) + 
    ", " + val2 + ") = " + RemoveElement.removeElement(nums2, val2) + 
     " " + Arrays.toString(nums2));
  }
}