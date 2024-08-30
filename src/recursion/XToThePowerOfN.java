package recursion;

public class XToThePowerOfN
{
  public static double myPow(double x, int n) {
    if (n == 0)
        return 1;
    if (n < 0) {
        if ((n * -1) % 2 == 1)
            return 1/x * myPow(x, n + 1);
        return myPow(x * x,n/2);
    }
    if (n % 2 == 1)
        return x * myPow(x, n - 1);
    return myPow(x * x, n / 2);
  }
  /*
  public double myPow(double x, int n) {
    if (n == 0) {
        return 1;
    }
    if (n > 0) {
        return x * myPow(x, n - 1);
    } else {
        return 1 / x * (myPow(x, n + 1));
    }
  }
  */

  public static void readme()
  {
    String str = "Implement pow(x, n), which calculates x raised to the power n (i.e., xn).\n";

    System.out.println(str);
  }

  public static void main()
  {
    XToThePowerOfN.readme();

    double x;
    int n;
    // Input: x = 2.00000, n = 10
    // Output: 1024.00000
    x = 2.0;
    n = 10;
    System.out.println("myPow(" + x + ", " + n + ") = " + myPow(x, n));

    // Input: x = 2.10000, n = 3
    // Output: 9.26100
    x = 2.1;
    n = 3;
    System.out.println("myPow(" + x + ", " + n + ") = " + myPow(x, n));

    // Input: x = 2.00000, n = -2
    // Output: 0.25000

    x = 2.0;
    n = -2;
    System.out.println("myPow(" + x + ", " + n + ") = " + myPow(x, n));

  }
}