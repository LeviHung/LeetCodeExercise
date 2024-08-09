package geometry;
import java.util.Arrays;

public class ProjectionAreaOf3DShapes
{
  public static int projectionArea(int[][] grid)
  {

    int sumXY = 0;
    int sumXZ = 0;
    int sumYZ = 0;
    int maxXZ = 0;
    int maxYZ = 0;

    for (int r = 0; r < grid.length; r++) {
        maxXZ = 0;
        maxYZ = 0;
        for (int c = 0; c < grid[0].length; c++) {
            if (grid[r][c] > 0) {
                sumXY++;
            }
            maxXZ = Math.max(grid[r][c], maxXZ);
            maxYZ = Math.max(grid[c][r], maxYZ);
        }
        sumXZ += maxXZ;
        sumYZ += maxYZ;
    }

    return sumXY + sumXZ + sumYZ;
  }

  
  public static void readme()
  {
    String str = "You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.\n\n";

    str += "Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).\n\n";
    str += "We view the projection of these cubes onto the xy, yz, and zx planes.\n\n";
    str += "A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the \"shadow\" when looking at the cubes from the top, the front, and the side.\n\n";
    str += "Return the total area of all three projections.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ProjectionAreaOf3DShapes.readme();

    // grid = [[1,2],[3,4]] => 17
    int [][] grid1 = {{1,2},{3,4}};
    System.out.println("projectionArea(" + Arrays.deepToString(grid1) +
                       ") = " +
                       projectionArea(grid1));

    // grid = [[2]] => 5
    int [][] grid2 = {{2}};
    System.out.println("projectionArea(" + Arrays.deepToString(grid2) +
                       ") = " +
                       projectionArea(grid2));

    // grid = [[1,0],[0,2]] => 8
    int [][] grid3 = {{1,0},{0,2}};
    System.out.println("projectionArea(" + Arrays.deepToString(grid3) +
                       ") = " +
                       projectionArea(grid3));

  }
}