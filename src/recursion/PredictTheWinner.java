package recursion;

import java.util.Arrays;

public class PredictTheWinner
{
  public static boolean predictTheWinner(int[] nums) {
    return predict(nums, 0, nums.length - 1, 0, true);
  }

  public static boolean predict(int[] nums, int start, int end, int point, boolean isA) {
    if (start == end) {
        if (isA == true) {
            if (point + nums[start] >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (point >= nums[start]) {
                return true;
            } else {
                return false;
            }
        }
    }

    if (isA == true) {
        return predict(nums, start + 1, end, point + nums[start], !isA) ||
               predict(nums, start, end - 1, point + nums[end], !isA);

    } else {
        return predict(nums, start + 1, end, point - nums[start], !isA) && 
               predict(nums, start, end - 1, point - nums[end], !isA);
    }
  }

  public static boolean predictTheWinnerOpt(int[] nums) {
    int n = nums.length;
    int[][] f = new int[n][n];
    for (int i = 0; i < n; ++i) {
        f[i][i] = nums[i];
    }
    for (int i = n - 2; i >= 0; --i) {
        for (int j = i + 1; j < n; ++j) {
            f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
        }
    }
    return f[0][n - 1] >= 0;
  }

  public static void readme()
  {
    String str = "You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.\n\n";

    str += "Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.\n\n";

    str += "Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.\n";

    System.out.println(str);
  }

  public static void main()
  {
    PredictTheWinner.readme();

    // Input: nums = [1,5,2]
    // Output: false

    int[] nums1 = {1,5,2};
    System.out.println("predictTheWinner(" + 
                       Arrays.toString(nums1) + ") = " +
                       predictTheWinner(nums1));

    // Input: nums = [1,5,233,7]
    // Output: true

    int[] nums2 = {1,5,233,7};
    System.out.println("predictTheWinner(" + 
                       Arrays.toString(nums2) + ") = " + 
                       predictTheWinner(nums2));

    System.out.println("predictTheWinnerOpt(" + 
       Arrays.toString(nums2) + ") = " + 
       predictTheWinnerOpt(nums2));

  }
}