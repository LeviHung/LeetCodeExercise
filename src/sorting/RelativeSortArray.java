package sorting;

import java.util.Arrays;

public class RelativeSortArray
{
  public static int[] relativeSortArray(int[] arr1, int[] arr2) {
      int[] num = new int [1001];
      for (int i = 0; i < arr2.length; i++) {
          num[arr2[i]]++;
      }

      for (int i = 0; i < arr1.length; i++) {
          num[arr1[i]]++;
      }

      int[] res = new int[arr1.length];
      int index = 0;
      for (int i = 0; i < arr2.length; i++) {
          while (num[arr2[i]] > 1) {
              res[index++] = arr2[i];
              num[arr2[i]]--;
          }
          num[arr2[i]] = 0;;
      }

      for (int i = 0; i < 1001; i++) {
          while (num[i] > 0) {
              res[index++] = i;
              num[i]--;
          }
      }

      return res;
  }

  public static void readme()
  {
    String str = "Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.\n\n";

    str += "Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RelativeSortArray.readme();

    //Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    //Output: [2,2,2,1,4,3,3,9,6,7,19]

    int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    int [] arr2 = {2,1,4,3,9,6};
    System.out.println("relativeSortArray(" + Arrays.toString(arr1) + 
                       ", " + Arrays.toString(arr2) + ") = " +
                       Arrays.toString(relativeSortArray(arr1, arr2)));

    //Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
    //Output: [22,28,8,6,17,44]

    int [] arr3 = {28,6,22,8,44,17};
    int [] arr4 = {22,28,8,6};
    System.out.println("relativeSortArray(" + Arrays.toString(arr3) + 
                       ", " + Arrays.toString(arr4) + ") = " +
                       Arrays.toString(relativeSortArray(arr3, arr4)));
  }
}