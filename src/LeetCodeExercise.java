// Levi Hung
// 06/24/2024
// LeetCode Exercise

import easy.TwoSum;

class LeetCodeExercise 
{
  public static void main(String[] args)
  {
    int [] nums = {2, 3, 4};
    int target = 6;

    System.out.println("twoSum([2, 3, 4], 6) = " + 
                       Solution.twoSum(nums, target)[0] +
                       ", " +
                       Solution.twoSum(nums, target)[1]);
  }
}