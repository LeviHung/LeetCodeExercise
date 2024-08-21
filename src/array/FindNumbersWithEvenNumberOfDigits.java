package array;
import java.util.Arrays;

public class FindNumbersWithEvenNumberOfDigits
{
  public static int findNumbers(int[] nums) {
      int res = 0;
      for (int num: nums) {
          if(((int)(Math.log10(num))) % 2 == 1) {
              res++;
          }
          /*
          if (num > 9 && num < 100 ||
              num > 999 & num < 10000 ||
              num == 100000) {
              res++;
          }
          */
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given an array nums of integers, return how many of them contain an even number of digits.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindNumbersWithEvenNumberOfDigits.readme();

    // Input: nums = [12,345,2,6,7896]
    // Output: 2

    int [] nums1 = {12,345,2,6,7896};
    System.out.println("findNumbers(" + Arrays.toString(nums1) + ") = " +
                       findNumbers(nums1));

    // Input: nums = [555,901,482,1771]
    // Output: 1 

    int [] nums2 = {555,901,482,1771};
    System.out.println("findNumbers(" + Arrays.toString(nums2) + ") = " +
                       findNumbers(nums2));

  }
}