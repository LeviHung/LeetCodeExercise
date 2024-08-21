package array;
import java.util.Arrays;

public class DecompressRunLengthEncodedList
{
  public static int[] decompressRLElist(int[] nums) {
      int size = 0;
      for (int i = 0; i<nums.length; i=i+2) {
          size += nums[i];
      }
      int[] res = new int [size];
      int count = 0;
      int num = 0;
      int index = 0;
      for (int i = 0; i<nums.length; i=i+2) {
          Arrays.fill(res, index, index+nums[i], nums[i+1]);
          index = index+nums[i];
          /*
          count = nums[i];
          num = nums[i+1];
          while (nums[i] > 0) {
              res[index++] = num;
              count--;
          }
          */
      }
      /*
      for (int i = 0; i<nums.length; i++) {
          if (i % 2 == 0) {
              count = nums[i];
          } else {
              num = nums[i];
              while (count > 0) {
                  res[index++] = num;
                  count--;
              }
          }
      }
      */
      return res;
  }

  public static void readme()
  {
    String str = "We are given a list nums of integers representing a list compressed with run-length encoding.\n\n";

    str += " Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.\n\n";
    
    str += " Return the decompressed list.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DecompressRunLengthEncodedList.readme();

    // Input: nums = [1,2,3,4]
    // Output: [2,4,4,4]
    int [] nums1 = {1,2,3,4};
    System.out.println("decompressRLElist(" + Arrays.toString(nums1) + ") = " +
                       Arrays.toString(decompressRLElist(nums1)));

    // Input: nums = [1,1,2,3]
    // Output: [1,3,3]
    int [] nums2 = {1,1,2,3};
    System.out.println("decompressRLElist(" + Arrays.toString(nums2) + ") = " +
                       Arrays.toString(decompressRLElist(nums2)));

  }
}