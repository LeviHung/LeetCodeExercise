package sorting;
import java.util.Arrays;

public class ThirdMaximumNumber
{
  public static int thirdMax(int[] nums)
  {
    int firstMax = 0;
    long secondMax = Long.MIN_VALUE;
    long thirdMax  = Long.MIN_VALUE;
    firstMax = nums[0];
    
    //for (int i = 1; i < nums.length; i++) {
    for (int num: nums) {
      if (num == firstMax || num == secondMax) {
        continue;
      }

      if (num > firstMax) {
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = num; 

      } else if (num > secondMax) {
        thirdMax = secondMax;
        secondMax = num;

      } else if (num > thirdMax) {
        thirdMax = num;
      }
    }

    if (thirdMax == Long.MIN_VALUE) {
      thirdMax = firstMax;
    }
    return (int) thirdMax;
  }

  public static int thirdMaxOpt(int[] nums) 
  {
      long max = Long.MIN_VALUE, smax = Long.MIN_VALUE, tmax= Long.MIN_VALUE;
      for(int num :nums){
          if(num > max){
              tmax= smax;
              smax= max;
              max= num;
          } else if(num > smax){
              if(num != max){
                  tmax= smax;
                  smax= num;
              }
          } else if(num > tmax && smax != num){
              tmax = num;
          }
      }
      return tmax == Long.MIN_VALUE ? (int)max :(int)tmax;
  }
  public static void readme()
  {
    String str = "Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    ThirdMaximumNumber.readme();
    
    // nums = [3,2,1] => 1
    int [] nums = {3, 2, 1};
    System.out.println("thirdMax(" + Arrays.toString(nums) + 
                       ") = " + thirdMax(nums));

    // nums = [1,2] => 2
    int [] nums2 = {1, 2};
    System.out.println("thirdMax(" + Arrays.toString(nums2) + 
                       ") = " + thirdMax(nums2));

    // nums = [2,2,3,1] => 1
    int [] nums3 = {2,2,3,1};
    System.out.println("thirdMax(" + Arrays.toString(nums3) + 
                       ") = " + thirdMax(nums3));

    int [] nums4 = {5,2,2};
    System.out.println("thirdMax(" + Arrays.toString(nums4) + 
                       ") = " + thirdMax(nums4));

    int [] nums5 = {1,2,-2147483648};
    System.out.println("thirdMax(" + Arrays.toString(nums5) + 
                       ") = " + thirdMax(nums5));
    
    int [] nums6 = {1,2,2,5,3,5};
    System.out.println("thirdMax(" + Arrays.toString(nums6) + 
                       ") = " + thirdMax(nums6));

    int [] nums7 = {1,-2147483648,2};
    System.out.println("thirdMax(" + Arrays.toString(nums7) + 
                       ") = " + thirdMax(nums7));

    int [] nums8 = {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
    System.out.println("thirdMax(" + Arrays.toString(nums8) + 
                       ") = " + thirdMax(nums8));

  }
}