package math;

public class PowerOfThree
{
  public static boolean isPowerOfThree(int n) 
  {
    int value = 1;
    if (n <= 0) {
      return false;
    }

    while (n > value) {
      value = value * 3;
      if (n % value != 0) {
        return false;
      }
    }

    return true;
  }

  public static void readme()
  {
    String str = "Given an integer n, return true if it is a power of three. Otherwise, return false.\n\n";

    str += "An integer n is a power of three, if there exists an integer x such that n == 3x.\n";

    System.out.println(str);
  }

  public static void main()
  {
    PowerOfThree.readme();

    int n;
    // n = 27 => true
    n = 27;
    System.out.println("isPowerOfThree(" + n + ") = " + isPowerOfThree(n));

    // n = 0 => false
    n = 0;
    System.out.println("isPowerOfThree(" + n + ") = " + isPowerOfThree(n));

    // n = -1 => false
    n = -1;
    System.out.println("isPowerOfThree(" + n + ") = " + isPowerOfThree(n));

  }
}