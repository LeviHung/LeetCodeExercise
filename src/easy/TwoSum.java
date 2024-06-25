// Levi Hung
// 06/24/2024
// LeetCode Exercise

package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum 
{
    public static int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> twoSumMap = new HashMap<>();
    
        int [] foundIndex = new int[2];
    
        for (int i = 0; i < nums.length; i++) {
            if (twoSumMap.get(nums[i]) != null) {
                foundIndex[0] = twoSumMap.get(nums[i]);
                foundIndex[1] = i;
                return foundIndex;
            } else {
                twoSumMap.put(Integer.valueOf(target - nums[i]), 
                              Integer.valueOf(i));
            }
        }
    
        return null;
    }
    
    public static void readme()
    {
        String str = "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n\n";

        str += "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n\n";

        str += "You can return the answer in any order.\n";

        System.out.println(str);
    }
}