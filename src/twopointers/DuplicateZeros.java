package twopointers;
import java.util.Arrays;

public class DuplicateZeros
{
  public static void duplicateZeros(int[] arr) {
    int zero = 0;
    for (int val: arr) {
        if (val == 0)
            zero++;
    }

    int index = arr.length - 1;
    for (int i = arr.length - 1 + zero; i >= 0; i--) {
        if (arr[index] == 0) {
            if (i < arr.length) 
                arr[i] = 0;
                i--;
            if (i < arr.length) 
                arr[i] = 0;
        } else {
            if (i < arr.length) 
                arr[i] = arr[index];
        }
        index--;
    }

    // Use temp array.
    /*
    int[] tmp = new int [arr.length + zero];
    int index = arr.length - 1;
    for (int i = arr.length - 1 + zero; i >= 0; i--) {
        if (arr[index] == 0) {
            tmp[i] = 0;
            i--;
            tmp[i] = 0;
        } else {
            tmp[i] = arr[index];
        }
        index--;
    }
    // System.out.println(Arrays.toString(tmp));
    for (int i = 0; i < arr.length; i++) {
        arr[i] = tmp[i];
    }
    */
  }
  // Use one by one shift.
  /*
  public void duplicateZeros(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] == 0) {
            shift(arr, i+1);
            arr[i+1] = 0;
            i++;
        }
    }
  }

  public void shift(int[] arr, int start) {
    if (start > arr.length - 1) {
        return;
    }
    for (int i = arr.length - 1; i > start; i--) {
        arr[i] = arr[i-1];
    }
  }
  */

  public static void readme()
  {
    String str = "Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.\n\n";

    str += "Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MoveZeroes.readme();

    //Input: arr = [1,0,2,3,0,4,5,0]
    //Output: [1,0,0,2,3,0,0,4]
    int[] arr1 = {1,0,2,3,0,4,5,0};
    System.out.println("duplicateZeros(" + Arrays.toString(arr1) + ") = ");
    duplicateZeros(arr1);
    System.out.println(Arrays.toString(arr1));

    //Input: arr = [1,2,3]
    //Output: [1,2,3]
    int[] arr2 = {1,2,3};
    System.out.println("duplicateZeros(" + Arrays.toString(arr2) + ") = ");
    duplicateZeros(arr2);
    System.out.println(Arrays.toString(arr2));

  }
}