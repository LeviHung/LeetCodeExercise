package matrix;
import java.util.Arrays;

public class FloodFill
{
  public static int[][] floodFill(int[][] image, int sr, int sc, int color)
  {
    int [][] res = new int[image.length][image[0].length];

    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        res[i][j] = image[i][j];
      }
    }

    fill(image, res, sr, sc, color);
    
    return res;
  }

  // [1,1,1],
  // [1,1,0],
  // [1,0,1]

  // [2,2,1], 
  // [2,2,0], 
  // [1,0,1]
  public static void fill(int[][] img, int[][] newImg, int sr, int sc, int color) 
  {
    if (sr < 0 || sc < 0 || sr > img.length - 1 || sc > img[0].length - 1) {
      return;
    }

    newImg[sr][sc] = color;

    if (sr > 0) {
      if (img[sr-1][sc] == img[sr][sc]) {
        if (newImg[sr-1][sc] != color) {
          newImg[sr-1][sc] = color;
          fill(img, newImg, sr - 1, sc, color);
        }
      }
    }

    if (sr < img.length - 1) {
      if (img[sr+1][sc] == img[sr][sc]) {
        if (newImg[sr+1][sc] != color) {
          newImg[sr+1][sc] = color;
          fill(img, newImg, sr + 1, sc, color);
        }
      }
    }

    if (sc > 0) {
      if (img[sr][sc-1] == img[sr][sc]) {
        if (newImg[sr][sc-1] != color) {
          newImg[sr][sc-1] = color;
          fill(img, newImg, sr, sc - 1, color);
        }
      }
    }

    if (sc < img[0].length - 1) {
      if (img[sr][sc+1] == img[sr][sc]) {
        if (newImg[sr][sc+1] != color) {
          newImg[sr][sc+1] = color;
          fill(img, newImg, sr, sc + 1, color);
        }
      }
    }
  }

  public static int[][] floodFillOpt(int[][] image, int sr, int sc, int newColor) 
  {
    if (newColor == image[sr][sc]) 
      return image;
    
    DFS(image, sr, sc, newColor, image[sr][sc]);
    
    return image;
  }

  // [1,1,1],
  // [1,1,0],
  // [1,0,1]

  // [2,2,2], 
  // [2,2,0], 
  // [2,0,1]
  private static void DFS(int[][] image, int row, int col, int color, int oldColor) 
  {
    if (row >= image.length || 
        row < 0 || 
        col >= image[0].length || 
        col < 0  || 
        image[row][col] != oldColor) 
      return;


    image[row][col] = color;

    DFS(image, row - 1, col, color, oldColor);
    DFS(image, row + 1, col, color, oldColor);
    DFS(image, row, col-1, color, oldColor);
    DFS(image, row, col+1, color, oldColor);
  }

  public static void readme()
  {
    String str = "An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.\n\n";

    str += "You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].\n\n";

    str += "To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.\n\n";

    str += "Return the modified image after performing the flood fill.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FloodFill.readme();
    int sr;
    int sc;
    int color;
    
    // image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2 
    // => [[2,2,2],[2,2,0],[2,0,1]]
    int [][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
    sr = 1;
    sc = 1;
    color = 2;
    System.out.println("floodFill(" + Arrays.deepToString(image1) + ", " +
                       sr + ", " + sc + ", " + color + ") = " +
                       Arrays.deepToString(floodFill(image1, sr, sc, color)));

    // image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0 
    // => [[0,0,0],[0,0,0]]
    int [][] image2 = {{0,0,0},{0,0,0}};
    sr = 0;
    sc = 0;
    color = 0;
    System.out.println("floodFill(" + Arrays.deepToString(image2) + ", " +
                       sr + ", " + sc + ", " + color + ") = " +
                       Arrays.deepToString(floodFill(image2, sr, sc, color)));

    int [][] image3 = {{1,1,1},{1,1,0},{1,0,1}};
    sr = 1;
    sc = 1;
    color = 2;
    System.out.println("floodFillOpt(" + Arrays.deepToString(image3) + ", " +
                       sr + ", " + sc + ", " + color + ") = " +
                       Arrays.deepToString(floodFillOpt(image3, sr, sc, color)));

  }
}