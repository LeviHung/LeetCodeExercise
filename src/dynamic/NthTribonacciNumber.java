package dynamic;

public class NthTribonacciNumber
{
  static int[] map = new int[38];

  public static int tribonacci(int n) {
    if (map[n] > 0)
        return map[n];

    if (n < 3) {
        if (n == 2) {
            map[n] = 1;
        } else {
            map[n] = n;
        }
        return map[n];
    }

    map[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    return map[n];
  }

  public static void readme()
  {
    String str = "The Tribonacci sequence Tn is defined as follows:\n\n";

    str += "T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.\n\n";

    str += "Given n, return the value of Tn.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NthTribonacciNumber.readme();

    int n;
    // Input: n = 4
    // Output: 4
    n = 4;
    System.out.println("tribonacci(" + n + ") = " + tribonacci(n));

    // Input: n = 25
    // Output: 1389537
    n = 25;
    System.out.println("tribonacci(" + n + ") = " + tribonacci(n));

  }
}