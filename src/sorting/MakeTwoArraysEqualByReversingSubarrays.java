package sorting;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubarrays
{
  public static boolean canBeEqual(int[] target, int[] arr) {
      int[] nums = new int [1001];
      for (int val: target)
          nums[val]++;

      for (int val: arr) {
          if (nums[val] == 0)
              return false;
          nums[val]--;
      }

      return true;        
  }

  public static void readme()
  {
    String str = "You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.\n\n";

    str += "Return true if you can make arr equal to target or false otherwise.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MakeTwoArraysEqualByReversingSubarrays.readme();

    // Input: target = [1,2,3,4], arr = [2,4,1,3]
    // Output: true
    int [] target1 = {1,2,3,4};
    int [] arr1 = {2,4,1,3};
    System.out.println("canBeEqual(" + Arrays.toString(target1) + 
                       ", " + Arrays.toString(arr1) + ") = " +
                       canBeEqual(target1, arr1));

    // Input: target = [7], arr = [7]
    // Output: true
    int [] target2 = {7};
    int [] arr2 = {7};
    System.out.println("canBeEqual(" + Arrays.toString(target2) + 
                       ", " + Arrays.toString(arr2) + ") = " +
                       canBeEqual(target2, arr2));
  
    // Input: target = [3,7,9], arr = [3,7,11]
    // Output: false
    int [] target3 = {3,7,9};
    int [] arr3 = {3,7,11};
    System.out.println("canBeEqual(" + Arrays.toString(target3) + 
                       ", " + Arrays.toString(arr3) + ") = " +
                       canBeEqual(target3, arr3));

  }
}