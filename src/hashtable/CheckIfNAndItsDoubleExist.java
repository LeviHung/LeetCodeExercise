package hashtable;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist
{
  public static boolean checkIfExist(int[] arr) {
      boolean[] nums = new boolean[2001];
      for (int val: arr) {
          if (val % 2 == 0) {
              if (nums[val/2 + 1000] == true) {
                  return true;
              }
          }
          if (val >= -500 && val <= 500) {
              if (nums[val * 2 + 1000] == true) {
                  return true;
              }
          }
          nums[val + 1000] = true;
      }
      return false;
  }

  public static void readme()
  {
    String str = "Given an array arr of integers, check if there exist two indices i and j such that :\n\n";
    str += "i != j\n\n";

    str += "0 <= i, j < arr.length\n\n";

    str += "arr[i] == 2 * arr[j]\n";

    System.out.println(str);
  }

  public static void main()
  {
    CheckIfNAndItsDoubleExist.readme();

    // Input: arr = [10,2,5,3]
    // Output: true

    int[] arr1 = {10,2,5,3};
    System.out.println("checkIfExist(" + Arrays.toString(arr1) + 
                       ") = " + checkIfExist(arr1));

    // Input: arr = [3,1,7,11]
    // Output: false
    int[] arr2 = {3,1,7,11};
    System.out.println("checkIfExist(" + Arrays.toString(arr2) + 
                       ") = " + checkIfExist(arr2));

  }

}