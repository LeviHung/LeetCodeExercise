package easy;

import java.util.HashMap;
import java.util.Arrays;

public class ContainsDuplicateII
{

  private static boolean containsDuplicate(int[] nums, int k) 
  {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
        return true;
      } else {
        map.put(nums[i], i);
      }
    }
    return false; 
  }

  public static boolean containsDuplicateOpt(int[] nums, int k) 
  {
    if (nums.length <= k) {
      k = nums.length - 1;
    }
    
    int count=0;

    for (int i = 0; i < nums.length - 1; i++) {
      int jPointer = i + 1;

      while (jPointer < nums.length && jPointer <= i + k) {
        if (nums[i] == nums[jPointer]) {
          return true;
        }
        
        jPointer++;
        count++;
        if (count > 9999) {
          return false;
        }
      }
    }

    return false;
  }

  public static void readme()
  {
    String str = "Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ContainsDuplicate.readme();
    int k;
    // nums = [1,2,3,1], k = 3 true
    int[] nums1 = {1,2,3,1};
    k = 3;
    System.out.println("containsDuplicate(" + Arrays.toString(nums1) + 
                       ", " + k + ") = " +
                       ContainsDuplicateII.containsDuplicate(nums1, k));

    // nums = [1,0,1,1], k = 1 => true
    int[] nums2 = {1,0,1,1};
    k = 1;
    System.out.println("containsDuplicate(" + Arrays.toString(nums2) + 
                       ", " + k + ") = " +
                       ContainsDuplicateII.containsDuplicate(nums2, k));
                

    // nums = [1,2,3,1,2,3], k = 2 => false
    int[] nums3 = {1,2,3,1,2,3};
    k = 2;
    System.out.println("containsDuplicate(" + Arrays.toString(nums3) + 
                       ", " + k + ") = " +
                       ContainsDuplicateII.containsDuplicate(nums3, k));

    System.out.println("containsDuplicateOpt(" + Arrays.toString(nums3) + 
                        ", " + k + ") = " +
                        ContainsDuplicateII.containsDuplicateOpt(nums3, k));

  }

}