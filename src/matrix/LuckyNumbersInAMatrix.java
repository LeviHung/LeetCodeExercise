package matrix;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LuckyNumbersInAMatrix
{
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List <Integer> list = new ArrayList<>();

        int minR = Integer.MAX_VALUE;
        int minRIndex = 0;

        for (int r = 0; r < matrix.length; r++) {
            minRIndex = getMinRowIndex(matrix[r]);

            //if (matrix[r][minRIndex] == getMaxCol(matrix, minRIndex)) {
            if (isMaxCol(matrix, r, minRIndex)) {
                list.add(matrix[r][minRIndex]);
            }
        }

        return list;

        /*
        int minR = Integer.MAX_VALUE;
        int minRIndex = 0;
        int [] maxC = new int [matrix[0].length];

        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                maxC[c] = Math.max(matrix[r][c], maxC[c]);
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            minR = Integer.MAX_VALUE;
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] < minR) {
                    minR = matrix[r][c];
                    minRIndex = c;
                }
            }
            if (minR == maxC[minRIndex]) {
                list.add(matrix[r][minRIndex]);
            }
        }

        return list;
        */

        /*
        int [] minR = new int [matrix.length];
        int [] maxC = new int [matrix[0].length];
        Arrays.fill(minR, 100001);
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                minR[r] = Math.min(matrix[r][c], minR[r]);
            }
        }

        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                maxC[c] = Math.max(matrix[r][c], maxC[c]);
            }
        }
        //System.out.println(Arrays.toString(minR));
        //System.out.println(Arrays.toString(maxC));

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == minR[r] && matrix[r][c] == maxC[c]) {
                    list.add(matrix[r][c]);
                }
            }
        }
        return list;
        */
    }
    static int getMinRowIndex(int[] array) {
        int minR = Integer.MAX_VALUE;
        int index = 0;
        for (int c = 0; c < array.length; c++) {
            if (array[c] < minR) {
                minR = array[c];
                index = c;
            }
        }
        return index;
    }

    static boolean isMaxCol(int[][] matrix, int r, int indexC) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[r][indexC] < matrix[i][indexC]) {
                return false;
            }
        }
        return true;
    }

    static int getMaxCol(int[][] matrix, int col) {
        int maxC = 0;
        for (int r = 0; r < matrix.length; r++) {
            maxC = Math.max(matrix[r][col], maxC);
        }
        return maxC;
    }

  public static void readme()
  {
    String str = "Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.\n\n";

    str += "A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LuckyNumbersInAMatrix.readme();

    // Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
    // Output: [15]
    int[][] matrix1 = {{3,7,8},{9,11,13},{15,16,17}};
    System.out.println("luckyNumbers(" +
                       Arrays.deepToString(matrix1) + ") = ");
    List<Integer> list1 = luckyNumbers(matrix1);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    // Output: [12]
    int[][] matrix2 = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
    System.out.println("luckyNumbers(" +
                        Arrays.deepToString(matrix2) + ") = ");
    List<Integer> list2 = luckyNumbers(matrix2);
    System.out.println(Arrays.toString(list2.toArray()));

    // Input: matrix = [[7,8],[1,2]]
    // Output: [7]
    int[][] matrix3 = {{7,8},{1,2}};
    System.out.println("luckyNumbers(" +
                          Arrays.deepToString(matrix3) + ") = ");
    List<Integer> list3 = luckyNumbers(matrix3);
    System.out.println(Arrays.toString(list3.toArray()));
    
  }
}