package array;
import java.util.Arrays;

public class ImageSmoother
{
  public static int[][] imageSmoother(int[][] img)
  {
    // [1,1,1],
    // [1,0,1],
    // [1,1,1]
    if (img.length == 1 && img[0].length == 1) {
      return img;
    }
    int [][] sum = new int[img.length][img[0].length];
    int [][] res = new int[img.length][img[0].length];

    if (img.length == 1) {
      for (int c = 0; c < img[0].length; c++) {
        if (c == 0) {
          sum[0][c] = img[0][c] + img[0][c+1];
          res[0][c] = sum[0][c] / 2;
        } else if (c == 1 && img[0].length == 2) {
          sum[0][c] = img[0][c-1] + img[0][c];
          res[0][c] = sum[0][c] / 2;
        } else if (c == 1) {
          sum[0][c] = sum[0][c-1] + img[0][c+1];
          res[0][c] = sum[0][c] / 3;
        } else if (c == img[0].length - 1) {
          sum[0][c] = sum[0][c-1] - img[0][c-2];
          res[0][c] = sum[0][c] / 2;
        } else {
          sum[0][c] = sum[0][c-1] - img[0][c-2] + img[0][c+1];
          res[0][c] = sum[0][c] / 3;
        }
      }
      return res;
    }

    if (img[0].length == 1) {
      for (int r = 0; r < img.length; r++) {
        if (r == 0) {
          sum[r][0] = img[r][0] + img[r+1][0];
          res[r][0] = sum[r][0] / 2;
        } else if (r == 1 && img.length == 2) {
          sum[r][0] = img[r-1][0] + img[r][0];
          res[r][0] = sum[r][0] / 2;
        } else if (r == 1) {
          sum[r][0] = sum[r-1][0] + img[r+1][0];
          res[r][0] = sum[r][0] / 3;
        } else if (r == img.length - 1) {
          sum[r][0] = sum[r-1][0] - img[r-2][0];
          res[r][0] = sum[r][0] / 2;
        } else {
          sum[r][0] = sum[r-1][0] - img[r-2][0] + img[r+1][0];
          res[r][0] = sum[r][0] / 3;
        }
      }
      return res;
    }
    for (int r = 0; r < img.length; r++) {
      for (int c = 0; c < img[0].length; c++) {
        if (r == 0) {
          // {2,5},
          // {8,4},
          // {0,1}
          if (c == 0) {
            sum[r][c] = img[r][c] + img[r][c+1] + img[r+1][0] + img[r+1][c+1];
            res[r][c] = sum[r][c] / 4;
          } else if (c == 1 && img[0].length == 2) {
            sum[r][c] = img[r][c] + img[r][c-1] + img[r+1][c] + img[r+1][c-1];
            res[r][c] = sum[r][c] / 4;
          } else if (c == 1) {
            sum[r][c] = sum[r][c-1] + img[r][c+1] + img[r+1][c+1];
            res[r][c] = sum[r][c] / 6;
          } else if (c == img[0].length - 1) {
            sum[r][c] = sum[r][c-1] - img[r][c-2] - img[r+1][c-2];
            res[r][c] = sum[r][c] / 4;
          } else {
            sum[r][c] = sum[r][c-1] - img[r][c-2] - img[r+1][c-2] + img[r][c+1] + img[r+1][c+1];
            res[r][c] = sum[r][c] / 6;
          }
          // [1,1,1],
          // [1,0,1],
          // [1,1,1]
        } else if (r == img.length - 1) {
          if (c == 0) {
            sum[r][c] = img[r-1][c] + img[r-1][c+1] + img[r][c] + img[r][c+1];
            res[r][c] = sum[r][c] / 4;
          } else if (c == 1 && img[0].length == 2) {
            sum[r][c] = img[r-1][c] + img[r-1][c-1] + img[r][c] + img[r][c-1];
            res[r][c] = sum[r][c] / 4;
          } else if (c == 1) {
            sum[r][c] = sum[r][c-1] + img[r][c+1] + img[r-1][c+1];
            res[r][c] = sum[r][c] / 6;
          } else if (c == img[0].length - 1) {
            sum[r][c] = sum[r][c-1] - img[r][c-2] - img[r-1][c-2];
            res[r][c] = sum[r][c] / 4;
          } else {
            sum[r][c] = sum[r][c-1] - img[r][c-2] - img[r-1][c-2] + img[r][c+1] + img[r-1][c+1];
            res[r][c] = sum[r][c] / 6;
          }
          // [1,1,1],
          // [1,0,1],
          // [1,1,1]
        } else {
          if (c == 0) {
            sum[r][c] = img[r-1][c] + img[r-1][c+1] + img[r][c] + img[r][c+1] + img[r+1][c] + img[r+1][c+1];
            res[r][c] = sum[r][c] / 6;
          } else if (c == 1 && img[0].length == 2) {
            sum[r][c] = img[r-1][c] + img[r-1][c-1] + img[r][c] + img[r][c-1] + img[r+1][c] + img[r+1][c-1];
            res[r][c] = sum[r][c] / 6;

          } else if (c == 1) {
            sum[r][c] = sum[r][c-1] + img[r+1][c+1] + img[r][c+1] +img[r-1][c+1];
            res[r][c] = sum[r][c] / 9;
          } else if (c == img[0].length - 1) {
            sum[r][c] = sum[r][c-1] - img[r+1][c-2] - img[r][c-2] - img[r-1][c-2];
            res[r][c] = sum[r][c] / 6;
          } else {
            sum[r][c] = sum[r][c-1] - img[r+1][c-2] - img[r][c-2] - img[r-1][c-2] + img[r+1][c+1] + img[r][c+1] + img[r-1][c+1];
            res[r][c] = sum[r][c] / 9;
          }
        }
      }
    }

    return res;
    /*
    int count = 0;
    int discount = 0;
    int sum = 0;
    for (int r = 0; r < img.length; r++) {
      for (int c = 0; c < img[0].length; c++) {
        count = 0;
        discount = 0;
        sum = 0;
        while (count < 9) {
          if (count / 3 + r - 1 < 0) {
            discount++;
          } else if (count % 3 + c - 1 < 0) {
            discount++;
          } else if (count / 3 + r - 1 > img.length - 1) {
            discount++;
          } else if (count % 3 + c - 1 > img[0].length - 1) {
            discount++;
          } else {            
            sum += img[count/3 + r - 1][count%3 + c - 1];
          }
          count++;
        }
        res[r][c] = sum / (count - discount);
      }
    }
    return res;
    */
  }

  public static int[][] imageSmootherOpt(int[][] img) 
  {
    int rowLast = img.length - 1;
    int colLast = img[0].length - 1;
    if (rowLast == 0) {     
        if (colLast != 0)  singleRow(img[0], colLast);
    }
    else if (colLast == 0) {  
        singleCol(img, rowLast);
    }
    else {                    
        for (int row = 0; row <= rowLast; row++)    
            sumRow(img[row], colLast);
        sumCol(img, 0, 4, 6, rowLast);                
        sumCol(img, colLast, 4, 6, rowLast);         
        for (int col = 1; col < colLast; col++)     
            sumCol(img, col, 6, 9, rowLast);
    }
    return img;
  }
    
  private static void singleRow(int[] matrix, int colLast) 
  {
    int prev = 0;
    int curr = matrix[0];
    int next = matrix[1];
    matrix[0] = (curr + next) / 2;
    for (int col = 1; col < colLast; col++) {
        prev = curr;
        curr = next;
        next = matrix[col+1];
        matrix[col] = (prev + curr + next) / 3;
    }
    matrix[colLast] = (next + curr) / 2;
  }
      
  private static void singleCol(int[][] mat, int rowLast)
  {
    int prev = 0;
    int curr = mat[0][0];
    int next = mat[1][0];
    mat[0][0] = (curr + next) / 2;
    for (int row = 1; row < rowLast; row++) {
        prev = curr;
        curr = next;
        next = mat[row+1][0];
        mat[row][0] = (prev + curr + next) / 3;
    }
    mat[rowLast][0] = (next + curr) / 2;
  }
      
  private static void sumRow(int[] matrix, int colLast) 
  {
    int prev = 0;
    int curr = 0;
    int next = matrix[0];
    for (int col = 0; col < colLast; col++) {
        prev = curr;
        curr = next;
        next = matrix[col+1];
        matrix[col] = prev + curr + next;
    }
    matrix[colLast] = next + curr;
  }
      
  private static void sumCol(int[][] mat, int col, int endDiv, int midDiv, int rowLast) 
  {
    int prev = 0;
    int curr = mat[0][col];
    int next = mat[1][col];
    mat[0][col] = (curr + next) / endDiv;
    for (int row = 1; row < rowLast; row++) {
        prev = curr;
        curr = next;
        next = mat[row+1][col];
        mat[row][col] = (prev + curr + next) / midDiv;
    }
    mat[rowLast][col] = (next + curr) / endDiv;
  }

  public static void readme()
  {
    String str = "An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).\n";

    System.out.println(str);
  }

  public static void main()
  {
    ImageSmoother.readme();
    // img = [[1,1,1],[1,0,1],[1,1,1]] => [[0,0,0],[0,0,0],[0,0,0]]
    int [][] img1 = {{1,1,1},{1,0,1},{1,1,1}};
    System.out.println("imageSmoother(" + Arrays.deepToString(img1) + ") = " +
                       Arrays.deepToString(imageSmoother(img1)));

    // img = [[100,200,100],[200,50,200],[100,200,100]] 
    // => [[137,141,137],[141,138,141],[137,141,137]]
    int [][] img2 = {{100,200,100},{200,50,200},{100,200,100}};
    System.out.println("imageSmoother(" + Arrays.deepToString(img2) + ") = " +
                       Arrays.deepToString(imageSmoother(img2)));

    int [][] img3 = {{2,3}};
    System.out.println("imageSmoother(" + Arrays.deepToString(img3) + ") = " +
                       Arrays.deepToString(imageSmoother(img3)));

    int [][] img4 = {{1,2},{3,4}};
    System.out.println("imageSmoother(" + Arrays.deepToString(img4) + ") = " +
                       Arrays.deepToString(imageSmoother(img4)));

    int [][] img5 = {{2,5},{8,4},{0,1}};
    System.out.println("imageSmoother(" + Arrays.deepToString(img5) + ") = " +
                       Arrays.deepToString(imageSmoother(img5)));
    System.out.println("imageSmootherOpt(" + Arrays.deepToString(img5) + ") = " +
                       Arrays.deepToString(imageSmootherOpt(img5)));
  }
}