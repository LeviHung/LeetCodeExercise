package math;

import java.util.Arrays;

public class ConstructRectangle
{
  public static int[] constructRectangle(int area)
  {
    // Note. checking w first instead of l is better for runtime; 
    int [] result = new int[2];
    int l = (int) Math.sqrt(area);
    int w = 1;
    if (l * l == area) {
      w = l;
    } else {
      for (l = l + 1; l <= area; l++) {
          if (area % l == 0) {
            w = area / l;
            break;
          }
      }
    }
    result[0] = l;
    result[1] = w;
    return result;
  }

  public static int[] constructRectangleOpt(int area) 
  {
      int wid = (int) Math.sqrt(area);
      while (area%wid != 0){
          wid--;
      }
      int hig = area/wid;
      return (new int[] {hig, wid});
  }
  
  public static void readme()
  {
    String str = "A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:\n\n";
    
    str += "The area of the rectangular web page you designed must equal to the given target area.\n\n";

    str += "The width W should not be larger than the length L, which means L >= W.\n\n";

    str += "The difference between length L and width W should be as small as possible.\n\n";

    str += "Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ConstructRectangle.readme();

    int area;
    // area = 4 => [2,2]
    area = 4;
    System.out.println("constructRectangle(" + area + ") = " + 
                        Arrays.toString(constructRectangle(area)));

    // num = 37 => [37,1]
    area = 37;
    System.out.println("constructRectangle(" + area + ") = " +       
                        Arrays.toString(constructRectangle(area)));

    // area = 122122 => [427,286]
    area = 122122;
    System.out.println("constructRectangle(" + area + ") = " +       
                        Arrays.toString(constructRectangle(area)));

    area = 2;
    System.out.println("constructRectangle(" + area + ") = " +       
                        Arrays.toString(constructRectangle(area)));

    area = 10000000;
    System.out.println("constructRectangle(" + area + ") = " +       
                        Arrays.toString(constructRectangle(area)));

    System.out.println("constructRectangleOpt(" + area + ") = " +       
                        Arrays.toString(constructRectangleOpt(area)));

  }
}