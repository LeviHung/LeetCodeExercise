package math;

public class PowerOfFour
{
  public static boolean isPowerOfFour(int n) 
  {   
    if (n <= 0) {
      return false;
    }
    
    while ( n > 1) {
      if (n % 4 != 0) {
        return false;
      }
      n = n / 4;
    }
    return true;

    // Without loop
    /*
    switch (n) {
      case 1:
      case 4:
      case 4*4:
      case 4*4*4:
      case 4*4*4*4:
      case 4*4*4*4*4:
      case 4*4*4*4*4*4:
      case 4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4*4*4*4*4:
      case 4*4*4*4*4*4*4*4*4*4*4*4*4*4*4:
        return true;
      default:
        return false;
    }
    */
  }

  public static void readme()
  {
    String str = "Given an integer n, return true if it is a power of four. Otherwise, return false.\n\n";

    str += "An integer n is a power of four, if there exists an integer x such that n == 4x.\n";

    str += "Follow up: Could you solve it without loops/recursion?\n";

    System.out.println(str);
  }

  public static void main()
  {
    PowerOfFour.readme();

    int n;
    // n = 16 => true
    n = 16;
    System.out.println("isPowerOfFour(" + n + ") = " + isPowerOfFour(n));

    // n = 5 => false
    n = 5;
    System.out.println("isPowerOfFour(" + n + ") = " + isPowerOfFour(n));

    // n = 1 => true
    n = 1;
    System.out.println("isPowerOfFour(" + n + ") = " + isPowerOfFour(n));

  }
}