package geometry;
import java.util.Arrays;

public class CheckIfItIsAStraightLine
{
  public static boolean checkStraightLine(int[][] coordinates) {
    for (int i = 2; i < coordinates.length; i++) {
        if (triangleArea(coordinates[0], coordinates[1], coordinates[i]) > 0) {
            return false;
        }
    }
    return true;
  }

  public static double triangleArea(int[] a, int[] b, int[] c) {
    return (double) Math.abs((a[0] * (b[1] - c[1])) + 
                             (b[0] * (c[1] - a[1])) + 
                             (c[0] * (a[1] - b[1]))) / 2;
  }


  public static void readme()
  {
    String str = "You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CheckIfItIsAStraightLine.readme();

    //Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    //Output: true
    int [][] coordinates1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
    System.out.println("checkStraightLine(" + Arrays.deepToString(coordinates1) +
                       ") = " +
                       checkStraightLine(coordinates1));

    // Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    // Output: false

    int [][] coordinates2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
    System.out.println("checkStraightLine(" + Arrays.deepToString(coordinates2) +
                       ") = " +
                       checkStraightLine(coordinates2));

  }
}