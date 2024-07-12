package array;

import java.util.Arrays;

public class MergeSortedArray
{
  public static void merge(int[] nums1, int m, int[] nums2, int n)
  {
    // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    int[] nums = new int[m];
    for (int i = 0; i < m; i++) {
      nums[i] = nums1[i];
    }

    int index1 = 0;
    int index2 = 0;
    for (int i = 0; i < m + n; i++) {
      if (index1 < m && index2 < n && nums[index1] < nums2[index2]) {
        nums1[i] = nums[index1++];
      } else if (index1 < m && index2 < n && nums[index1] >= nums2[index2]) {
        nums1[i] = nums2[index2++];
      } else if (index1 >= m) {
        nums1[i] = nums2[index2++];
      } else if (index2 >= n) {
        nums1[i] = nums[index1++];
      }
    }
  }

  public static void readme()
  {
    String str = "You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.\n\n";

    str += "Merge nums1 and nums2 into a single array sorted in non-decreasing order.\n\n";

    str += "The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MergeSortedArray.readme();

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    int [] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int [] nums2 = {2, 5, 6};
    int n = 3;

    System.out.print("merge(" + Arrays.toString(nums1) + ", " + 
                       Arrays.toString(nums2) + ") = ");
    MergeSortedArray.merge(nums1, m, nums2, n);

    System.out.println(Arrays.toString(nums1));

    // nums1 = [1], m = 1, nums2 = [], n = 0
    int [] nums3 = {1};
    m = 1;
    int [] nums4 = {};
    n = 0;

    System.out.print("merge(" + Arrays.toString(nums3) + ", " + 
                       Arrays.toString(nums4) + ") = ");
    MergeSortedArray.merge(nums3, m, nums4, n);

    System.out.println(Arrays.toString(nums3));

    // nums1 = [0], m = 0, nums2 = [1], n = 1
    int [] nums5 = {0};
    m = 0;
    int [] nums6 = {1};
    n = 1;

    System.out.print("merge(" + Arrays.toString(nums5) + ", " + 
                       Arrays.toString(nums6) + ") = ");
    MergeSortedArray.merge(nums5, m, nums6, n);

    System.out.println(Arrays.toString(nums5));

    int [] nums7 = {2, 0};
    m = 1;
    int [] nums8 = {1};
    n = 1;

    System.out.print("merge(" + Arrays.toString(nums7) + ", " + 
                       Arrays.toString(nums8) + ") = ");
    MergeSortedArray.merge(nums7, m, nums8, n);

    System.out.println(Arrays.toString(nums7));
  }
}