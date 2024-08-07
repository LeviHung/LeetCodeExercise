package dynamic;

import java.util.Arrays;

public class BestTimeBuySellStock
{
  public static int maxProfit(int[] prices)   
  {
    int l = 0;
    int r = 1;
    int maxP = 0;
    int profit = 0;
    // prices = [7,1,5,3,6,4] => 5
    // prices = [7,6,4,3,1]
    // prices = [1,4,1,4,3,1] 
    // prices = [2,4,1]
    // prices = [3,3,5,0,0,3,1,4]
    while (r < prices.length) {
      if (prices[l] < prices[r]) {
          profit = prices[r] - prices[l];
          if (profit > maxP) {
            maxP = profit;
          }
      } else {
        l = r;
      }
      r++;
    }
    return maxP;
    /*
    for (int i = 0; i < prices.length; i++) {
      for (int j = i; j < prices.length; j++) {
        if (prices[j] - prices[i] > maxP) {
          maxP = prices[j] - prices[i];
        }
      }
    }
    return maxP;
    */
  }

  public static void readme()
  {
    String str = "You are given an array prices where prices[i] is the price of a given stock on the ith day.\n\n";

    str += "You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.\n\n";

    str += "Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.\n";

    System.out.println(str);
  }

  public static void main()
  {
    BestTimeBuySellStock.readme();


    // prices = [7,1,5,3,6,4] => 5
    int [] prices1 = {7,1,5,3,6,4};

    System.out.println("maxProfit(" + Arrays.toString(prices1) + 
                     ") = " + BestTimeBuySellStock.maxProfit(prices1));

    //prices = [7,6,4,3,1] => 0
    int [] prices2 = {7,6,4,3,1};
    System.out.println("maxProfit(" + Arrays.toString(prices2) + 
     ") = " + BestTimeBuySellStock.maxProfit(prices2));


    int [] prices3 = {1,4,1,4,3,1};
    System.out.println("maxProfit(" + Arrays.toString(prices3) + 
          ") = " + BestTimeBuySellStock.maxProfit(prices3));


    int [] prices4 = {2, 4, 1};
    System.out.println("maxProfit(" + Arrays.toString(prices4) + 
         ") = " + BestTimeBuySellStock.maxProfit(prices4));


    int [] prices5 = {3,3,5,0,0,3,1,4};
    System.out.println("maxProfit(" + Arrays.toString(prices5) + 
         ") = " + BestTimeBuySellStock.maxProfit(prices5));

  }
}