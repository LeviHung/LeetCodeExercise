package math;

import java.util.Arrays;

public class CountingBits
{
  public static int[] countBits(int n)
  {
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    // 0 1 1 2 1 2 2 3 1 2 2  3  2  3  3  4   1
    // 0001 100001 10 10100000
    int [] bits = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    int [] nums = new int [n + 1];

    for (int i = 0; i <= n; i++) {
      int index = i;
      while (index > 0) {
        nums[i] += bits[(index % 16)];
        index = index / 16;
      }
    }
      
    return nums;
  }

  public static int hammingWeightOpt(int n) 
  {
    int count = 0;

    for (int i = 0; i < 16; i++) {
      if (((n >> i) & 1) == 1) {
        count++;
      }
    }

    return count;
  }

  public static int[] countBitsOpt(int n) 
  {
    int[] bitCount = new int[n + 1];

    count(bitCount, 1, 1);

    return bitCount;
  }

  private static void count(final int[] bitCount, 
                            final int number, 
                            final int numberOfOnes) 
  {
    if (number < bitCount.length) {
      bitCount[number] = numberOfOnes;

      count(bitCount, number << 1, numberOfOnes);
      count(bitCount, (number << 1) + 1, numberOfOnes + 1);
    }
  }
  
  public static void readme()
  {
    String str = "Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    CountingBits.readme();

    int n;
    // n = 2 => [0, 1, 1]
    n = 2;
    System.out.println("countBits(" + n + ") = ");
    int[] nums1 = countBits(n);
    System.out.println(Arrays.toString(nums1));
    // n = 5 => [0, 1, 1, 2, 1, 2]
    n = 5;
    System.out.println("countBits(" + n + ") = ");
    int[] nums2 = countBits(n);
    System.out.println(Arrays.toString(nums2));

  }
}