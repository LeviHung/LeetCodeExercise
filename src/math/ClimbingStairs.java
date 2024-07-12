package math;
import java.util.HashMap;

public class ClimbingStairs
{
  private static final HashMap<Integer, Integer> cache = new HashMap<>();
  public static int climbStairs(int n) 
  {    
    if (cache.containsKey(n)) {
      return cache.get(n);
    }

    // n = 2 => 11, 2
    // n = 3 => 111, 12, 21
    // n = 4 => 1111, 112, 121, 211, 22,
    // n = 5 => 11111, 1112, 1121, 1211, 2111, 122, 212, 221, 
    if (n <= 2) {
      return n;
    }

    cache.put(n, climbStairs(n - 1) + climbStairs (n - 2));

    return cache.get(n);
  }

  public static void readme()
  {
    String str = "You are climbing a staircase. It takes n steps to reach the top.\n\n";

    str += "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?\n";

    System.out.println(str);
  }

  public static void main()
  {
    ClimbingStairs.readme();
    int n = 2;
    // n = 2 => 2
    System.out.println("climbStairs(" + n + ") = " + 
                       ClimbingStairs.climbStairs(n));

    n = 3;
    // n = 3 => 3
    System.out.println("climbStairs(" + n + ") = " +       
                       ClimbingStairs.climbStairs(n));

    n = 45;
    // n = 3 => 3
    System.out.println("climbStairs(" + n + ") = " +       
                       ClimbingStairs.climbStairs(n));
  }
}