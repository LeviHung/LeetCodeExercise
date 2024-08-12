package array;
import java.util.Arrays;

public class ValidMountainArray
{
  public static boolean validMountainArray(int[] arr)
  {
    if (arr.length < 3 || arr[1] <= arr[0] || arr[arr.length - 1] >= arr[arr.length - 2]) 
      return false;

    int i;
    for (i = 1; i < arr.length; i++) {
      if (arr[i] <= arr[i-1]) {
        if (arr[i] < arr[i-1]) {
          break;
        } else if (arr[i] == arr[i-1]) {
          return false;
        }
      } 
    }

    for (i += 1; i < arr.length; i++) {
      if (arr[i] >= arr[i-1]) {
        return false;
      }
    }
    return true;
  }

  public static void readme()
  {
    String str = "Given an array of integers arr, return true if and only if it is a valid mountain array.\n\n";
    
    str += "Recall that arr is a mountain array if and only if:\n\n";
    str += "arr.length >= 3\n\n";
    str += "There exists some i with 0 < i < arr.length - 1 such that:\n\n";
    str += "arr[0] < arr[1] < ... < arr[i - 1] < arr[i] \n\n";
    str += "arr[i] > arr[i + 1] > ... > arr[arr.length - 1]\n";

    System.out.println(str);
  }

  public static void main()
  {
    ValidMountainArray.readme();

    // arr = [2,1] = false
    int [] arr1 = {2,1};
    System.out.println("validMountainArray(" + Arrays.toString(arr1) + ") = " +
                       validMountainArray(arr1));

    // arr = [3,5,5] = false
    int [] arr2 = {3,5,5};
    System.out.println("validMountainArray(" + Arrays.toString(arr2) + ") = " +
                       validMountainArray(arr2));
    
    // arr = [0,3,2,1] = true
    int [] arr3 = {0,3,2,1};
    System.out.println("validMountainArray(" + Arrays.toString(arr3) + ") = " +
                       validMountainArray(arr3));

  }
}