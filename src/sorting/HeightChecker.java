package sorting;

import java.util.Arrays;

public class HeightChecker
{
  public static int heightChecker(int[] heights)
  {
    int[] array = new int [101];
    for (int val: heights) {
        array[val]++;
    }
    int[] tmp = new int[heights.length];
    int index = 0;
    for (int i = 1; i < 101; i++) {
        while (array[i] > 0) {
            tmp[index++] = i;
            array[i]--;
        }
    }
    int res = heights.length;
    for (int i = 0; i < heights.length; i++) {
        if (tmp[i] == heights[i]) {
            res--;
        }
    }
    return res;
    /*
    int [] tmp = heights.clone();
    Arrays.sort(heights);
    int res = heights.length;
    for (int i = 0; i < heights.length; i++) {
        if (tmp[i] == heights[i]) {
            res--;
        }
    }
    return res;
    */
  }

  public static void readme()
  {
    String str = "A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.\n\n";
    str += "You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).\n\n";
    str += "Return the number of indices where heights[i] != expected[i].\n";

    System.out.println(str);
  }

  public static void main()
  {
    HeightChecker.readme();

    // heights = [1,1,4,2,1,3] => 3
    int [] heights1 = {1,1,4,2,1,3};
    System.out.println("heightChecker(" + Arrays.toString(heights1) + ") = " +
                       heightChecker(heights1));

    // heights = [5,1,2,3,4] => 5
    int [] heights2 = {5,1,2,3,4};
    System.out.println("heightChecker(" + Arrays.toString(heights2) + ") = " +
                       heightChecker(heights2));

    // heights = [1,2,3,4,5] => 0
    int [] heights3 = {1,2,3,4,5};
    System.out.println("heightChecker(" + Arrays.toString(heights3) + ") = " +
                       heightChecker(heights3));

  }
}