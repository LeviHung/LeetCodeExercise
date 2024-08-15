package matrix;
import java.util.Arrays;

public class MatrixCellsInDistanceOrder
{
  public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter)
  {
    int [][] map = new int [rows+cols][(rows+cols)*2];
    int [] size = new int[(rows+cols)*2];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int dist = Math.abs(rCenter - r) + Math.abs(cCenter - c);
        map[dist][size[dist]] = r;
        map[dist][size[dist] + 1] = c;
        size[dist] = size[dist] + 2;
      }
    }

    int [][] res = new int [rows * cols][2];
    int total = rows * cols;
    int index = 0;
    int dist = 0;
    while (index < total) {
      if (size[dist] == 0) {
        dist++;
        continue;
      }

      res[index][0] = map[dist][size[dist]-2];
      res[index][1] = map[dist][size[dist]-1];
      index++;
      size[dist] = size[dist] - 2;
    }

    return res;
  }

  public static int[][] allCellsDistOrderOpt(int R, int C, int r0, int c0) 
  {
      int[][] result = new int[R * C][];
      result[0] = new int[] {r0, c0};            // Add start point r0,c0 which has distance 0.
      int resultIdx = 1;
      int lim = Math.max( r0, R-r0-1 ) + Math.max( c0, C-c0-1 );
                                             // lim is highest distance value.
      for (int dist = 1; dist <= lim; dist++) {  // Process 'lim' diamond-shapes having distance 'dist'.
          int r = r0 - dist;
          int c = c0;
          // Diamond side: Top Left
          for (int count = dist; count > 0; count--) {    
              if (r >= 0 && c >= 0)  result[resultIdx++] = new int[] {r, c};
              r++;
              c--;
          }

          // Diamond side: Left Bottom
          for (int count = dist; count > 0; count--) {
              if (r < R && c >= 0)  result[resultIdx++] = new int[] {r, c};
              r++;
              c++;
          }

          // Diamond side: Bottom Right
          for (int count = dist; count > 0; count--) {
              if (r < R && c < C)  result[resultIdx++] = new int[] {r, c};
              r--;
              c++;
          }

          // Diamond side: Right Top
          for (int count = dist; count > 0; count--) {
              if (r >= 0 && c < C)  result[resultIdx++] = new int[] {r, c};
              r--;
              c--;
          }
      }
      return result;
  }
  public static void readme()
  {
    String str = "You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).\n\n";

    str += "Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.\n\n";


    str += "The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MatrixCellsInDistanceOrder.readme();
    int rows;
    int cols;
    int rCenter;
    int cCenter;

    // rows = 1, cols = 2, rCenter = 0, cCenter = 0
    // => [[0,0],[0,1]]
    rows = 1;
    cols = 2;
    rCenter = 0;
    cCenter = 0;
    System.out.println("allCellsDistOrder(" + rows + ", " +
                       cols + ", " + rCenter + ", " + cCenter + ") = " +
                       Arrays.deepToString(allCellsDistOrder(rows, cols, rCenter, cCenter)));

    // rows = 2, cols = 2, rCenter = 0, cCenter = 1
    // => [[0,1],[0,0],[1,1],[1,0]]
    rows = 2;
    cols = 2;
    rCenter = 0;
    cCenter = 1;
    System.out.println("allCellsDistOrder(" + rows + ", " +
                       cols + ", " + rCenter + ", " + cCenter + ") = " +
                       Arrays.deepToString(allCellsDistOrder(rows, cols, rCenter, cCenter)));

    
    // rows = 2, cols = 3, rCenter = 1, cCenter = 2
    // => [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
    rows = 2;
    cols = 3;
    rCenter = 1;
    cCenter = 2;
    System.out.println("allCellsDistOrder(" + rows + ", " +
                       cols + ", " + rCenter + ", " + cCenter + ") = " +
                       Arrays.deepToString(allCellsDistOrder(rows, cols, rCenter, cCenter)));

    System.out.println("allCellsDistOrderOpt(" + rows + ", " +
       cols + ", " + rCenter + ", " + cCenter + ") = " +
       Arrays.deepToString(allCellsDistOrderOpt(rows, cols, rCenter, cCenter)));

  }
}