package math;

import java.util.HashSet;
import java.util.LinkedList;

public class HappyNumber
{
  private static final HashSet<Integer> cache = new HashSet<>();

  private static boolean isHappy(int n) 
  {
    //System.out.println("n = " + n);
    if (cache.contains(n)) {
      return false;
    }
    cache.add(n);
    int sum = 0;
    long value = 1;
    while (n / value > 0) {
        //System.out.println("n/value = " + n/value);
        sum += ((n / value) % 10) * ((n / value) % 10);
        //System.out.println("sum = " + sum);
        value = value * 10;
    }

    switch (n) {
      case 1:
      case 10:
      case 100:
      case 1000:
      case 10000:
      case 100000:
      case 1000000:
      case 10000000:
      case 100000000:
      case 1000000000:
        cache.clear();
        return true;
      default:
        return isHappy(sum);
    }    
  }

  public static boolean isHappyOpt(int n) 
  {
    int slow = n;
    int fast = n;
    //while loop is not used here because initially slow and 
    //fast pointer will be equal only, so the loop won't run.

    do {
      //slow moving one step ahead and fast moving two steps ahead
      slow = square(slow);
      fast = square(square(fast));
    } while (slow != fast);
  
    //if a cycle exists, then the number is not a happy number
    //and slow will have a value other than 1
    return slow == 1;
  }

  //Finding the square of the digits of a number
  public static int square(int num) 
  {
    int ans = 0;

    while (num > 0) {
        int remainder = num % 10;
        ans += remainder * remainder;
        num /= 10;
    }

    return ans;
  }
  
  public static void readme()
  {
    String str = "Write an algorithm to determine if a number n is happy.\n\n";

    str += "A happy number is a number defined by the following process:\n";

    str += "Starting with any positive integer, replace the number by the sum of the squares of its digits.\n";

    str += "Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.\n";

    str += "Those numbers for which this process ends in 1 are happy.\n";

    str += "Return true if n is a happy number, and false if not.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    HappyNumber.readme();

    // n = 19 => true
    int n = 19;
    System.out.println("isHappy(" + n + ") = " + HappyNumber.isHappy(n));
    
    // n = 2 => false
    n = 2;
    System.out.println("isHappy(" + n + ") = " + HappyNumber.isHappy(n));
    
    // n = 7 => true
    n = 7;
    System.out.println("isHappy(" + n + ") = " + HappyNumber.isHappy(n));

    n = 1563712132;
    System.out.println("isHappy(" + n + ") = " + HappyNumber.isHappy(n));

    System.out.println("isHappyOpt(" + n + ") = " + HappyNumber.isHappyOpt(n));

  }

}