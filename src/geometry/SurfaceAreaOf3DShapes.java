package geometry;
import java.util.Arrays;

public class SurfaceAreaOf3DShapes
{
  public static int surfaceArea(int[][] grid)
  {
    int n = grid.length;
    int sum = 0;
    if (n == 1) {
      if (grid[0][0] == 0) {
        return 0;
      } else {
        return 2 + grid[0][0] * 4;
      }
    }
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] > 0) {
          sum += 2;    // up / down
        }
        if (r == 0) {
          sum += grid[r][c];
          if (c == 0) {
            sum += grid[r][c];
            if (grid[r][c] > grid[r][c+1])
              sum += grid[r][c] - grid[r][c+1];

            if (grid[r][c] > grid[r+1][c])
              sum += grid[r][c] - grid[r+1][c];

          } else if (c == n-1) {
            sum += grid[r][c];
            if (grid[r][c] > grid[r][c-1])
              sum += grid[r][c] - grid[r][c-1];

            if (grid[r][c] > grid[r+1][c])
              sum += grid[r][c] - grid[r+1][c];

          } else {
            if (grid[r][c] > grid[r][c-1])
              sum += grid[r][c] - grid[r][c-1];

            if (grid[r][c] > grid[r][c+1])
              sum += grid[r][c] - grid[r][c+1];

            if (grid[r][c] > grid[r+1][c])
              sum += grid[r][c] - grid[r+1][c];
          }

      } else if (r == n-1) {
          sum += grid[r][c];
          if (c == 0) {
            sum += grid[r][c];
            if (grid[r][c] > grid[r][c+1]) {
              sum += grid[r][c] - grid[r][c+1];
            }

            if (grid[r][c] > grid[r-1][c]) {
              sum += grid[r][c] - grid[r-1][c];
            }

          } else if (c == n-1) {
            sum += grid[r][c];
            if (grid[r][c] > grid[r][c-1]) {
              sum += grid[r][c] - grid[r][c-1];
            }
            if (grid[r][c] > grid[r-1][c]) {
              sum += grid[r][c] - grid[r-1][c];
            }
          }
          else {
            if (grid[r][c] > grid[r][c-1]) {
              sum += grid[r][c] - grid[r][c-1];
            }

            if (grid[r][c] > grid[r][c+1]) {
              sum += grid[r][c] - grid[r][c+1];
            }

            if (grid[r][c] > grid[r-1][c]) {
              sum += grid[r][c] - grid[r-1][c];
            }
          }

      } else {
        if (c == 0) {
          sum += grid[r][c];
          if (grid[r][c] > grid[r][c+1])
            sum += grid[r][c] - grid[r][c+1];

          if (grid[r][c] > grid[r-1][c])
            sum += grid[r][c] - grid[r-1][c];

          if (grid[r][c] > grid[r+1][c])
            sum += grid[r][c] - grid[r+1][c];

        } else if (c == n-1) {
          sum += grid[r][c];
          if (grid[r][c] > grid[r][c-1])
            sum += grid[r][c] - grid[r][c-1];

          if (grid[r][c] > grid[r-1][c])
            sum += grid[r][c] - grid[r-1][c];

          if (grid[r][c] > grid[r+1][c])
            sum += grid[r][c] - grid[r+1][c];

        } else {
          if (grid[r][c] > grid[r][c+1])
            sum += grid[r][c] - grid[r][c+1];

          if (grid[r][c] > grid[r][c-1])
            sum += grid[r][c] - grid[r][c-1];

          if (grid[r][c] > grid[r-1][c])
            sum += grid[r][c] - grid[r-1][c];

          if (grid[r][c] > grid[r+1][c])
            sum += grid[r][c] - grid[r+1][c];

          }
        }
      }
    }

    return sum;
  }

  public static int surfaceAreaOpt(int[][] grid) 
  {
    int result = 0;
    for (int i = 0; i < grid.length; i++)    
      for (int j = 0; j < grid[0].length; j++)    
        result += getArea(grid, i, j);
    return result;
  }
  private static int getArea(int[][] grid, int i, int j) 
  {
    int towerHeight = grid[i][j];
    if (towerHeight == 0)    
      return 0;
    int area = 2 + (towerHeight * 4);

    if (i > 0)    
      area -= Math.min(towerHeight, grid[i - 1][j]);
    
    if (i < grid.length - 1)    
      area -= Math.min(towerHeight, grid[i + 1][j]);
    
    if (j > 0)    
      area -= Math.min(towerHeight, grid[i][j - 1]);
    
    if (j < grid[0].length - 1)    
      area -= Math.min(towerHeight, grid[i][j + 1]);
    
    return area;
  }


  public static void readme()
  {
    String str = "You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).\n\n";
    str += "After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.\n\n";
    
    str += "Return the total surface area of the resulting shapes.\n\n";
    
    str += "Note: The bottom face of each shape counts toward its surface area.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SurfaceAreaOf3DShapes.readme();

    // grid = [[1,2],[3,4]] => 34
    int [][] grid1 = {{1,2},{3,4}};
    System.out.println("surfaceArea(" + Arrays.deepToString(grid1) +
                       ") = " +  surfaceArea(grid1));

    // grid = [[1,1,1],[1,0,1],[1,1,1]] => 32
    int [][] grid2 = {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println("surfaceArea(" + Arrays.deepToString(grid2) +
                       ") = " + surfaceArea(grid2));

    // grid = [[2,2,2],[2,1,2],[2,2,2]] => 46
    int [][] grid3 = {{2,2,2},{2,1,2},{2,2,2}};
    System.out.println("surfaceArea(" + Arrays.deepToString(grid3) +
                       ") = " +  surfaceArea(grid3));

    System.out.println("surfaceAreaOpt(" + Arrays.deepToString(grid3) +
                       ") = " + surfaceAreaOpt(grid3));

  }
}