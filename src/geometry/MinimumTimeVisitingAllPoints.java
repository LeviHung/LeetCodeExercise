package geometry;
import java.util.Arrays;

public class MinimumTimeVisitingAllPoints
{
  public static int minTimeToVisitAllPoints(int[][] points) {
    int time = 0;
    for (int i = 0; i < points.length - 1; i++) {
        time += getDistance(points[i], points[i+1]);
    }
    return time;
  }

  public static int getDistance(int[] p1, int[] p2) {
    int diffX = Math.abs(p1[0] - p2[0]);
    int diffY = Math.abs(p1[1] - p2[1]);
    int diagonal;
    int vertHorizontal;
    if (diffX <= diffY) {
        diagonal = diffX;
        vertHorizontal = diffY - diffX;   
    } else {
        diagonal = diffY;
        vertHorizontal = diffX - diffY;   

    }
    return diagonal + vertHorizontal;
  }


  public static void readme()
  {
    String str = "On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.\n\n";

    str += "You can move according to these rules:\n\n";
    str += "In 1 second, you can either:\n\n";
    str += "move vertically by one unit,\n\n";
    str += "move horizontally by one unit, or\n\n";
    str += "move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).\n\n";
    str += "You have to visit the points in the same order as they appear in the array.\n\n";
    str += "You are allowed to pass through points that appear later in the order, but these do not count as visits.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    MinimumTimeVisitingAllPoints.readme();

    // Input: points = [[1,1],[3,4],[-1,0]]
    // Output: 7

    int [][] points1 = {{1,1},{3,4},{-1,0}};
    System.out.println("minTimeToVisitAllPoints(" + 
                       Arrays.deepToString(points1) + ") = " +
                       minTimeToVisitAllPoints(points1));

    // Input: points = [[3,2],[-2,2]]
    // Output: 5
    int [][] points2 = {{3,2},{-2,2}};
    System.out.println("minTimeToVisitAllPoints(" + 
                       Arrays.deepToString(points2) + ") = " +
                       minTimeToVisitAllPoints(points2));

  }
}