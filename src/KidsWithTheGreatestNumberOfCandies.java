package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KidsWithTheGreatestNumberOfCandies
{
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> list = new ArrayList<>();
        for (int i = 1; i < candies.length; i++)
            if (candies[i] > max) max = candies[i];
        for (int val: candies) 
            list.add(val >= max - extraCandies);

        return list;
    }
    
  public static void readme()
  {
    String str = "There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.\n\n";

    str += "Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.\n\n";

    str += "Note that multiple kids can have the greatest number of candies.\n";

    System.out.println(str);
  }

  public static void main()
  {
    KidsWithTheGreatestNumberOfCandies.readme();

    int extraCandies;

    // Input: candies = [2,3,5,1,3], extraCandies = 3
    // Output: [true,true,true,false,true] 
    int[] candies1 = {2,3,5,1,3};
    extraCandies = 3;
    System.out.println("kidsWithCandies(" + Arrays.toString(candies1) +
                       ", " + extraCandies + ") = ");
    List list1 = kidsWithCandies(candies1, extraCandies);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }

    // Input: candies = [4,2,1,1,2], extraCandies = 1
    // Output: [true,false,false,false,false] 
      int[] candies2 = {4,2,1,1,2};
      extraCandies = 1;
      System.out.println("kidsWithCandies(" + Arrays.toString(candies2) +
                         ", " + extraCandies + ") = ");
      List list2 = kidsWithCandies(candies2, extraCandies);
      if (list2 != null) {
        System.out.println(Arrays.toString(list2.toArray()));
      }

      // Input: candies = [12,1,12], extraCandies = 10
    // Output: [true,false,true]
    int[] candies3 = {2,3,5,1,3};
    extraCandies = 3;
    System.out.println("kidsWithCandies(" + Arrays.toString(candies3) + 
                       ", " + extraCandies + ") = ");
    List list3 = kidsWithCandies(candies3, extraCandies);
    if (list3 != null) {
      System.out.println(Arrays.toString(list3.toArray()));
    }

  }
}