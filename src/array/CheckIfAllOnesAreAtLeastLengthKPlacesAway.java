package array;
import java.util.Arrays;

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway
{
  public static boolean kLengthApart(int[] nums, int k) {
      int last = (k + 1) * -1;
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 1) {
              if ((i - last) <= k) {
                  return false;
              } 
              last = i;
          }
      }
      return true;
  }

  public static void readme()
  {
    String str = "Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CheckIfAllOnesAreAtLeastLengthKPlacesAway.readme();
    int k;
    // Input: nums = [1,0,0,0,1,0,0,1], k = 2
    // Output: true
    int [] nums1 = {1,0,0,0,1,0,0,1};
    k = 2;
    System.out.println("kLengthApart(" + Arrays.toString(nums1) +
                       ", " + k + ") = " +
                       kLengthApart(nums1, k));

    // Input: nums = [1,0,0,1,0,1], k = 2
    // Output: false
    int [] nums2 = {1,0,0,1,0,1};
    k = 2;
    System.out.println("kLengthApart(" + Arrays.toString(nums2) +
                       ", " + k + ") = " +
                       kLengthApart(nums2, k));


  }
}