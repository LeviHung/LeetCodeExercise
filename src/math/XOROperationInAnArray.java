package math;
import java.util.Arrays;

public class XOROperationInAnArray
{
    public static int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^(start + 2 * i);
        }
        return res;
    }

  public static void readme()
  {
    String str = "You are given an integer n and an integer start.\n\n";

    str += " Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.\n\n";

    str += "Return the bitwise XOR of all elements of nums.\n";

    System.out.println(str);
  }

  public static void main()
  {
    XOROperationInAnArray.readme();

    int n;
    int start;
    // Input: n = 5, start = 0
    // Output: 8
    n = 5;
    start = 0;
    System.out.println("xorOperation(" + n + ", " + start + ") = " +
                       xorOperation(n, start));

      // Input: n = 4, start = 3
      // Output: 8
      n = 4;
      start = 3;
      System.out.println("xorOperation(" + n + ", " + start + ") = " +
                         xorOperation(n, start));

  }

}