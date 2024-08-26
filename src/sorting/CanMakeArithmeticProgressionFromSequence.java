package sorting;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence
{
  public static boolean canMakeArithmeticProgression(int[] arr) {
    if (arr.length == 2) {
        return true;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int val: arr) {
        max = Math.max(val, max);
        min = Math.min(val, min);
    }
    int diff = (max-min) / (arr.length - 1);
    if (max == min) {
        return true;
    }

    if ((max - min) % (arr.length - 1) != 0) {
        return false;
    }

    boolean[] freq = new boolean [max - min + 1];
    for (int val: arr) {
        freq[val - min]= true;
    }
    int len = max - min;
    for (int i = diff; i < len; i = i + diff) {
        if (freq[i] != true) {
            return false;
        }
    }
    return true;
    /*
    Arrays.sort(arr);
    int diff = arr[1] - arr[0];
    for (int i = 2; i < arr.length; i++) {
        if (arr[i] - arr[i-1] != diff) {
            return false;
        }
    }
    return true;
    */
  }

  public static boolean canMakeArithmeticProgressionOpt(int[] arr) {
    int mn = 0;
    int mx = 0;
    boolean[] mem = new boolean[arr.length];
    int n = arr.length - 1;
    for(int i = 1; i <= n; i++)
    {
        if(arr[i] < arr[mn])
        {
            mn = i;
        }
        else if(arr[i] > arr[mx])
        {
            mx = i;
        }
    }

    if(arr[mn] == arr[mx])
        return true;

    if((arr[mx] - arr[mn]) % n != 0)
        return false;
    int d = (arr[mx] - arr[mn]) / n;

    mem[0] = true;
    mem[n] = true;

    for(int i = 0; i <= n; i++)
    {
        if(i == mn || i == mx)
            continue;
        if((arr[i] - arr[mn]) % d != 0)
            return false;
        int di = (arr[i] - arr[mn]) / d;
        if(mem[di])
            return false;
        mem[di] = true;
    }

    return true;
  }

  public static void readme()
  {
    String str = "A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.\n\n";

      str += "Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CanMakeArithmeticProgressionFromSequence.readme();

    // Input: arr = [3,5,1]
    // Output: true
    int [] arr1 = {3,5,1};
    System.out.println("canMakeArithmeticProgression(" + Arrays.toString(arr1) + ") = " +
                       canMakeArithmeticProgression(arr1));

    // Input: arr = [1,2,4]
    // Output: false
    int [] arr2 = {1,2,4};
    System.out.println("canMakeArithmeticProgression(" + Arrays.toString(arr2) + ") = " +
                       canMakeArithmeticProgression(arr2));

    // Input: arr = [1,2,4]
    // Output: false
    int [] arr3 = {1,2,4};
    System.out.println("canMakeArithmeticProgressionOpt(" + Arrays.toString(arr2) + ") = " +
                       canMakeArithmeticProgressionOpt(arr3));

  }
}