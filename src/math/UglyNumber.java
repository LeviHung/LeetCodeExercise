package math;

public class UglyNumber
{
  public static boolean isUgly(int n)  
  {
    if (n <= 0) {
      return false;
    }
    while (n % 2 == 0) {
      n /= 2;
    }

    while (n % 3 == 0) {
      n /= 3;
    }

    while (n % 5 == 0) {
      n /= 5;
    }

    if (n == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isUglyEx(int n) 
  {
    while (n != 1) {
      if (n % 2 == 0 && n != 0) {
          n/=2;
      }
      else if(n%3==0 && n!=0)
      {
          n/=3;
      }
      else if(n%5==0 && n!=0)
      {
          n/=5;
      }
      else
      {
          return false;
      }
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.\n\n";

    str += "Given an integer n, return true if n is an ugly number.\n";
    System.out.println(str);
  }

  public static void main()
  {
    UglyNumber.readme();

    int n;
    // n = 6 => true
    n = 6;
    System.out.println("isUgly(" + n + ") = " + isUgly(n));

    // n = 1 => true
    n = 1;
    System.out.println("isUgly(" + n + ") = " + isUgly(n));

    //  n = 14 => false
    n = 14;
    System.out.println("isUgly(" + n + ") = " + isUgly(n));
  }
}