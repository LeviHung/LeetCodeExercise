package array;
import java.util.Arrays;

public class DegreeOfArray
{
  public static int findShortestSubArray(int[] nums)
  {
    if (nums.length == 1) {
      return 1;
    }
    int[][] array = new int [3][50001];
    for (int i = 0; i < nums.length; i++) {
      array[0][nums[i]]++;
      if (array[0][nums[i]] == 1) {
          array[1][nums[i]] = i;
          array[2][nums[i]] = i;
      } else {
          array[2][nums[i]] = i;
      }
    }
    int max = 0;
    int min = 50000;
    int total = 0;
    for (int i = 0; i < array[0].length && total < nums.length; i++) {
      total += array[0][i];
      if (array[0][i] > max) {
          max = array[0][i];
          min = 50000;
          if (array[2][i] - array[1][i] < min)
              min = array[2][i] - array[1][i];
      } else if (array[0][i] == max && array[0][i] != 0) {
          if (array[2][i] - array[1][i] < min)
              min = array[2][i] - array[1][i];
      }
    }
    
    return min + 1;
  }

  public static int findShortestSubArrayOpt(int[] nums) 
  {
    int max = -1;
    for (int i=0; i<nums.length;i++)
        if (nums[i] > max) max = nums[i];

    MinMax [] minmax = new MinMax[max + 1];
    int maxfreq = 0;
    for (int i=0; i<nums.length;i++) {
        if (minmax[nums[i]] == null)
            minmax[nums[i]] = new MinMax(i);
        minmax[nums[i]].max = i;
        minmax[nums[i]].count++;

        if (minmax[nums[i]].count > maxfreq)
            maxfreq = minmax[nums[i]].count;
    }
    int minarray = Integer.MAX_VALUE;
    for (int i=0; i<minmax.length;i++) {
        if (minmax[i] != null && minmax[i].count == maxfreq)
            minarray = Math.min(minarray, minmax[i].max - minmax[i].min + 1);
    }
    return minarray;
  }

  private static class MinMax {
    int count = 0;
    int min = -1;
    int max = -1;

    public MinMax(int i) {
        min = i;
        max = i;
    }
  }
  
  public static void readme()
  {
    String str = "Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.\n\n";

    str += "Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DegreeOfArray.readme();

    // nums = [1,2,2,3,1] => 2
    int [] nums1 = {1,2,2,3,1};
    System.out.println("findShortestSubArray(" + Arrays.toString(nums1) + ") = " +
                       findShortestSubArray(nums1));

    // nums = [1,2,2,3,1,4,2] => 6
   int [] nums2 = {1,2,2,3,1,4,2};
    System.out.println("findShortestSubArray(" + Arrays.toString(nums2) + ") = " +
                       findShortestSubArray(nums2));

    System.out.println("findShortestSubArrayOpt(" + Arrays.toString(nums2) + ") = " +
     findShortestSubArrayOpt(nums2));

  }
}