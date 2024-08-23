package matrix;
import java.util.Arrays;

public class CountNegativeNumberInASortedMatrix
{
    public static int countNegatives(int[][] grid) {
        int res = 0;
        int row = 0;
        for (int r = grid.length - 1; r >= 0; r--) {
            row = 0;
            for (int c = grid[0].length - 1; c >= 0; c--) {
                if (grid[r][c] < 0) {
                    res++;
                    row++;
                } else {
                    break;
                }
            }
            if (row == 0) { 
                return res;
            }
        }
        return res;
    }

    public static int countNegativesOpt(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = m - 1, j = 0; i >= 0 && j < n;) {
            if (grid[i][j] < 0) {
                ans += n - j;
                --i;
            } else {
                ++j;
            }
        }
        return ans;
    }

  public static void readme()
  {
    String str = "Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CountNegativeNumberInASortedMatrix.readme();

    // Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    // Output: 8


    int[][] grid1 = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
    System.out.println("countNegatives(" + Arrays.deepToString(grid1) + ") = " +
                       countNegatives(grid1));
      
    // Input: grid = [[3,2],[1,0]]
    // Output: 0
    int[][] grid2 = {{3,2},{1,0}};
      System.out.println("countNegatives(" + Arrays.deepToString(grid2) + ") = " +
                         countNegatives(grid2));

      System.out.println("countNegativesOpt(" + Arrays.deepToString(grid2) + ") = " +
                         countNegativesOpt(grid2));

  }
}