package math;

public class SubtractProductAndSumOfDigitalInteger
{
  public static int subtractProductAndSum(int n) {
      int resP = 1;
      int resS = 0;
      while (n > 0) {
          int val = n % 10;
          resP = resP * val;
          resS = resS + val;
          n = n / 10;
      } 
      return resP - resS;
  }

  public static void readme()
  {
    String str = "Given an integer number n, return the difference between the product of its digits and the sum of its digits.\n";
    System.out.println(str);
  }

  public static void main()
  {
    SubtractProductAndSumOfDigitalInteger.readme();

    int n;
    // Input: n = 234
    // Output: 15 
    n = 234;
    System.out.println("subtractProductAndSum(" + n + ") = " + 
                       subtractProductAndSum(n));
    // Input: n = 4421
    // Output: 21
    n = 4421;
    System.out.println("subtractProductAndSum(" + n + ") = " + 
                       subtractProductAndSum(n));
  
  }
}