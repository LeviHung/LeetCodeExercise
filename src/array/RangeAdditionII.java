package array;
import java.util.Arrays;

public class RangeAdditionII
{
  public static int maxCount(int m, int n, int[][] ops)
  {
    if (ops.length == 0) {
      return m * n;
    }
    int r;
    int c;
    int maxR = 0;
    int maxC = 0;
    int minR = Integer.MAX_VALUE;
    int minC = Integer.MAX_VALUE;
    for (int i = 0; i < ops.length; i++) {
      if (ops[i][0] > maxR) {
        maxR = ops[i][0];
      }
      
      if (ops[i][1] > maxC) {
        maxC = ops[i][1];
      }

      if (ops[i][0] < minR) {
        minR = ops[i][0];
      }

      if (ops[i][1] < minC) {
        minC = ops[i][1];
      }
    }

    return minR * minC;
    /*
    int []array = new int [maxR * maxC];
    for (int i = 0; i < ops.length; i++) {
      r = 0;
      c = 0;
      while (r < ops[i][0]) {
        while (c < ops[i][1]) {
          array[r * m + c]++;
          c++;
        }
        c = 0;
        r++;
      }
    }
    int res = 1;

    for (int i = 1; i < array.length; i++) {
      if (array[i] == array[0]) {
        res++;
      }
    }
    //System.out.println(Arrays.toString(array));
    return res;
    */
  }


  public static void readme()
  {
    String str = "You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.\n\n";

    str += "Count and return the number of maximum integers in the matrix after performing all the operations.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RangeAdditionII.readme();
    int m;
    int n;
    // m = 3, n = 3, ops = [[2,2],[3,3]] => 4
    int [][] ops1 = {{2,2},{3,3}};
    m = 3;
    n = 3;
    System.out.println("maxCount(" + m + ", " + n + ", " +
                       Arrays.deepToString(ops1) + ") = " +
                       maxCount(m, n, ops1));

    // m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]] => 4
    int [][] ops2 = {{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}};
    m = 3;
    n = 3;
    System.out.println("maxCount(" + m + ", " + n + ", " +
                        Arrays.deepToString(ops2) + ") = " +
                       maxCount(m, n, ops2));

    // m = 3, n = 3, ops = [] => 9
    int [][] ops3 = {};
    m = 3;
    n = 3;
    System.out.println("maxCount(" + m + ", " + n + ", " +
                       Arrays.deepToString(ops3) + ") = " +
                       maxCount(m, n, ops3));
                  
  }
}