package matrix;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructATwoRowBinaryMatrix
{
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        Integer[] arrayUp = new Integer [colsum.length];
        Integer[] arrayLow = new Integer [colsum.length];

        int total = 0;
        int both = 0;
        for (int col: colsum) {
            total += col;
            if (col == 2) {
                both++;
            }
        }
        if (total != (upper + lower)) {
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }
        upper = upper - both;
        lower = lower - both;
        if (upper < 0 || lower < 0) {
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                arrayUp[i] = 1;
                arrayLow[i] = 1;
            } else if (colsum[i] == 1) {
                if (upper > 0) {
                    upper--;
                    arrayUp[i] = 1;
                    arrayLow[i] = 0;
                } else {
                    lower--;
                    arrayUp[i] = 0;
                    arrayLow[i] = 1;
                }
            } else {
                arrayUp[i] = 0;
                arrayLow[i] = 0;
            }
        }
        //return new ArrayList(Arrays.asList(arrayUp,arrayLow));

        //System.out.println(Arrays.toString(arrayUp) + Arrays.toString(arrayLow));
        
        List<Integer> listUp = Arrays.asList(arrayUp);
        List<Integer> listLow = Arrays.asList(arrayLow);
        List<List<Integer>> res = new ArrayList<>();
        res.add(listUp);
        res.add(listLow);

        return res;
        
    }

    // Mark it for unchecked or unsafe operations
    /*
    public List<List<Integer>> reconstructMatrixOpt(int upper, int lower, int[] colsum) {
        int[] arrayUp = new int [colsum.length];
        int[] arrayLow = new int [colsum.length];

        int total = 0;
        int both = 0;
        for (int col: colsum) {
            total += col;
            if (col == 2) {
                both++;
            }
        }
        if (total != (upper + lower)) {
            return new ArrayList<>();
        }
        upper = upper - both;
        lower = lower - both;
        if (upper < 0 || lower < 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                arrayUp[i] = 1;
                arrayLow[i] = 1;
            } else if (colsum[i] == 1) {
                if (upper > 0) {
                    upper--;
                    arrayUp[i] = 1;
                    arrayLow[i] = 0;
                } else {
                    lower--;
                    arrayUp[i] = 0;
                    arrayLow[i] = 1;
                }
            }
        }
        return new ArrayList(Arrays.asList(arrayUp,arrayLow));
    }
    */
    
  public static void readme()
  {
    String str = "Given the following details of a matrix with n columns and 2 rows :\n\n";

    str += "The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.\n\n";

    str += "The sum of elements of the 0-th(upper) row is given as upper.\n\n";

    str += "The sum of elements of the 1-st(lower) row is given as lower.\n\n";

    str += "The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.\n\n";

    str += "Your task is to reconstruct the matrix with upper, lower and colsum.\n\n";

    str += "Return it as a 2-D integer array.\n\n";
    
    str += "If there are more than one valid solution, any of them will be accepted.\n\n";
      
    str += "If no valid solution exists, return an empty 2-D array.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    ReconstructATwoRowBinaryMatrix.readme();
    int upper;
    int lower;
    // Input: upper = 2, lower = 1, colsum = [1,1,1]
    // Output: [[1,1,0],[0,0,1]]
    upper = 2;
    lower = 1;
    int[] colsum1 = {1,1,1};
    System.out.println("reconstructMatrix(" + upper + ", " + lower + ", " +
                       Arrays.toString(colsum1) + ") = ");
    List<List<Integer>> list1 = reconstructMatrix(upper, lower, colsum1);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: upper = 2, lower = 3, colsum = [2,2,1,1]
    // Output: []
    upper = 2;
    lower = 3;
    int[] colsum2 = {2,2,1,1};
    System.out.println("reconstructMatrix(" + upper + ", " + lower + ", " +
                       Arrays.toString(colsum2) + ") = ");
    List<List<Integer>> list2 = reconstructMatrix(upper, lower, colsum2);
    System.out.println(Arrays.toString(list2.toArray()));

    // Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
    // Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
    upper = 5;
    lower = 5;
    int[] colsum3 = {2,1,2,0,1,0,1,2,0,1};
    System.out.println("reconstructMatrix(" + upper + ", " + lower + ", " +
                       Arrays.toString(colsum3) + ") = ");
    List<List<Integer>> list3 = reconstructMatrix(upper, lower, colsum3);
    System.out.println(Arrays.toString(list3.toArray()));
    }
}