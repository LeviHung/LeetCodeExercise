package array;
import java.util.Arrays;

public class RangeSumQuery
{
  private static int [] array;
  public RangeSumQuery(int[] nums) 
  {
    array = nums;
    array = nums.clone();
  }
  
  public static int sumRange(int left, int right)
  {
    int sum = 0;
    for (int i = left; i <= right; i++) {
      sum += array[i];
    }
    return sum;
  }

  static int[] arr;
  public static void RangeSumQueryOpt(int[] nums) {
      arr = Arrays.copyOf(nums, nums.length);
      for(int i = 1 ; i < arr.length ; i++){
          arr[i] += arr[i-1] ;
      }
  }

  public int sumRangeOpt(int left, int right) 
  {
      if (left == 0) 
        return arr[right];
    
      return arr[right] - arr[left-1] ;
  }
  
  public static void readme()
  {
    String str = "Given an integer array nums, handle multiple queries of the following type:\n\n";

    str += "Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.\n\n";

    str += "Implement the NumArray class:\n\n";

    str += "NumArray(int[] nums) Initializes the object with the integer array nums.\n\n";

    str += "int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    RangeSumQuery.readme();

    int left;
    int right;
    int [] nums = {-2, 0, 3, -5, 2, -1};
    RangeSumQuery numArray = new RangeSumQuery(nums);
    left = 0;
    right = 2;
    System.out.println("NumArray = " + Arrays.toString(nums));
    System.out.println("sumRange(" + left + ", " + right + ") = " + 
                        sumRange(left, right));

    left = 2;
    right = 5;
    // nums = [0] => [0]
    System.out.println("sumRange(" + left + ", " + right + ") = " + 
                        sumRange(left, right));

    left = 0;
    right = 5;

    System.out.println("sumRange(" + left + ", " + right + ") = " + 
                        sumRange(left, right));

  }
}