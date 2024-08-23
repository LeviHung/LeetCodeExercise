package sorting;
import java.util.Arrays;

public class SortIntegersByNumberOfOneBits
{
    public static int[] sortByBits(int[] arr) {
        int[] res = new int [arr.length];
        int[][] bit = new int [16][1000];
        int index = 0;
        for (int val: arr) {
            if (val == 0) {
                res[index++] = 0;
            } else {
                int numBit = checkBit(val);
                int space = freeSpace(bit[numBit]);
                bit[numBit][space] = val;
            } 
        }
        for (int i = 1; i < bit.length; i++) {
            spaceSort(bit[i]);
            for (int j = 0; j < bit[0].length; j++) {
                if (bit[i][j] > 0) {
                    res[index++] = bit[i][j];
                    if (index > arr.length) {
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public static int checkBit(int n) {
        int res = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                res++;
            }
            n = n / 2;
        }
        return res;
    }

    public static int freeSpace(int[] space) {
        for (int i = 0; i < space.length; i++) {
            if (space[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void spaceSort(int [] space) {
        if (space[0] == 0) {
            return;
        }
        Arrays.sort(space);
    }

    public static int[] sortByBitsOpt(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; ++i) {
            arr[i] %= 100000;
        }
        return arr;
    }
    
  public static void readme()
  {
    String str = "You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.\n\n";

    str += "Return the array after sorting it.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SortIntegersByNumberOfOneBits.readme();

    // Input: arr = [0,1,2,3,4,5,6,7,8]
    // Output: [0,1,2,4,8,3,5,6,7]
    int [] arr1 = {0,1,2,3,4,5,6,7,8};
    System.out.println("sortByBits(" + Arrays.toString(arr1) +  ") = " +
       Arrays.toString(sortByBits(arr1)));

    // Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
    // Output: [1,2,4,8,16,32,64,128,256,512,1024]


    int [] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
    System.out.println("sortByBits(" + Arrays.toString(arr2) + ") = " +
                       Arrays.toString(sortByBits(arr2)));

    System.out.println("sortByBitsOpt(" + Arrays.toString(arr2) + ") = " +
                       Arrays.toString(sortByBitsOpt(arr2)));

  }
}