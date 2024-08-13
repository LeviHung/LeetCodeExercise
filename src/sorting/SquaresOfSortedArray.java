package sorting;
import java.util.Arrays;

public class SquaresOfSortedArray
{
  public static int[] sortedSquares(int[] nums) 
  {
    int[] res = new int [nums.length];
    int posIndex = 0;
    while (posIndex < nums.length) {
      if (nums[posIndex] > 0) {
        break;
      }
      posIndex++;
    }
    
    if (posIndex == 0) {
      for (int i = 0; i < nums.length; i++) {
        res[i] = nums[i] * nums[i];
      }
      return res;
    }

    int negIndex = posIndex - 1;
    int index = 0;
    while (negIndex >= 0 && posIndex < nums.length) {
      if (nums[posIndex] < Math.abs(nums[negIndex])){
        res[index] = nums[posIndex] * nums[posIndex];
        posIndex++;
        index++;
      } else {
        res[index] = nums[negIndex] * nums[negIndex];
        negIndex--;
        index++;
      }
    }
    while (negIndex >= 0) {
      res[index] = nums[negIndex] * nums[negIndex];
      negIndex--;
      index++;
    }
    while(posIndex < nums.length) {
      res[index] = nums[posIndex] * nums[posIndex];
      posIndex++;
      index++;
    }
    return res;
  }
  
  public static int[] sortedSquaresEx(int[] nums) 
  {
    int n = nums.length;
    int[] result = new int[n];
    int left = 0;
    int right = n - 1;
    int position = n - 1;
    while (left <= right) {
      int leftSquare = nums[left] * nums[left];
      int rightSquare = nums[right] * nums[right];
      if (leftSquare > rightSquare) {
        result[position] = leftSquare;
        left++;
      } else {
        result[position] = rightSquare;
        right--;
      }
      position--;
    }
    return result;
  }
  
  public static void readme()
  {
    String str = "Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SquaresOfSortedArray.readme();

    // nums = [-4,-1,0,3,10] => [0,1,9,16,100]
    int [] nums1 = {3,1,2,4};
    System.out.println("sortedSquares(" + Arrays.toString(nums1) + 
       ") = " +
       Arrays.toString(sortedSquares(nums1)));

    // nums = [-7,-3,2,3,11] => [4,9,9,49,121]
    int [] nums2 = {-7,-3,2,3,11};
    System.out.println("sortedSquares(" + Arrays.toString(nums2) + 
                       ") = " +
                       Arrays.toString(sortedSquares(nums2)));

    System.out.println("sortedSquaresEx(" + Arrays.toString(nums2) + 
       ") = " +
       Arrays.toString(sortedSquaresEx(nums2)));

  }
}