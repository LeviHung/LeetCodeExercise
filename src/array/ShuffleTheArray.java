package array;
import java.util.Arrays;

public class ShuffleTheArray
{
  public static int[] shuffle(int[] nums, int n) {
      int[] res = new int[nums.length];
      for (int i = 0; i < n; i++) {
          res[i*2] = nums[i];
          res[i*2+1] = nums[i+n];
      }
      return res;
      /*
      int[] tmp = new int[n];
      int[] tmp2 = new int [n];
      int index = 0;

      //System.out.println(Arrays.toString(tmp)+Arrays.toString(tmp2));

      for (int i = 0; i < n; i++) {
          tmp[i] = nums[i];
          tmp2[i] = nums[i+n];
      }
      //System.out.println(Arrays.toString(tmp)+Arrays.toString(tmp2));
      for (int i = 0; i < n; i++) {
          nums[i*2] = tmp[i];
          nums[i*2+1] = tmp2[i];
      }
      // [1,2,3,4,4,3,2,1]
      //    4   3   2
      //      2   3   4  
      return nums;
      */
  }

  public static void readme()
  {
    String str = "Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].\n\n";

    str += "Return the array in the form [x1,y1,x2,y2,...,xn,yn].\n";

    System.out.println(str);
  }

  public static void main()
  {
    ShuffleTheArray.readme();
    int n;
    // Input: nums = [2,5,1,3,4,7], n = 3
    // Output: [2,3,5,4,1,7] 
    int [] nums1 = {2,5,1,3,4,7};
    n = 3;
    System.out.println("shuffle(" + Arrays.toString(nums1) +
                       ", " + n + ") = " +
                       Arrays.toString(shuffle(nums1, n)));

    // Input: nums = [1,2,3,4,4,3,2,1], n = 4
    // Output: [1,4,2,3,3,2,4,1]
    int [] nums2 = {1,2,3,4,4,3,2,1};
    n = 4;
    System.out.println("shuffle(" + Arrays.toString(nums2) +
                       ", " + n + ") = " +
                       Arrays.toString(shuffle(nums2, n)));

    // Input: nums = [1,1,2,2], n = 2
    // Output: [1,2,1,2]
    int [] nums3 = {1,1,2,2};
    n = 2;
    System.out.println("shuffle(" + Arrays.toString(nums3) +
                       ", " + n + ") = " +
                       Arrays.toString(shuffle(nums3, n)));

  }
}