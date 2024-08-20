package math;
import java.util.Arrays;

public class CellsWithOddValuesInAMatrix
{
  public static int oddCells(int m, int n, int[][] indices) {
      int[] row = new int [m];
      int[] col = new int [n];
      for (int i = 0; i < indices.length; i++) {
          row[indices[i][0]]++;
          col[indices[i][1]]++;
      }

      int oddNumR = 0;
      for (int r = 0; r < m; r++) {
          if (row[r] % 2 == 1) {
              oddNumR++;
          }
      }
      int oddNumC = 0;
      for (int c = 0; c < n; c++) {
          if (col[c] % 2 == 1) {
              oddNumC++;
          }
      }
      //System.out.println("oddNumR = " + oddNumR + ", oddNumC = " + oddNumC);

      return (m - oddNumR) * oddNumC + (n - oddNumC) * oddNumR; 
  }

  public static void readme()
  {
    String str = "There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.\n\n";

    str += "For each location indices[i], do both of the following:\n\n";

    str += "Increment all the cells on row ri.\n\n";

    str += "Increment all the cells on column ci.\n\n";
    str += "Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CellsWithOddValuesInAMatrix.readme();

    int m;
    int n;
    // Input: m = 2, n = 3, indices = [[0,1],[1,1]]
    // Output: 6
    m = 2;
    n = 3;
    int [][] indices1 = {{0,1},{1,1}};

    System.out.println("oddCells(" + m + ", " + n + ", " + Arrays.deepToString(indices1) + ") = " +
                       oddCells(m, n, indices1));
    // Input: m = 2, n = 2, indices = [[1,1],[0,0]]
    // Output: 0

    m = 2;
    n = 2;
    int [][] indices2 = {{1,1},{0,0}};

    System.out.println("oddCells(" + m + ", " + n + ", " + Arrays.deepToString(indices2) + ") = " +
                       oddCells(m, n, indices2));

  }

}