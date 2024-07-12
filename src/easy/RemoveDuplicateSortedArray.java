package easy;

import java.util.Arrays;

public class RemoveDuplicateSortedArray
{
  public static int removeDuplicates(int[] nums)
  {
    // [1,1,2], [0,0,1,1,1,2,2,3,3,4] = [0,1,2,3,4]

    // 1 <= nums.length <= 3 * 104
    /*
    if (nums.length == 0) {
      return 0;
    } 
    */    

    int checkIndex = 0;
    int number = 1;

    for (int i = 1; i < nums.length; i++) {
      
      if (nums[checkIndex] != nums[i]) {
        checkIndex += 1;
        nums[checkIndex] = nums[i];
        number++;
      } 
    }
    
    return number;
  }

  public static int removeDuplicatesOpt(int[] nums)
  {
    int k = 0;
  
    for (int i=1; i < nums.length; i++) {
      if (nums[i] != nums[k]) {
          k++;
          nums[k] = nums[i];
      }
    }
  
    return k+1;
  }
  
  public static void readme()
  {
    String str = "Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.\n\n";

    str += "Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:\n\n";

    str += "Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.\n";
    str += "Return k.";

    System.out.println(str);
  }

  public static void main()
  {
    RemoveDuplicateSortedArray.readme();

    //nums = [1,1,2]
    int [] nums = {1, 1, 2};
    System.out.println("removeDuplicates(" + Arrays.toString(nums) + 
     ") = " + RemoveDuplicateSortedArray.removeDuplicates(nums) + 
     " " + Arrays.toString(nums));

    //[0,0,1,1,1,2,2,3,3,4]
    int [] nums2 = {0,0,1,1,1,2,2,3,3,4};
    System.out.println("removeDuplicates(" + Arrays.toString(nums2) + 
     ") = " + RemoveDuplicateSortedArray.removeDuplicates(nums2) + 
     " " + Arrays.toString(nums2));
  }
}