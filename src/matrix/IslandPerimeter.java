package matrix;
import java.util.Arrays;

public class IslandPerimeter
{
  public static int islandPerimeter(int[][] grid)
  {
    // [0,1,0,0],
    // [1,1,1,0],
    // [0,1,0,0],
    // [1,1,0,0]
    int count = 0;
    int cross = 0;
    int lenX = grid[0].length;
    int lenY = grid.length;
    for (int y = 0; y < lenY; y++) {
      for (int x = 0; x < lenX; x++) {
        if (grid[y][x] == 1) {
          //System.out.println("x = " + x + ", y = " + y);
          count += 4;
          if (x > 0) {
            if (grid[y][x-1] == 1) {
              cross += 2;
            }
          }  
          
          if (y > 0) {
            if (grid[y-1][x] == 1) {
              cross += 2;
            }
          } 
        }
      }
    }
    
    //System.out.println("count = " + count + ", cross = " + cross);
    return count - cross;
  }

  public static int islandPerimeterOpt(int[][] grid) 
  {
      int n = grid.length;
      int m = grid[0].length;

      int peri = 0;
      int up = 0, down = 0, left = 0, right = 0;
      for(int i =0; i<n; i++){
          for(int j =0; j<m; j++){
              if(grid[i][j] == 1){
                  peri += 4;

                  if(i == 0) up = 0;
                  else up = grid[i-1][j];

                  if(j == 0) left = 0;
                  else left = grid[i][j-1];

                  peri -= ((2*up) + (2*left));
              }
          }
      }
      return peri;
  }

  public static void readme()
  {
    String str = "You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.\n\n";

    str += "Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).\n\n";

    str += "The island doesn't have \"lakes\", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    IslandPerimeter.readme();

    // grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] => 16
    int [][] grid1 = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

    System.out.println("islandPerimeter(" + Arrays.deepToString(grid1) + ") = " +
                       islandPerimeter(grid1));

    // grid = [[1]] => 4
    int [][] grid2 = {{1}};
    System.out.println("islandPerimeter(" + Arrays.deepToString(grid2) + ") = " +
     islandPerimeter(grid2));

    // grid = [[1,0]] => 4
    int [][] grid3 = {{1,0}};
    System.out.println("islandPerimeter(" + Arrays.deepToString(grid3) + ") = " +
     islandPerimeter(grid3));

  }
}