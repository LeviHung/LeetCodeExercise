package easy;
import java.util.Arrays;

public class SingleNumber
{
  public static int singleNumber(int[] nums)    
  {
    int i = 0;
    int j = 0;
    int target = nums[0];
    i = 1;
    j = 2;
    while (i < nums.length && j < nums.length) {
      target = target ^ nums[i] ^ nums[j];
      i = i + 2;
      j = j + 2;
    }
    return target;
    /*
    Arrays.sort(nums);
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      //System.out.println("l = " + l + ", r = " + r);
      if (l < nums.length - 2 && nums[l] == nums[l+1]) {
        l = l + 2;
      } else {
        //System.out.println("### return " + nums[l]);
        return nums[l];
      }
    }
    
    return 0;
    */
  }

  public static int singleNumberOpt(int[] nums) 
  {
    int x = nums[0];
    x = find(nums, 1, 2, x);
    return x;
  }
  
  public static int find(int arr[],int i, int j,int x)
  {
    if (i == arr.length || j == arr.length) {
      System.out.println("### return x = " + x);
      return x;
    }
    //System.out.println("x = " + x + ", arr[i] = " + arr[i] + ", arr[j] = " + arr[j]);

    x = x ^ arr[i] ^ arr[j];
    //System.out.println("x = " + x); 
                       
    return find(arr, j+1, j+2, x);
  }
      
  public static void readme()
  {
    String str = "Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.\n\n";

    str += "You must implement a solution with a linear runtime complexity and use only constant extra space.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SingleNumber.readme();

    //nums = [2,2,1] => 1
    int [] nums = {1, 1, 2};
    System.out.println("singleNumber(" + Arrays.toString(nums) + 
     ") = " + SingleNumber.singleNumber(nums));

    //nums = [4,1,2,1,2] => 4
    int [] nums2 = {4,1,2,1,2};
    System.out.println("singleNumber(" + Arrays.toString(nums2) + 
     ") = " + SingleNumber.singleNumber(nums2));

    //nums = [1] => 1
    int [] nums3 = {1};
    System.out.println("singleNumber(" + Arrays.toString(nums3) + 
     ") = " + SingleNumber.singleNumber(nums3));
  }
}