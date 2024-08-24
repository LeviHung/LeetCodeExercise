package sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSubsequenceInNonIncreasingOrder
{
    public static List<Integer> minSubsequence(int[] nums) {
        // 98.54%
        List<Integer> list = new ArrayList<>();
        int[] freq = new int [101];
        int total = 0;
        for (int val: nums) {
            freq[val]++;
            total += val;
        }

        int subSeqSum = 0;
        int index = 0;
        for (int i = 100; i > 0; i--) {
            while (freq[i] > 0) {
                list.add(i);
                subSeqSum += i;
                freq[i]--;
                if (subSeqSum > total - subSeqSum) {
                    return list;
                }
            }
        }

        return list;

        // 94.13%
        /*
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int subSeqSum = 0;
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            subSeqSum += nums[i];
            if (subSeqSum > total - subSeqSum) {
                index = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= index; i--) {
            list.add(nums[i]);
        }
        return list;
        */
    }

  public static void readme()
  {
    String str = "Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.\n\n";

    str += " If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.n\n";

    str += "ote that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumSubsequenceInNonIncreasingOrder.readme();

    // Input: nums = [4,3,10,9,8]
    // Output: [10,9]

    int[] nums1 = {4,3,10,9,8};
    System.out.println("minSubsequence(" + Arrays.toString(nums1) + ") = ");
    List<Integer> list1 = minSubsequence(nums1);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: nums = [4,4,7,6,7]
    // Output: [7,7,6] 

    int[] nums2 = {4,4,7,6,7};
    System.out.println("minSubsequence(" + Arrays.toString(nums2) + ") = ");
    List<Integer> list2 = minSubsequence(nums2);
    System.out.println(Arrays.toString(list2.toArray()));
    }
}