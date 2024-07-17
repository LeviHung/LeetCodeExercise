package array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindAllNumbersDisappear
{
  public static List<Integer> findDisappearedNumbers(int[] nums)
  {
    List<Integer> list = new ArrayList<>();
    int [] array = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      array[nums[i] - 1] = 1;
    }

    for (int i = 0; i < nums.length; i++) {
      if (array[i] != 1) {
        list.add(i + 1);
      }
    }

    return list;
  }
  
  public static List<Integer> findDisappearedNumbersEx(int[] nums)
  {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(nums[i]);
    }
    list.add(1);
    
    for (int i = 0; i < nums.length; i++) {
      list.set(nums[i], 0);
    }
    list.set(0, 0);

    int count = 0;
    System.out.println(Arrays.toString(list.toArray()));
    for (int i = 0; i < nums.length + 1; i++) {
      if (list.get(i) != 0) {
        list.set(count++, i);
      }
    }
    
    for (int i = nums.length; i >= count; i--) {
      list.remove(i);
    }
    
    return list;
  }

  public static void readme()
  {
    String str = "Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindAllNumbersDisappear.readme();

    // nums = [4,3,2,7,8,2,3,1] => [5,6]
    int [] nums1 = {4,3,2,7,8,2,3,1};
    System.out.println("findDisappearedNumbers(" + Arrays.toString(nums1) + ") = ");
    List<Integer> list1 = findDisappearedNumbers(nums1);
    System.out.println(Arrays.toString(list1.toArray()));

    // nums = [1, 1] => [2]
    int [] nums2 = {1, 1};
    System.out.println("findDisappearedNumbers(" + Arrays.toString(nums2) + ") = ");
    List<Integer> list2 = findDisappearedNumbers(nums2);
    System.out.println(Arrays.toString(list2.toArray()));

  }
}