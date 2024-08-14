package bit;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryPrefixDivisibleByFive
{
  public static List<Boolean> prefixesDivBy5(int[] nums) 
  {
      // Use remain digit strategy
      int[] array = new int [] {0, 2, 4, 6, 8, 0, 2, 4, 6, 8}; 
      Boolean[] result = new Boolean[nums.length];
      int last = 0;
      for (int i = 0; i < nums.length; i++) {
          int val = array[last] + nums[i];
          if (val == 0 || val == 5) {
              result[i] = true;
          } else {
              result[i] = false;
          }
          last = val;
      }

      return Arrays.asList(result);

      // Use BigInteger class
      /*
      List<Boolean> list = new ArrayList<>();
      //long last = 0;
      BigInteger last = new BigInteger("0");
      BigInteger five = new BigInteger("5");
      BigInteger zero = new BigInteger("0");
      BigInteger two = new BigInteger("2");
      for (int i = 0; i < nums.length; i++) {
          //long val = last * 2 + nums[i];
          BigInteger num = new BigInteger(String.valueOf(nums[i]));
          BigInteger val = last.multiply(two).add(num);
          //if (val % 5 == 0) {
          if (val.mod(five).equals(zero)) {
              list.add(true);
          } else {
              list.add(false);
          }
          last = val;
      }

      return list;
      */
  }
  
  public static void readme()
  {
    String str = "You are given a binary array nums (0-indexed).\n\n";

    str += "We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).\n\n";
    
    str += "For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.\n\n";
    
    str += "Return an array of booleans answer where answer[i] is true if xi is divisible by 5.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinaryPrefixDivisibleByFive.readme();

    int turnedOn;
    // nums = [0,1,1] => [true,false,false]
    int[] nums1 = {0,1,1,};
    System.out.println("prefixesDivBy5(" + Arrays.toString(nums1) + ") = ");     
    List list1 = prefixesDivBy5(nums1);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }

    // nums = [1,1,1] => [false,false,false]
    int[] nums2 = {1,1,1};
    System.out.println("prefixesDivBy5(" + Arrays.toString(nums2) + ") = ");     
    List list2 = prefixesDivBy5(nums2);
    if (list2 != null) {
      System.out.println(Arrays.toString(list2.toArray()));
    }
  }
}