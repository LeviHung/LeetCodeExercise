package matrix;
import java.util.Arrays;

public class TransposeMatrix
{
  public static int[][] transpose(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] res = new int [m][n];
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < m; c++) {
            res[c][r] = matrix[r][c];
        }
    }
    return res;
  }

  public static void readme()
  {
    String str = "Given a 2D integer array matrix, return the transpose of matrix.\n\n";

    str += "The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.\n";

    System.out.println(str);
  }

  public static void main()
  {
    TransposeMatrix.readme();

    // matrix = [[1,2,3],[4,5,6],[7,8,9]] => [[1,4,7],[2,5,8],[3,6,9]]
    int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};    
    System.out.println("transpose(" + Arrays.deepToString(matrix1) + ") = " +
                       Arrays.deepToString(transpose(matrix1)));
    System.out.println("");
    
    // matrix = [[1,2,3],[4,5,6]] => [[1,4],[2,5],[3,6]]
    int[][] matrix2 = {{1,2,3}, {4,5,6}};    
    System.out.println("transpose(" + Arrays.deepToString(matrix2) + ") = " +
                       Arrays.deepToString(transpose(matrix2)));


  }
}