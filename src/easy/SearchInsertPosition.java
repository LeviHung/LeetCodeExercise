package easy;

public class SearchInsertPosition
{
  public static int searchInsert(int[] nums, int target) 
  {
    //  0  1  2  3  4
    // {1, 3, 5, 6}    target = 5
    // {1, 3, 5, 6}    target = 2
    // {1}             target = 0
    int i = 0;
    int j = nums.length - 1;
    int k = 0;
    int lowIndex = 0;
    int highIndex = nums.length - 1;

    while (i <= j) {
      k = (i + j) / 2;
      if (target > nums[k]) {
        i = k + 1;
        lowIndex = k;
      } else if (target < nums[k]) {
        j = k - 1;
        highIndex = k;
      } else {
        return k;  
      }
    }
        
    if (highIndex == lowIndex) {
      if (nums.length == 1) {
        if (target > nums[0]) {
          highIndex++;
        }
      } else if (highIndex == nums.length - 1) {
        highIndex++;
      }
      
      return highIndex;
    
    } else if (highIndex > lowIndex) {
      return highIndex;
      
    } else {
      return lowIndex;
    }
  }


  public static void readme()
  {
    String str = "Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.\n\n";

    str += "You must write an algorithm with O(log n) runtime complexity.\n";

    System.out.println(str);
  }
}