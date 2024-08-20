package math;

import java.util.Arrays;

public class MinimumCostToMoveChips
{
  public static int minCostToMoveChips(int[] position) {
      int res = 0;
      int oddCnt = 0;
      int evenCnt = 0;
      for (int i = 0; i < position.length; i++) {
          if (position[i] % 2 == 0) {
              evenCnt++;
          } else {
              oddCnt++;
          }
      }
      if (oddCnt > evenCnt) {
          res = evenCnt;
      } else {
          res = oddCnt;
      }

      return res;
  }

  public static void readme()
  {
    String str = "We have n chips, where the position of the ith chip is position[i].\n\n";

    str += "We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:\n\n";

    str += "position[i] + 2 or position[i] - 2 with cost = 0.\n\n";

    str += "position[i] + 1 or position[i] - 1 with cost = 1.\n\n";

    str += "Return the minimum cost needed to move all the chips to the same position.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumCostToMoveChips.readme();

    // Input: position = [1,2,3]
    // Output: 1
    int[] position1 = {1,2,3};
    System.out.println("minCostToMoveChips(" + Arrays.toString(position1) + ") = " + 
                       minCostToMoveChips(position1));

    // Input: position = [2,2,2,3,3]
    // Output: 2
    int[] position2 = {2,2,2,3,3};
    System.out.println("minCostToMoveChips(" + Arrays.toString(position2) + ") = " + 
                       minCostToMoveChips(position2));

    // Input: position = [1,1000000000]
    // Output: 1

    int[] position3 = {1,1000000000};
    System.out.println("minCostToMoveChips(" + Arrays.toString(position3) + ") = " + 
                       minCostToMoveChips(position3));

  }
}