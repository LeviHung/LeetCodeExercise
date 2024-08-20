package matrix;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ShiftTwoDGrid
{
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int [] tmp = new int [grid.length * grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                tmp[r * grid[0].length + c] = grid[r][c];
            }
        }
        //System.out.println("tmp = " + Arrays.toString(tmp));
        int[][] res = new int[grid.length][grid[0].length];
        k = k % (grid.length * grid[0].length);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int index = r * grid[0].length + c;
                if (index < k) {
                    index += grid.length * grid[0].length;
                }
                res[r][c] = tmp[index - k];
            }
        } 

        //return (List)Arrays.asList(res);
        
        List <List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < res[0].length; j++) {
                subList.add(res[i][j]);
            }
            list.add(subList);
        }
        return list;
    }

  public static void readme()
  {
    String str = "Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.\n\n";

    str += "In one shift operation:\n\n";
      
    str += "Element at grid[i][j] moves to grid[i][j + 1].\n\n";

    str += "Element at grid[i][n - 1] moves to grid[i + 1][0].\n\n";

    str += "Element at grid[m - 1][n - 1] moves to grid[0][0].\n\n";

    str += "Return the 2D grid after applying shift operation k times.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ShiftTwoDGrid.readme();
    int k;
      
    // Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
    // Output: [[9,1,2],[3,4,5],[6,7,8]]
    int[][] grid1 = {{1,2,3},{4,5,6},{7,8,9}};
    k = 1;
    System.out.println("shiftGrid(" + Arrays.deepToString(grid1) + ", " + k + ") = ");
    List<List<Integer>> list1 = shiftGrid(grid1, k);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
    // Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
    int[][] grid2 = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
    k = 4;
    System.out.println("shiftGrid(" + Arrays.deepToString(grid2) + ", " + k + ") = ");
    List<List<Integer>> list2 = shiftGrid(grid2, k);
    System.out.println(Arrays.toString(list2.toArray()));

    // Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
    // Output: [[1,2,3],[4,5,6],[7,8,9]]
    int[][] grid3 = {{1,2,3},{4,5,6},{7,8,9}};
    k = 9;
    System.out.println("shiftGrid(" + Arrays.deepToString(grid3) + ", " + k + ") = ");
    List<List<Integer>> list3 = shiftGrid(grid3, k);
    System.out.println(Arrays.toString(list3.toArray()));
    }
}