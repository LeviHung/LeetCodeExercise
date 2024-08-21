package array;
import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide
{
  public static int[] replaceElements(int[] arr) {
      int[] res = new int [arr.length];
      int max = -1;
      for (int i = arr.length - 1; i >= 0; i--) {
          res[i] = max;
          if (arr[i] > max) {
              max = arr[i];
          }
          //max = Math.max(arr[i], max);
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.\n\n";

    str += "After doing so, return the array.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ReplaceElementsWithGreatestElementOnRightSide.readme();

    // Input: arr = [17,18,5,4,6,1]
    // Output: [18,6,6,6,1,-1]
    int [] arr1 = {17,18,5,4,6,1};
    System.out.println("replaceElements(" + Arrays.toString(arr1) + ") = " +
                       Arrays.toString(replaceElements(arr1)));

    // Input: arr = [400]
    // Output: [-1]
    int [] arr2 = {400};
    System.out.println("replaceElements(" + Arrays.toString(arr2) + ") = " +
                       Arrays.toString(replaceElements(arr2)));

  }
}