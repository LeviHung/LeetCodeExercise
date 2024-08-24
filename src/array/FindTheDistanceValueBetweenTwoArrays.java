package array;
import java.util.Arrays;

public class FindTheDistanceValueBetweenTwoArrays
{
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        /*
        boolean[] freq2 = new boolean [2001];
        for (int i = 0; i < arr2.length; i++) {
            freq2[arr2[i] + 1000] = true;
        }

        int res = arr1.length;
        int val;
        for (int i = 0; i < arr1.length; i++) {
            val = arr1[i] + 1000;
            for (int j = -d; j <= d; j++) {
                if ((val + j) < 0 || (val + j) >= 2001)
                    continue;
                if (freq2[val + j] == true) {
                    res--;
                    break;
                }
            }
        }
        */

        int res = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            if (isDistanceValue(arr1[i], arr2, d) == false) {
                res--;
            }
        }
        return res;
    }
    public static boolean isDistanceValue(int i, int[] arr, int d) {
        int max = i+d;
        int min = i-d;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= max && arr[j] >= min) {
                return false;
            }
        }
        return true;
    }

  public static void readme()
  {
    String str = "Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.\n\n";

    str += "The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindTheDistanceValueBetweenTwoArrays.readme();

    int d;
    // Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
    // Output: 2
    int [] arr1 = {4,5,8};
    int [] arr2 = {10,9,1,8};
    d = 2;
    System.out.println("findTheDistanceValue(" + 
                       Arrays.toString(arr1) + ", " + 
                       Arrays.toString(arr2) + 
                       ", " + d + ") = " +
                       findTheDistanceValue(arr1, arr2, d));

    // Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
    // Output: 2
    int [] arr3 = {1,4,2,3};
    int [] arr4 = {-4,-3,6,10,20,30};
    d = 3;
    System.out.println("findTheDistanceValue(" + 
                       Arrays.toString(arr3) + ", " + 
                       Arrays.toString(arr4) + 
                       ", " + d + ") = " +
                       findTheDistanceValue(arr3, arr4, d));
    
    // Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
    // Output: 1
    int [] arr5 = {2,1,100,3};
    int [] arr6 = {-5,-2,10,-3,7};
    d = 6;
    System.out.println("findTheDistanceValue(" + 
                       Arrays.toString(arr5) + ", " + 
                       Arrays.toString(arr6) + 
                       ", " + d + ") = " +
                       findTheDistanceValue(arr5, arr6, d));

  }
}