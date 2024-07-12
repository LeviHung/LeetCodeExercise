package array;

import java.util.HashSet;
import java.util.Arrays;

public class ContainsDuplicate
{

  private static boolean containsDuplicate(int[] nums) 
  {
    HashSet<Integer> cache = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (cache.contains(nums[i])) {
        return true;
      } else {
        cache.add(nums[i]);
      }
    }
    return false; 
  }

  public static boolean containsDuplicateOpt(int[] nums)
  {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) {
          return true;
        
      } else if (nums[i] < nums[i-1]) {
        for (int j = i - 1; j >= 0; j-- ) {
            if (nums[i]==nums[j]) {
                return true;
            }
        }
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp; 
        }

    }
    return false;
  }

  public static void readme()
  {
    String str = "Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ContainsDuplicate.readme();

    // nums = [1,2,3,1] => true
    int[] nums1 = {1,2,3,1};
    System.out.println("containsDuplicate(" + Arrays.toString(nums1) + 
                       ") = " + ContainsDuplicate.containsDuplicate(nums1));

    // nums = [1,2,3,4] => false
    int[] nums2 = {1,2,3,4};
    System.out.println("containsDuplicate(" + Arrays.toString(nums2) + 
                       ") = " + ContainsDuplicate.containsDuplicate(nums2));

    
    // nums = [1,1,1,3,3,4,3,2,4,2] => true
    int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
    System.out.println("containsDuplicate(" + Arrays.toString(nums3) + 
                       ") = " + ContainsDuplicate.containsDuplicate(nums3));
    System.out.println("containsDuplicateOpt(" + Arrays.toString(nums3) +
                       ") = " + ContainsDuplicate.containsDuplicateOpt(nums3));

  }

}