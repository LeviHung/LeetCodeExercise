package matrix;
import java.util.Arrays;

public class FlippingImage
{
  public static int[][] flipAndInvertImage(int[][] image)
  {
    int [][] res = new int[image.length][image[0].length];
    int cIndex;
    for (int r = 0; r < image.length; r++) {
      cIndex = image[0].length - 1;
      for (int c = 0; c < image[0].length; c++) {
        res[r][c] = image[r][cIndex--] ^ 1; 
        /*
        if (image[r][cIndex--] == 0) {
            res[r][c] = 1;
        } else {
            res[r][c] = 0;
        }
        */
      }
    }
    return res;
  }

  public static void readme()
  {
    String str = "Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.\n\n";

    str += "To flip an image horizontally means that each row of the image is reversed.\n\n";

    str += "For example, flipping [1,1,0] horizontally results in [0,1,1].\n\n";

    str += "To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.\n\n";

    str += "For example, inverting [0,1,1] results in [1,0,0].\n";

    System.out.println(str);
  }

  public static void main()
  {
    FlippingImage.readme();
    int sr;
    int sc;
    int color;

    // image = [[1,1,0],[1,0,1],[0,0,0]] => [[1,0,0],[0,1,0],[1,1,1]]
    int [][] image1 = {{1,1,0},{1,0,1},{0,0,0}};
    System.out.println("flipAndInvertImage(" + Arrays.deepToString(image1) +
                       ") = " +
                       Arrays.deepToString(flipAndInvertImage(image1)));

    // image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    // => [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    int [][] image2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    System.out.println("flipAndInvertImage(" + Arrays.deepToString(image2) +
                       ") = " +
                       Arrays.deepToString(flipAndInvertImage(image2)));
  }
}