package array;
import java.util.Arrays;

public class LemonadeChange
{
  public static boolean lemonadeChange(int[] bills) 
  {
    int fiveCnt=0;
    int tenCnt=0;

    for (int bill: bills) {
      if (bill == 5) {
        fiveCnt++;
      } else if (bill == 10) {
        if (fiveCnt == 0) {
          return false;
        }
        tenCnt++;
        fiveCnt--;
      } else { //if (bill[i] == 20) { 
        if (tenCnt > 0 && fiveCnt > 0) {
          fiveCnt--;
          tenCnt--;
        } else if (fiveCnt > 2) {
          fiveCnt -= 3;
        } else {
          return false;
        }
      }
    }

      return true;
  }

  public static void readme()
  {
    String str = "At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.\n\n";
    str += "Note that you do not have any change in hand at first.\n\n";

    str += "Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    LemonadeChange.readme();

    // bills = [5,5,5,10,20] = true
    int [] bills1 = {5,5,5,10,20};
    System.out.println("lemonadeChange(" + Arrays.toString(bills1) + ") = " +
                       lemonadeChange(bills1));
    
    // bills = [5,5,10,10,20] = false
    int [] bills2 = {5,5,10,10,20};
    System.out.println("lemonadeChange(" + Arrays.toString(bills2) + ") = " +
                       lemonadeChange(bills2));


  }
}