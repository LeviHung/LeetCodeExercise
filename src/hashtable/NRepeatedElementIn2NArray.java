package hashtable;
import java.util.Arrays;
import java.util.HashSet;

public class NRepeatedElementIn2NArray
{
  public static int repeatedNTimes(int[] nums)
  {
    boolean[] array = new boolean[10000+1];
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (array[nums[i]] == true) {
        res = nums[i];
        break;
      } else {
        array[nums[i]] = true;
      }
    }
    return res;
  }

  public static void readme()
  {
    String str = "You are given an integer array nums with the following properties:\n\n";

    str += "nums.length == 2 * n.\n\n";
    
    str += "nums contains n + 1 unique elements.\n\n";

    str += "Exactly one element of nums is repeated n times.\n\n";

    str += "Return the element that is repeated n times.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NRepeatedElementIn2NArray.readme();

    // nums = [1,2,3,3] => 3
    int [] nums1 = {1,2,3,3};
    System.out.println("repeatedNTimes(" + Arrays.toString(nums1) +
                       ") = " +
                       repeatedNTimes(nums1));

    // nums = [2,1,2,5,3,2] => 2
    int [] nums2 = {2,1,2,5,3,2};
    System.out.println("repeatedNTimes(" + Arrays.toString(nums2) +
                       ") = " +
                       repeatedNTimes(nums2));

    // nums = [5,1,5,2,5,3,5,4] => 5
    int [] nums3 = {5,1,5,2,5,3,5,4};
    System.out.println("repeatedNTimes(" + Arrays.toString(nums3) +
                       ") = " +
                       repeatedNTimes(nums3));

  }
}