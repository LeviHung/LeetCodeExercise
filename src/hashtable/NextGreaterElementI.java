package hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElementI
{
  public static int[] nextGreaterElement(int[] nums1, int[] nums2)
  {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    int[] ans = new int [nums1.length];

    int j = 0;
    for (int i = 0; i < nums2.length; i++) {
      j = i + 1;
      while (j < nums2.length) {
        if (nums2[j] > nums2[i]) {
          map.put(nums2[i], nums2[j]);
          break;
        }
        j++;
      }
      if (map.containsKey(nums2[i]) == false) {
        map.put(nums2[i], -1);
      }
    }

    for (int i = 0; i < nums1.length; i++) {
      ans[i] = map.get(nums1[i]);
    }
    
    return ans;
  }
  public static int[] nextGreaterElementOpt(int[] nums1, int[] nums2) 
  {
    int[] count = new int[10001];
    for(int i=0;i<nums2.length;i++)
      count[nums2[i]] = i;

    for(int i=0;i<nums1.length;i++){
      nums1[i] = next(count[nums1[i]], nums2);
    }
    
    return nums1;
  }

  private static int next(int index, int[] nums2)
  {
      for(int i=index+1;i<nums2.length;i++){
          if(nums2[i] > nums2[index])
              return nums2[i];
      }
      return -1;
  }

  public static void readme()
  {
    String str = "The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.\n\n";

    str += "You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.\n\n";

    str += "For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.\n\n";

    str += "Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    NextGreaterElementI.readme();

    // nums1 = [4,1,2], nums2 = [1,3,4,2] => [-1,3,-1]
    int [] nums1 = {4,1,2};
    int [] nums2 = {1,3,4,2};
    System.out.println("nextGreaterElement(" + Arrays.toString(nums1) + 
                       ", " + Arrays.toString(nums2) + ") = " +
                       Arrays.toString(nextGreaterElement(nums1, nums2)));

    // nums1 = [2,4], nums2 = [1,2,3,4] => [3,-1]
    int [] nums3 = {2,4};
    int [] nums4 = {1,2,3,4};
    System.out.println("nextGreaterElement(" + Arrays.toString(nums3) + 
                       ", " + Arrays.toString(nums4) + ") = " +
                       Arrays.toString(nextGreaterElement(nums3, nums4)));
    
    System.out.println("nextGreaterElementOpt(" + Arrays.toString(nums3) + 
                       ", " + Arrays.toString(nums4) + ") = " +
                       Arrays.toString(nextGreaterElementOpt(nums3, nums4)));

  }
}