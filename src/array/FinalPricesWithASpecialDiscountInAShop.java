package array;
import java.util.Arrays;

public class FinalPricesWithASpecialDiscountInAShop
{
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int l = i + 1;
            while (l < prices.length) {
                if (prices[l] <= prices[i]) {
                    prices[i] = prices[i] - prices[l];
                    break;
                }
                l++;
            }
        }
        return prices;
    }

  public static void readme()
  {
    String str = "You are given an integer array prices where prices[i] is the price of the ith item in a shop.\n\n";

      str += "There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.\n\n";
      
    str += "Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FinalPricesWithASpecialDiscountInAShop.readme();

    // Input: prices = [8,4,6,2,3]
    // Output: [4,2,4,2,3]
    int [] arr1 = {8,4,6,2,3};
    System.out.println("finalPrices(" + Arrays.toString(arr1) + ") = " +
                       Arrays.toString(finalPrices(arr1)));

      // Input: prices = [1,2,3,4,5]
      // Output: [1,2,3,4,5]
      int [] arr2 = {1,2,3,4,5};
      System.out.println("finalPrices(" + Arrays.toString(arr2) + ") = " +
                         Arrays.toString(finalPrices(arr2)));

      // Input: prices = [10,1,1,6]
      // Output: [9,0,1,6]
      int [] arr3 = {10,1,1,6};
      System.out.println("finalPrices(" + Arrays.toString(arr3) + ") = " +
                         Arrays.toString(finalPrices(arr3)));

  }
}