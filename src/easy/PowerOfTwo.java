package easy;

public class PowerOfTwo
{
  public static boolean isPowerOfTwo(int n) 
  {
    int value = 1;
    if (n <= 0) {
      return false;
    }
    
    while (n > value) {
      value = value * 2;
      if (n % value != 0) {
        return false;
      }
    }
    
    return true;
  }

  public static void readme()
  {
    String str = "Given an integer n, return true if it is a power of two. Otherwise, return false.\n\n";

    str += "An integer n is a power of two, if there exists an integer x such that n == 2x.\n";

    System.out.println(str);
  }

  public static void main()
  {
    PowerOfTwo.readme();

    int n;
    // n = 1 => true
    n = 1;
    System.out.println("isPowerOfTwo(" + n + ") = " + isPowerOfTwo(n));

    // n = 16 => true
    n = 16;
    System.out.println("isPowerOfTwo(" + n + ") = " + isPowerOfTwo(n));

    // n = 3 => false
    n = 3;
    System.out.println("isPowerOfTwo(" + n + ") = " + isPowerOfTwo(n));

  }
}