package geometry;
import java.util.Arrays;

public class ValidBoomerang
{
  public static boolean isBoomerang(int[][] points) 
  {
    if (isDistinct(points) == false) {
      return false;
    }

    if (triangleArea(points[0], points[1], points[2]) == 0) {
      return false;
    }

    return true;
  }

  public static boolean isDistinct(int[][] points) 
  {
    if ((points[0][0] == points[1][0] && points[0][1] == points[1][1]) || 
        (points[0][0] == points[2][0] && points[0][1] == points[2][1]) || 
        (points[1][0] == points[2][0] && points[1][1] == points[2][1])) {
      return false;
    } else {
      return true;
    }
  }

  public static double triangleArea(int[] a, int[] b, int[] c) 
  {
    return (double) Math.abs((a[0] * (b[1] - c[1])) + 
                             (b[0] * (c[1] - a[1])) + 
                             (c[0] * (a[1] - b[1]))) / 2;
  }
  
  public static void readme()
  {
    String str = "Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.\n\n";

    str += "A boomerang is a set of three points that are all distinct and not in a straight line.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    ValidBoomerang.readme();

    // points = [[1,1],[2,3],[3,2]] => true
    int [][] points1 = {{1,1},{2,3},{3,2}};
    System.out.println("isBoomerang(" + Arrays.deepToString(points1) +
                       ") = " +
                       isBoomerang(points1));

    // points = [[1,1],[2,2],[3,3]] => false
    int [][] points2 = {{1,1},{2,2},{3,3}};
    System.out.println("isBoomerang(" + Arrays.deepToString(points2) +
                       ") = " +
                       isBoomerang(points2));

  }
}