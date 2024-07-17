package math;

import java.util.HashMap;

public class ArrangingCoins
{
  static HashMap <Integer, Integer> cache;
  public static int arrangeCoins(int n) 
  {
    cache = new HashMap<>();
    int l = 1;
    int r = n / 2 + 1;
    if (r > 65535) {
      r = 65535;
    }
    int m = l + (r - l) / 2;
    while (l < r) {
      //System.out.println("m = " + m + ", l = " + l + ", r = " + r);
      //System.out.println("stepCoins(m) = " +stepCoins(m));
      if (stepCoins(m) == n) {
        return m;
      }
      if (stepCoins(m) > n) {
        r = m - 1;
        m = l + (r - l) / 2;
      } else {  // m < stepCoins(n)
        l = m + 1;
        m = l + (r - l) / 2;
      }
    }
    //System.out.println("m = " + m + ", l = " + l + ", r = " + r);
    if (stepCoins(m) > n)
      m--;
    
    return m;
  }

  public static int stepCoins(int n) {
    return (int) ((double) (1 + n) * (double) n / (double) 2);
  }

  public int arrangeCoinsOpt(int n) 
  {
    double kt = 2.0 * n + 0.25;
    return (int)(Math.sqrt(kt) - 0.5);
  }

  public static void readme()
  {
    String str = "You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.\n\n";

    str += "Given the integer n, return the number of complete rows of the staircase you will build.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ArrangingCoins.readme();
    int n;
    // n = 5 => 2
    n = 5;
    System.out.println("arrangeCoins(" + n + ") = " + arrangeCoins(n));

    // n = 8 => 3
    n = 8;
    System.out.println("arrangeCoins(" + n + ") = " + arrangeCoins(n));

    n = 3;
    System.out.println("arrangeCoins(" + n + ") = " + arrangeCoins(n));

    n = 2147483647;
    System.out.println("arrangeCoins(" + n + ") = " + arrangeCoins(n));

  }
}