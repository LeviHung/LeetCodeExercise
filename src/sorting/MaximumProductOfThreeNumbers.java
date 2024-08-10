package sorting;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers
{
  public static int maximumProduct(int[] nums)
  {
    int firstL = Integer.MIN_VALUE;
    int secondL = Integer.MIN_VALUE;
    int thirdL = Integer.MIN_VALUE;

    int firstS = Integer.MAX_VALUE;
    int secondS = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > firstL) {
        thirdL = secondL;
        secondL = firstL;
        firstL = nums[i];
      } else if (nums[i] > secondL) {
        thirdL = secondL;
        secondL = nums[i];
      } else if (nums[i] > thirdL) {
        thirdL = nums[i];
      }

      if (nums[i] < firstS) {
        secondS = firstS;
        firstS = nums[i];
      } else if (nums[i] < secondS) {
        secondS = nums[i];
      }
    }
    return Math.max(firstS * secondS * firstL, firstL * secondL * thirdL); 
  }

  public int maximumProductOpt(int[] nums) {
      int fmax=Integer.MIN_VALUE,smax=Integer.MIN_VALUE,tmax=Integer.MIN_VALUE;
      int fmin=Integer.MAX_VALUE,smin=Integer.MAX_VALUE;
      for(int i:nums)
      {
          if(i>tmax)
          {
              if(i>fmax)
              {
                  tmax=smax;
                  smax=fmax;
                  fmax=i;
              }
              else if(i>smax)
              {
                  tmax=smax;
                  smax=i;
              }
              else
                  tmax=i;
          }
          if(i<smin)
          {
              if(i<fmin)
              {
                  smin=fmin;
                  fmin=i;
              }
              else
                  smin=i;
          }
      }
      int p1=fmin*smin*fmax;
      int p2=smax*tmax*fmax;
      return (p1>p2)?p1:p2;

  }
  
  public static int maximumProductEx(int[] nums)
  {
    int product = 0;
    int zeroCount = 0;
    int [] tmp = new int [nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCount++;
      } else {
        tmp[i] = nums[i + zeroCount];
      }
    }
    int [] array = new int [nums.length - zeroCount];
    for (int i = 0; i < nums.length - zeroCount; i++) {
      array[i] = tmp[i];
    }

    Arrays.sort(array);
    if (array.length < 3) {
      return 0;
    }
    product = array[array.length-1];
    if (array[0] < 0 && array[1] < 0) {
      product = Math.max(array[array.length-1] * array[0] * array[1], 
      array[array.length-1] * array[array.length-2] * array[array.length - 3]);
    } else {
      product = product * array[array.length-2] * array[array.length - 3];
    }

    if (product < 0 && zeroCount > 0)
      return 0;
    
    return product;
  }

  public static void readme()
  {
    String str = "Given an integer array nums, find three numbers whose product is maximum and return the maximum product.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximumProductOfThreeNumbers.readme();

    // nums = [1,2,3] => 6
    int[] nums1 = {1,2,3};
    System.out.println("maximumProduct(" + Arrays.toString(nums1) + ") = " +
                       maximumProduct(nums1));

    // nums = [1,2,3,4] => 24
    int[] nums2 = {1,2,3,4};
    System.out.println("maximumProduct(" + Arrays.toString(nums2) + ") = " +
                       maximumProduct(nums2));

    // nums = [1,-2,-3] => -6
    int[] nums3 = {-1,-2,-3};
    System.out.println("maximumProduct(" + Arrays.toString(nums3) + ") = " +
                       maximumProduct(nums3));

    // nums = [-3,-2,-1,0,0,0,0] => 0
    int[] nums4 = {-3,-2,-1,0,0,0,0};
    System.out.println("maximumProduct(" + Arrays.toString(nums4) + ") = " +
                       maximumProduct(nums4));

    // nums = [-1, -2, -3, -4] => -6
    int[] nums5 = {-1, -2, -3, -4};
    System.out.println("maximumProduct(" + Arrays.toString(nums5) + ") = " +
                       maximumProduct(nums5));

    // nums = [-100,-98,-1,2,3,4] => 39200
    int[] nums6 = {-100,-98,-1,2,3,4};
    System.out.println("maximumProduct(" + Arrays.toString(nums6) + ") = " +
                       maximumProduct(nums6));
      
  }
}