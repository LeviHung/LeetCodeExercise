package matrix;
import java.util.Arrays;

public class ToeplitzMatrix
{
  public static boolean isToeplitzMatrix(int[][] matrix)
  {
    for (int r = 1; r < matrix.length; r++ ) {
      for (int c = 1; c < matrix[0].length; c++) {
        if (matrix[r][c] != matrix[r-1][c-1]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void readme()
  {
    String str = "Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.\n\n";

    str += "A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ToeplitzMatrix.readme();

    // matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]] => true
    int [][] matrix1 = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
    System.out.println("isToeplitzMatrix(" + Arrays.deepToString(matrix1) + ") = " +
                       isToeplitzMatrix(matrix1));

    // matrix = [[1,2],[2,2]] => false
    int [][] matrix2 = {{1,2},{2,2}};
    System.out.println("isToeplitzMatrix(" + Arrays.deepToString(matrix2) + ") = " +
                       isToeplitzMatrix(matrix2));

  }
}