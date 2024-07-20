package math;

import java.util.Arrays;

public class PerfectNumber
{
  private static Integer[] primes = new Integer[] { 2, 3, 5, 7, 13};
  // 11, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
  //  79, 83, 89, 97, 101, 103, 107, 109, 113 };
  
  public static boolean checkPerfectNumber(int num)
  {
    for (int i = 0; i < primes.length; i++) {
      if (num == Math.pow(2, primes[i] - 1) * (Math.pow(2, primes[i]) - 1)) {
        return true;
      }
      //System.out.println(Math.pow(2, primes[i] - 1) * (Math.pow(2, primes[i]) - 1));
    }
    return false;
  }

  public static boolean checkPerfectNumberEx(int num) 
  {
      if (num < 2) {
          return false;
      }

      if (num % 2 != 0) {
          return false;
      }

      int sum = 1;
      int max = num;
      for (int i = 2; i < max; i++) {
          if (num % i == 0) {
              //System.out.println(i);
              sum += i;

              int otherDivisor = num / i;
              if (otherDivisor != i) {
                  //System.out.println(otherDivisor);
                  sum += otherDivisor;
              }
              max = otherDivisor;
          }
      }
      return sum == num;
  }

  public static void readme()
  {
    String str = "A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.\n\n";

    str += "Given an integer n, return true if n is a perfect number, otherwise return false.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    PerfectNumber.readme();

    int num;
    // num = 28 => true
    num = 28;
    System.out.println("checkPerfectNumbex(" + num + ") = " + checkPerfectNumber(num));

    // num = 7 => false
    num = 7;
    System.out.println("checkPerfectNumber(" + num + ") = " + checkPerfectNumber(num));

    num = 8128;
    System.out.println("checkPerfectNumberEx(" + num + ") = " + checkPerfectNumberEx(num));

  }
}