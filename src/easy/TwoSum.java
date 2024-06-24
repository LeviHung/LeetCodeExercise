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
}