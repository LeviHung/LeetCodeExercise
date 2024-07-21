package math;

import java.util.HashMap;

public class FibonacciNumber
{
  private static HashMap<Integer, Integer> cache = new HashMap<>();
  
  public static int fib(int n)
  {
    if (cache.containsKey(n) == true) {
      return cache.get(n);
    }

    if (n < 2) {
      return n;
    }
    
    cache.put(n, fib(n-1) + fib(n-2));

    return cache.get(n);
  }

  public static int fibEx(int n) 
  {
      if (n <= 1) {
          return n;
      }
      int[] fibNumbers = new int[n + 1];
      fibNumbers[0] = 0;
      fibNumbers[1] = 1;
      for (int i = 2; i <= n; i++) {
          fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
      }
      return fibNumbers[n];
  }
  
  public static void readme()
  {
    String str = "The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,\n\n";

    str += "F(0) = 0, F(1) = 1\n\n";

    str += "F(n) = F(n - 1) + F(n - 2), for n > 1.\n\n";

    str += "Given n, calculate F(n).\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    FibonacciNumber.readme();

    int n;
    // n = 2 => 1
    n = 2;
    System.out.println("fib(" + n + ") = " + fib(n));

    // n = 3 => 2
    n = 3;
    System.out.println("fib(" + n + ") = " + fib(n));

    // n = 4 => 3
    n = 4;
    System.out.println("fib(" + n + ") = " + fib(n));

    System.out.println("fibEx(" + n + ") = " + fibEx(n));
  }
}