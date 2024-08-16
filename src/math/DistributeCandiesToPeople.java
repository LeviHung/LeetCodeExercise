package math;

import java.util.Arrays;

public class DistributeCandiesToPeople
{
  public static int[] distributeCandies(int candies, int num_people) 
  {
    int[] res = new int [num_people];
    int index = 0;
    int num = 1;
    while (candies > 0) {
        res[index % num_people] = res[index % num_people] + num;
        candies = candies - num;
        index++;
        num++; 
        if (num > candies)
            num = candies;
    } 
    return res;
  }
  
  public static int[] distributeCandiesEx(int candies, int num_people) 
  {
    int[]res = new int [num_people];
    int firstRun  = (1 + num_people) * num_people / 2;
    int secondRun = (1 + num_people + 2 * num_people) * num_people / 2 + firstRun;
    int thirdRun  = (1 + num_people * 2 + 3 * num_people) * num_people / 2 + secondRun;
    int startIndex = 0;
    int index = 0;
    // 1 2 3 4
    // 5 6 7 8
    // 9 10 11 12
    if (candies > thirdRun) {
        int num = 1 + 3 * num_people;
        candies = candies - thirdRun;
        if (num > candies)
            num = candies;
        for (int i = 0; i < num_people; i++) {
            res[i] = (i + 1) * 3 + num_people * 3 + num;
            candies = candies - num;
            num++; 
            if (num > candies)
                num = candies;
        }
  
    } else if (candies > secondRun) {
        int num = 1 + 2 * num_people;
        candies = candies - secondRun;
        if (num > candies)
            num = candies;
        for (int i = 0; i < num_people; i++) {
            res[i] = (i + 1) * 2 + num_people + num;
            candies = candies - num;
            num++; 
            if (num > candies)
                num = candies;
        }
  
    } else if (candies > firstRun) {
        int num = 1 + num_people;
        if (num > candies)
            num = candies;
        candies = candies - firstRun;
        for (int i = 0; i < num_people; i++) {
            res[i] = i + 1 + num;
            candies = candies - num;
            num++; 
            if (num > candies)
                num = candies;
        }
    } else {
        int num = 1;
        while (candies > 0) {
            res[index % num_people] = res[index % num_people] + num;
            candies = candies - num;
            index++;
            num++; 
            if (num > candies)
                num = candies;
        } 
    }
    return res;
  }

  public static int[] distributeCandiesOpt(final int totalCandies, final int numOfPeople) 
  {
      int n = (int) Math.sqrt(2 * totalCandies);
      final int[] distribution = new int[numOfPeople];

      while(n * (n + 1) / 2 > totalCandies)
          n--;

      final int fullCycles = n / numOfPeople;
      int remainingCandies = totalCandies - numOfPeople * fullCycles * (numOfPeople * fullCycles + 1) / 2;

      for(int i = 1; i <= numOfPeople; i++) {
          distribution[i - 1] = fullCycles * i + fullCycles * (fullCycles - 1) * numOfPeople / 2 + Math.min(fullCycles * numOfPeople + i, remainingCandies);
          remainingCandies -= Math.min(fullCycles * numOfPeople + i, remainingCandies);
      }

      return distribution;
  }
    
  public static void readme()
  {
    String str = "We distribute some number of candies, to a row of n = num_people people in the following way:\n\n";

    str += "We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.\n\n";

    str += "Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.\n\n";

    str += "This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).\n\n";

    str += "Return an array (of length num_people and sum candies) that represents the final distribution of candies.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DistributeCandiesToPeople.readme();

    int candies;
    int num_people;
    // Input: candies = 7, num_people = 4
    // Output: [1,2,3,1]
    candies = 7;
    num_people = 4;
    System.out.println("distributeCandies(" + candies + ", " + num_people + ") = " + 
                        Arrays.toString(distributeCandies(candies, num_people)));

    // Input: candies = 10, num_people = 3
    // Output: [5,2,3]
    candies = 10;
    num_people = 3;
    System.out.println("distributeCandies(" + candies + ", " + num_people + ") = " + 
                        Arrays.toString(distributeCandies(candies, num_people)));

    System.out.println("distributeCandiesOpt(" + candies + ", " + num_people + ") = " + 
    Arrays.toString(distributeCandiesOpt(candies, num_people)));

  }
}