package array;
import java.util.Arrays;

public class ElementAppearingMoreThan25Percent
{
  public static int findSpecialInteger(int[] arr) {
      int l = 1;
      int r = arr.length;
      int count = 1;
      int num = arr.length / 4;
      while (l < r) {
          if (arr[l] == arr[l-1]) {
              count++;
              if (count > num) {
                  return arr[l];
              }
          } else {
              count = 1;
          }
          l++;
      }
      return arr[l-1];
  }

  public static void readme()
  {
    String str = "Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ElementAppearingMoreThan25Percent.readme();

    // Input: arr = [1,2,2,6,6,6,6,7,10]
    // Output: 6

    int [] arr1 = {1,2,2,6,6,6,6,7,10};
    System.out.println("findSpecialInteger(" + Arrays.toString(arr1) + ") = " +
                       findSpecialInteger(arr1));

    // Input: arr = [1,1]
    // Output: 1
    int [] arr2 = {1,1};
    System.out.println("findSpecialInteger(" + Arrays.toString(arr2) + ") = " +
                       findSpecialInteger(arr2));

  }
}