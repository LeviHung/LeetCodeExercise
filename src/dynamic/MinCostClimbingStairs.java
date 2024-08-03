package dynamic;
import java.util.Arrays;

public class MinCostClimbingStairs
{
  public static int minCostClimbingStairs(int[] cost)
  {
    // [10,15,20]
    // [1,100,1,1,1,100,1,1,100,1]
    /*
    Build an array dp where dp[i] is the minimum cost to climb to the top     starting from the ith staircase.

    Assuming we have n staircase labeled from 0 to n - 1 and assuming the top is   n, then dp[n] = 0, marking that if you are at the top, the cost is 0.
    
    Now, looping from n - 1 to 0, the dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]). The answer will be the minimum of dp[0] and dp[1]
    */
    int n = cost.length;
    int [] dp = new int [n + 1];
    dp[n] = 0;
    dp[n-1] = cost[n-1];
    for (int i = n - 2; i >= 0; i--) {
      dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
    }
    return Math.min(dp[0] , dp[1]);
  }

  public static void readme()
  {
    String str = "You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.\n\n";

    str += "You can either start from the step with index 0, or the step with index 1.\n\n";

    str += "Return the minimum cost to reach the top of the floor.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinCostClimbingStairs.readme();

    // cost = [10,15,20] => 15
    int [] cost1 = {10,15,20};
    System.out.println("minCostClimbingStairs(" + Arrays.toString(cost1) + ") = " +
                       minCostClimbingStairs(cost1));

    // cost = [1,100,1,1,1,100,1,1,100,1] => 6
    int [] cost2 = {1,100,1,1,1,100,1,1,100,1};
    System.out.println("minCostClimbingStairs(" + Arrays.toString(cost2) + ") = " +
                       minCostClimbingStairs(cost2));

  }
}