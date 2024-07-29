package search;

import java.util.Arrays;

public class SetMismatch
{
  public static int[] findErrorNums(int[] nums)
  {
    int [] set = new int [nums.length + 1];
    int flag = 0;
    // [1,2,2,4]
    int [] res = new int[2];
    for (int i = 0; i < nums.length; i++) {
      set[nums[i]]++;
    }

    for (int i = 1; i < nums.length + 1; i++) {
      if (set[i] == 2) {
        res[0] = i;
        if (flag == 2) 
          break;
        flag = 1;
      } else if (set[i] == 0) {
        res[1] = i;
        if (flag == 1)
          break;
        flag = 2;
      }
    }

    return res;
  }

  public static void readme()
  {
    String str = "You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.\n\n";

    str += "You are given an integer array nums representing the data status of this set after the error.\n\n";

    str += "Find the number that occurs twice and the number that is missing and return them in the form of an array.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SetMismatch.readme();

    // nums = [1,2,2,4] => [2, 3]
    int [] nums1 = {1,2,2,4};
    System.out.println("findErrorNums(" + Arrays.toString(nums1) + ") = " +
                       Arrays.toString(findErrorNums(nums1)));

    // nums = [1,1] => [1, 2]
    int [] nums2 = {1,1};
    System.out.println("findErrorNums(" + Arrays.toString(nums2) + ") = " +
                       Arrays.toString(findErrorNums(nums2)));

    // nums = [3,2,2] => [2, 1]
    int [] nums3 = {3,2,2};
    System.out.println("findErrorNums(" + Arrays.toString(nums3) + ") = " +
                       Arrays.toString(findErrorNums(nums3)));

  }
}