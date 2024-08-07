package geometry;
import java.util.Arrays;

public class RectangleOverlap
{
  public static boolean isRectangleOverlap(int[] rec1, int[] rec2)
  {
    int rec1x1 = rec1[0];
    int rec1x2 = rec1[2];
    int rec2x1 = rec2[0];
    int rec2x2 = rec2[2];

    int rec1y1 = rec1[1];
    int rec1y2 = rec1[3];
    int rec2y1 = rec2[1];
    int rec2y2 = rec2[3];
    
    if ((rec2x1 < rec1x2 && rec2x1 > rec1x1) ||
        (rec2x2 < rec1x2 && rec2x2 > rec1x1)) {

      if ((rec2y1 < rec1y2 && rec2y1 > rec1y1) ||
          (rec2y2 < rec1y2 && rec2y2 > rec1y1)) {
        return true;
      }
      if ((rec1y1 < rec2y2 && rec1y1 > rec2y1) ||
          (rec1y2 < rec2y2 && rec1y2 > rec2y1)) {
        return true;
      }
    } 

    if ((rec1x1 < rec2x2 && rec1x1 > rec2x1) ||
        (rec1x2 < rec2x2 && rec1x2 > rec2x1)) {

      if ((rec2y1 < rec1y2 && rec2y1 > rec1y1) ||
          (rec2y2 < rec1y2 && rec2y2 > rec1y1)) {
        return true;
      }
      if ((rec1y1 < rec2y2 && rec1y1 > rec2y1) ||
          (rec1y2 < rec2y2 && rec1y2 > rec2y1)) {
        return true;
      }
    }
    
    return false;
  }

  public static boolean isRectangleOverlapOpt(int[] rec1, int[] rec2)
  {
    // Image one rectangle is a dot.
    return (rec1[0] < rec2[2] && rec1[1] < rec2[3] &&
            rec2[0] < rec1[2] && rec2[1] < rec1[3]);
  }
  public static void readme()
  {
    String str = "An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.\n\n";

    str += "Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.\n\n";

    str += "Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RectangleOverlap.readme();

    // rec1 = [0,0,2,2], rec2 = [1,1,3,3] => true 
    int [] rec1 = {0,0,2,2};
    int [] rec2 = {1,1,3,3};
    System.out.println("isRectangleOverlap(" + Arrays.toString(rec1) + ", " +
                       Arrays.toString(rec2) + ") = " +
                       isRectangleOverlap(rec1, rec2));
    System.out.println("");
    
    // rec1 = [0,0,1,1], rec2 = [1,0,2,1] => false
    int [] rec3 = {0,0,1,1};
    int [] rec4 = {1,0,2,1};
    System.out.println("isRectangleOverlap(" + Arrays.toString(rec3) + ", " +
                       Arrays.toString(rec4) + ") = " +
                       isRectangleOverlap(rec3, rec4));
    System.out.println("");


    System.out.println("isRectangleOverlapOpt(" + Arrays.toString(rec3) + ", " +
       Arrays.toString(rec4) + ") = " +
       isRectangleOverlapOpt(rec3, rec4));
    System.out.println("");

    int [] rec5 = {-6,-10,9,2};
    int [] rec6 = {0,5,4,8};
    System.out.println("isRectangleOverlap(" + Arrays.toString(rec5) + ", " +
                       Arrays.toString(rec6) + ") = " +
                       isRectangleOverlap(rec5, rec6));
    System.out.println("");


    System.out.println("isRectangleOverlapOpt(" + Arrays.toString(rec5) + ", " +
       Arrays.toString(rec6) + ") = " +
       isRectangleOverlapOpt(rec5, rec6));

  }
}