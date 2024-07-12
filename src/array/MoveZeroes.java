package array;
import java.util.Arrays;

public class MoveZeroes
{
  public static void moveZeroes(int[] nums)
  {
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[pos++] = nums[i];
      }
    }
    for (;pos < nums.length; pos++) {
      nums[pos] = 0;
    }
  }

  public static void moveZeroesOpt(int[] nums) 
  {
      int[] nums2 = new int[nums.length];
      int index = 0;
      for(int i = 0; i < nums.length; i++){
          if(nums[i] != 0){
              nums2[index++] = nums[i];
          }
      }
      for(int i = 0; i < nums.length; i++){
          nums[i] = nums2[i];
      }
  }
  
  public static void readme()
  {
    String str = "Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.\n\n";

    str += "Note that you must do this in-place without making a copy of the array.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    MoveZeroes.readme();

    // nums = [0,1,0,3,12] => [1,3,12,0,0]
    int[] nums1 = {0,1,0,3,12};
    System.out.println("moveZeroes(" + Arrays.toString(nums1) + ") = ");
                        moveZeroes(nums1);
    System.out.println(Arrays.toString(nums1));

    // nums = [0] => [0]
    int[] nums2 = {0};
    System.out.println("moveZeroes(" + Arrays.toString(nums2) + ") = ");
                        moveZeroes(nums2);
    System.out.println(Arrays.toString(nums2));

  }
}