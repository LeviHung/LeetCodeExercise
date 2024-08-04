package matrix;
import java.util.Arrays;

public class ReshapeMatrix
{
  public static int[][] matrixReshape(int[][] mat, int r, int c)
  {
    int indexX = 0;
    int indexY = 0;
    int lenX = mat[0].length;
    int lenY = mat.length;
    if (lenX * lenY != r * c) {
      return mat;
    }

    int [][] res = new int[r][c];

    for (int indexR = 0; indexR < r; indexR++) {
      for (int indexC = 0; indexC < c; indexC++) {
        res[indexR][indexC] = mat[indexY][indexX];
        indexX++;
        if (indexX >= lenX) {
          indexX = 0;
          indexY++;
        }
      }
    }

    return res;
  }


  public static void readme()
  {
    String str = "In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.\n\n";

    str += "You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.\n\n";

    str += "The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.\n\n";

    str += "If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ReshapeMatrix.readme();
    int r;
    int c;
    // mat = [[1,2],[3,4]], r = 1, c = 4 => [[1,2,3,4]]
    int [][] mat1 = {{1,2},{3,4}};
    r = 1;
    c = 4;
    System.out.println("matrixReshape(" + Arrays.deepToString(mat1) + ", " +
                       r + ", " + c + ") = " +
                       Arrays.deepToString(matrixReshape(mat1, r, c)));

    // mat = [[1,2],[3,4]], r = 2, c = 4 => [[1,2,3,4]]
    int [][] mat2 = {{1,2},{3,4}};
    r = 2;
    c = 4;
    System.out.println("matrixReshape(" + Arrays.deepToString(mat2) + ", " +
                       r + ", " + c + ") = " +
                       Arrays.deepToString(matrixReshape(mat2, r, c)));

    // [[1,2,3,4]], r = 2, c = 2 => 
    int [][] mat3 = {{1,2,3,4}};
    r = 2;
    c = 2;
    System.out.println("matrixReshape(" + Arrays.deepToString(mat3) + ", " +
                       r + ", " + c + ") = " +
                       Arrays.deepToString(matrixReshape(mat3, r, c)));

  }
}