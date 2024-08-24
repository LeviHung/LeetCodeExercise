package array;
import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder
{
    public static int[] createTargetArray(int[] nums, int[] index) {
       int[] target = new int[nums.length];
       for (int i = 0; i < nums.length; i++) {
            insertTargetArray(target, index[i], nums[i]);
       }
       return target;
    }

    public static void insertTargetArray(int[] target, int index, int value) {
        for (int i = target.length - 1; i > index; i--) {
            target[i] = target[i-1];
        }
        target[index] = value;
    }

  public static void readme()
  {
    String str = "Given two arrays of integers nums and index. Your task is to create target array under the following rules:\n\n";

    str += "Initially target array is empty.\n\n";
    str += "From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.\n\n";
    str += "Repeat the previous step until there are no elements to read in nums and index.\n\n";
    str += "Return the target array.\n\n";
    str += " It is guaranteed that the insertion operations will be valid.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CreateTargetArrayInTheGivenOrder.readme();

    // Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
    // Output: [0,4,1,3,2]

    int [] nums1 = {0,1,2,3,4};
    int [] index1 = {0,1,2,2,1};
    System.out.println("createTargetArray(" + Arrays.toString(nums1) + "," +
                       Arrays.toString(index1) + ") = " +
                       Arrays.toString(createTargetArray(nums1, index1)));

    // Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
    // Output: [0,1,2,3,4]
    int [] nums2 = {1,2,3,4,0};
    int [] index2 = {0,1,2,3,0};
    System.out.println("createTargetArray(" + Arrays.toString(nums2) + "," +
                       Arrays.toString(index2) + ") = " +
                       Arrays.toString(createTargetArray(nums2, index2)));

    // Input: nums = [1], index = [0]
    // Output: [1]
    int [] nums3 = {1};
    int [] index3 = {0};
    System.out.println("createTargetArray(" + Arrays.toString(nums3) + "," +
                       Arrays.toString(index3) + ") = " +
                       Arrays.toString(createTargetArray(nums3, index3)));

  }
}