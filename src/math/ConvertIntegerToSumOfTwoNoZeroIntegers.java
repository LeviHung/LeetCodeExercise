package math;

import java.util.Arrays;

public class ConvertIntegerToSumOfTwoNoZeroIntegers
{
  public static int[] getNoZeroIntegers(int n) {
    int a = 1;
    int b = n - 1;
    while (checkNoZero(b) == false || checkNoZero(a) == false ) {
        a++;
        b--;
    }
    return new int [] {a, b};
  }
  
  public static boolean checkNoZero(int val) {
    while (val > 0) {
        if (val % 10 == 0) {
            return false;
        }
        val = val / 10;
    }
    return true;
  }

  public static void readme()
  {
    String str = "No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.\n\n";

    str += "Given an integer n, return a list of two integers [a, b] where:\n\n";

    str += "a and b are No-Zero integers.\n\n";

    str += " a + b = n\n\n";

    str += "The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ConvertIntegerToSumOfTwoNoZeroIntegers.readme();

    int n;
    // Input: n = 2
    // Output: [1,1]

    n = 2;
    System.out.println("getNoZeroIntegers(" + n + ") = " + 
                        Arrays.toString(getNoZeroIntegers(n)));

    // Input: n = 11
    // Output: [2,9]

    n = 11;
    System.out.println("getNoZeroIntegers(" + n + ") = " + 
                       Arrays.toString(getNoZeroIntegers(n)));

  }
}