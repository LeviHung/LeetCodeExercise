package hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap 
{
  public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes)
  {
    HashSet<Integer> set = new HashSet<>();
    int total = 0;
    int totalAlice = 0;
    for (int i = 0; i < aliceSizes.length; i++) {
      total += aliceSizes[i];
    }
    totalAlice = total;

    for (int i = 0; i < bobSizes.length; i++) {
      total += bobSizes[i];
      set.add(bobSizes[i]);
    }
    int resAlice = 0;
    int resBob = 0;
    for (int i = 0; i < aliceSizes.length; i++) {
      resAlice = aliceSizes[i];
      resBob = total/2 - (totalAlice - resAlice);
      if (set.contains(resBob) == true) {
        break;
      }
    }
    return new int[] {resAlice, resBob};
  }
  
  public static int[] fairCandySwapOpt(int[] aliceSizes, int[] bobSizes) 
  {
      int diff = 0;

      boolean[] hash = new boolean[100001];
      for (int val : bobSizes) {
          diff -= val;
          hash[val] = true;
      }

      for (int val : aliceSizes)
          diff += val;
      diff >>= 1;

      for (int val : aliceSizes){
          int required = val - diff;

          if (required > 0 && required < 100001 && hash[required])
              return new int[] { val, required };
      }

      return new int[] { 0, 0 };
  }

  public static void readme()
  {
    String str = "Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.\n\n";

    str += "Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.\n\n";

    str += "Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FairCandySwap.readme();

    // aliceSizes = [1,1], bobSizes = [2,2] => [1,2]
    int [] aliceSizes1 = {1, 1};
    int [] bobSizes1 = {2, 2};

    System.out.println("fairCandySwap(" + Arrays.toString(aliceSizes1) + ", " +
                        Arrays.toString(bobSizes1) + ") = " + 
                        Arrays.toString(fairCandySwap(aliceSizes1, bobSizes1)));

    // aliceSizes = [1,2], bobSizes = [2,3] => [1,2]
    int [] aliceSizes2 = {1, 2};
    int [] bobSizes2 = {2, 3};

    System.out.println("fairCandySwap(" + Arrays.toString(aliceSizes2) + ", " +
                        Arrays.toString(bobSizes2) + ") = " + 
                        Arrays.toString(fairCandySwap(aliceSizes2, bobSizes2)));

    // aliceSizes = [2], bobSizes = [1,3] => [2,3]
    int [] aliceSizes3 = {2};
    int [] bobSizes3 = {1, 3};

    System.out.println("fairCandySwap(" + Arrays.toString(aliceSizes3) + ", " +
                        Arrays.toString(bobSizes3) + ") = " + 
                        Arrays.toString(fairCandySwap(aliceSizes3, bobSizes3)));

    System.out.println("fairCandySwapOpt(" + Arrays.toString(aliceSizes3) + ", " +
      Arrays.toString(bobSizes3) + ") = " + 
      Arrays.toString(fairCandySwapOpt(aliceSizes3, bobSizes3)));

  } 
}