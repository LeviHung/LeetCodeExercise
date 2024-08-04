package hashtable;
import java.util.Arrays;
import java.util.HashSet;

public class DistributeCandies
{
  public static int distributeCandies(int[] candyType) 
  {
    HashSet <Integer> type = new HashSet<>();
    //for (int i = 0; i < candyType.length; i++) {
    for (int i: candyType) {
        type.add(i);
    }

    //int sum = Math.min(candyType.length / 2, type.size());
    //return sum;
    return Math.min(candyType.length / 2, type.size());
  }

  public static int distributeCandiesOpt(int[] candyType) 
  {
    final boolean[] containsType = new boolean[200001]; // 2 * Math.pow(10, 5) + 1
    final int maxCount = candyType.length / 2;
    int counter = 0;
    for (int i = 0; i < candyType.length; i++) {
        final int type = candyType[i];
        if (!containsType[100000 + type]) {
            containsType[100000 + type] = true;
            counter++;
    
            if (counter > maxCount) {
                return maxCount;
            }
        }            
    }
    return counter;
  }

  public static void readme()
  {
    String str = "Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.\n\n";

    str += "The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.\n\n";

    str += "Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    DistributeCandies.readme();

    // candyType = [1,1,2,2,3,3] => 3
    int [] candyType1 = {1,1,2,2,3,3};
    System.out.println("distributeCandies(" + Arrays.toString(candyType1) +
                       ") = " +
                       distributeCandies(candyType1));

    // candyType = [1,1,2,3] => 2
    int [] candyType2 = {1,1,2,3};
    System.out.println("distributeCandies(" + Arrays.toString(candyType2) +
                       ") = " +
                       distributeCandies(candyType2));

    // candyType = [6,6,6,6] => 1
    int [] candyType3 = {6,6,6,6};
    System.out.println("distributeCandies(" + Arrays.toString(candyType3) +
                       ") = " +
                       distributeCandies(candyType3));

  }
}