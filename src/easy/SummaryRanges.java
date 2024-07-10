package easy;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SummaryRanges
{
  public static List<String> summaryRanges(int[] nums) 
  {
    // nums = [0,1,2,4,5,7] =>  ["0->2","4->5","7"]
    StringBuilder sb = new StringBuilder();
    
    List<String> list = new ArrayList<>();
    if (nums.length == 0) {
      return list;
    }
    
    int startValue = 0;
 
    startValue = nums[0];
    sb.append(startValue);
    if (nums.length == 1) {
      list.add(sb.toString());
      return list;
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i-1] + 1) {
        if (nums[i-1] != startValue) {
          sb.append("->" + nums[i-1]);
        }
        list.add(sb.toString());
        sb.setLength(0);
        startValue = nums[i];
        sb.append(nums[i]);
        if (i == (nums.length - 1))  {
          list.add(sb.toString());
        }
      }
      else 
      {
        if (i == (nums.length - 1))  {
          sb.append("->" + nums[i]);
          list.add(sb.toString());
        }
      }
    }
    
    return list;
  }

  public static List<String> summaryRangesOpt(int[] nums) 
  {
    List<String> summaryOfTheRange = new ArrayList<String>();
    if (nums.length == 0) 
      return summaryOfTheRange;

    String subRange = "";
    int start = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i-1] + 1 != nums[i]) { 
            subRange = getRange(start, nums[i-1]);
            summaryOfTheRange.add(subRange);
            start = nums[i];
        }
    }
    subRange = getRange(start, nums[nums.length-1]);
    summaryOfTheRange.add(subRange);
    return summaryOfTheRange;
  }

  public static String getRange(int start, int end) 
  {
    StringBuilder sb = new StringBuilder();
    sb.append(start);
    if (start != end) {
      sb.append("->").append(end);
    }
    return sb.toString();
  }
  
  public static void readme()
  {
    String str = "You are given a sorted unique integer array nums.\n\n";

    str += "A range [a,b] is the set of all integers from a to b (inclusive).\n\n";

    str += "Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.\n\n";

    str += "Each range [a,b] in the list should be output as:\n\n";

    str += "\"a->b\" if a != b\n\n";

    str += "\"a\" if a == b\n";

    System.out.println(str);
  }

  public static void main()
  {
    SummaryRanges.readme();

    
    // nums = [0,1,2,4,5,7] =>  ["0->2","4->5","7"]
    int[] nums1 = {0,1,2,4,5,7};
    System.out.print("summaryRanges(" + Arrays.toString(nums1) + ") = ");
    System.out.println(summaryRanges(nums1));
    
    // nums = [0,2,3,4,6,8,9] => ["0","2->4","6","8->9"]
    int[] nums2 = {0,2,3,4,6,8,9};
    System.out.print("summaryRanges(" + Arrays.toString(nums2) + ") = ");
    System.out.println(summaryRanges(nums2));
    
    System.out.print("summaryRangesOpt(" + Arrays.toString(nums2) + ") = ");
    System.out.println(summaryRangesOpt(nums2));
  }
}