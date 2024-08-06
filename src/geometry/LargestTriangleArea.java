package geometry;
import java.util.Arrays;

public class LargestTriangleArea
{
  
  public static double largestTriangleArea(int[][] points)
  {

    if (points.length == 3) {
      return triangleArea(points[0], points[1], points[2]);
    }
    // [4, 6], [6, 5], [3, 1]
    //
    //|    * (4,6)
    //|      * (6,5)
    //|      
    //|      
    //|   * (3,1)    
    //|_______
    //AB = (1, 5)
    //AC = (3, 4)
    //3, 4, 6   1, 5, 6
    
    // 3, 5, 8    3, 5, 6
    // [8,3],[5,6],[3,5]  => 3, 3  5, 2
    // 5 * 3  / 2 - 2 * 2
    // |     * (5,6)
    // |   * (3,5)
    // |
    // |        * (8,3)
    // |
    // |________
    double maxArea = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i; j < points.length; j++) {
        if (j == i) {
          continue;
        }
        for (int k = j; k < points.length; k++) {
          if (k == i || k == j) {
            continue;
          }
          double area = triangleArea(points[i],points[j],points[k]);
          //System.out.println("area = " + area + " (" + i + "," + j + "," + k + ")");
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }
    }
    return maxArea;
    
    /*  
    System.out.println("minXPoint = " + Arrays.toString(minXPoint) + ", maxXPoint = " + Arrays.toString(maxXPoint));
    System.out.println("minYPoint = " + Arrays.toString(minYPoint) + ", maxYPoint = " + Arrays.toString(maxYPoint));
    System.out.println("maxY = " + maxY);
    System.out.println("minX = " + minX + ", maxX = " +  maxX);
    System.out.println("minY = " + minY);
    return (double) (maxX - minX) * (maxY - minY) / 2 -
           (double) (maxXPoint[1] - minXPoint[1]) * (maxYPoint[0] - minYPoint[0]) / 2;
    */
  }
  public static double triangleArea(int[] a, int[] b, int[] c) 
  {
    return (double) Math.abs((a[0] * (b[1] - c[1])) + (b[0] * (c[1] - a[1])) + (c[0] * (a[1] - b[1]))) / 2;
  }

  static double maxArea = 0;
  static int[] idxList = new int[3];
  static int n, k;

  public static double largestTriangleAreaOpt(int[][] points) 
  {
      n = points.length;
      k = 3;

      dfs(points, 0, 0);

      return maxArea;
  }

  static void dfs(int[][] points, int pre, int idx) {
      if(idx >= k) {
          maxArea = Math.max(getArea(points), maxArea);
          return;
      }

      for(int i = pre + 1; i <= n; ++i) {
          idxList[idx] = i - 1;
          dfs(points, i, idx + 1);  
      }
  }

  static double getArea(int[][] points) {
      return Math.abs(0.5 * (points[idxList[0]][0] * (points[idxList[1]][1] - points[idxList[2]][1]) +
                      points[idxList[1]][0] * (points[idxList[2]][1] - points[idxList[0]][1]) +
                      points[idxList[2]][0] * (points[idxList[0]][1] - points[idxList[1]][1])));
  }
  
  public static void readme()
  {
    String str = "Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LargestTriangleArea.readme();
    
    // points = [[0,0],[0,1],[1,0],[0,2],[2,0]] => 2.00000 
    int [][] points1 = {{0,0},{0,1},{1,0},{0,2},{2,0}};
    System.out.println("largestTriangleArea(" + Arrays.deepToString(points1) +
                       ") = " +
                        largestTriangleArea(points1));

    // points = [[1,0],[0,0],[0,1]] => 0.50000
    int [][] points2 = {{1,0},{0,0},{0,1}};
    System.out.println("largestTriangleArea(" + Arrays.deepToString(points2) +
                       ") = " +
                       largestTriangleArea(points2));

    // points = [[4,6],[6,5],[3,1]] => 5.5
    int [][] points3 = {{4,6},{6,5},{3,1}};
    System.out.println("largestTriangleArea(" + Arrays.deepToString(points3) +
                       ") = " +
                       largestTriangleArea(points3));
                       
    //|            o (5,7)      o (10,7)
    //|    * (4,6)
    //|      * (6,5)
    //|o(0,4)               
    //|      
    //|   * (3,1)    
    //|________________________
    //AB = (1, 5)
    //AC = (3, 4)
      
    int [][] points4 = {{10,7},{0,4},{5,7}};
    System.out.println("largestTriangleArea(" + 
                         Arrays.deepToString(points4) +
                         ") = " +
                         largestTriangleArea(points4));

    
    int [][] points5 = {{8,10},{2,7},{9,2},{4,10}};
    System.out.println("largestTriangleArea(" + 
                       Arrays.deepToString(points5) +
                       ") = " +
                       largestTriangleArea(points5));
    
    
    //| O(1,10)* (4,10) O (6,10)  * (8,10)
    //|
    //|   O (2,7)                     O (9,7)
    //|   * (2,7)
    //|   
    //|
    //|
    //|
    //|                               * (9,2)
    //|
    //_______________________  7*8   5*1
    
    // 8 * 3   3 * 1  3 x 3   7 * 3
    int [][] points6 = {{9,7},{6,10},{1,10},{2,7}};
    System.out.println("largestTriangleArea(" + 
                       Arrays.deepToString(points6) +
                       ") = " +
                       largestTriangleArea(points6));

    int [][] points7 = {{9,0},{1,10},{7,6},{10,0},{3,9}};
    System.out.println("largestTriangleArea(" + 
                       Arrays.deepToString(points7) +
                       ") = " +
                       largestTriangleArea(points7));

    System.out.println("largestTriangleAreaOpt(" + 
                       Arrays.deepToString(points7) +
                       ") = " +
                       largestTriangleAreaOpt(points7));

  }
}