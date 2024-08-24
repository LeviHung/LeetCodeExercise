package hashtable;
import java.util.Arrays;

public class FindLuckyIntegerInAnArray
{
  public static6 int findLucky(int[] arr) {
      int[] freq = new int [501];
      for (int val: arr) {
          freq[val]++;
      } 
      for (int i = 500; i > 0; i--) {
          if (freq[i] == i) {
              return i;
          }
      } 
      return -1;
  }

  public static void readme()
  {
    String str = "Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.\n\n";

    str += " Return the largest lucky integer in the array. If there is no lucky integer return -1.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindLuckyIntegerInAnArray.readme();

    // Input: arr = [2,2,3,4]
    // Output: 2
    int [] arr1 = {2,2,3,4};
    System.out.println("findLucky(" + Arrays.toString(arr1) + ") = " +
                       findLucky(arr1));

    // Input: arr = [1,2,2,3,3,3]
    // Output: 3
    int [] arr2 = {1,2,2,3,3,3};
    System.out.println("findLucky(" + Arrays.toString(arr2) + ") = " +
                       findLucky(arr2));

    // Input: arr = [2,2,2,3,3]
    // Output: -1
    int [] arr3 = {2,2,2,3,3};
    System.out.println("findLucky(" + Arrays.toString(arr3) + ") = " +
                       findLucky(arr3));

  }
}