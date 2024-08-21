package math;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero
{
  public static int[] sumZero(int n) {
      int[] res = new int [n];
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
          res[i] = i + 1;
          sum += res[i];
      }
      res[n-1] = sum * -1;
      return res;
  }

  public static void readme()
  {
    String str = "Given an integer n, return any array containing n unique integers such that they add up to 0.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindNUniqueIntegersSumUpToZero.readme();

    int n;
    // Input: n = 5
    //Output: [-7,-1,1,3,4]
    n = 5;
    System.out.println("sumZero(" + n + ") = " + 
                        Arrays.toString(sumZero(n)));

    // Input: n = 3
    // Output: [-1,0,1]
    n = 3;
    System.out.println("sumZero(" + n + ") = " + 
                       Arrays.toString(sumZero(n)));

    // Input: n = 1
    // Output: [0]
    n = 1;
    System.out.println("sumZero(" + n + ") = " + 
                       Arrays.toString(sumZero(n)));

  }
}