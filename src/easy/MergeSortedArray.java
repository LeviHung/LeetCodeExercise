package easy;

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
}