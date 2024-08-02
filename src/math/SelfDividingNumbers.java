package math;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SelfDividingNumbers
{
  public static List<Integer> selfDividingNumbers(int left, int right)
  {
    List<Integer> list = new ArrayList<>();
    boolean isSelfDividing = true;
    for (int i = left; i <= right; i++) {
      isSelfDividing = true;
      int num = i;
      while (num > 0) {
        if ((num % 10) == 0 || i % (num % 10) != 0) {
          isSelfDividing = false;
          break;
        }
        num = num / 10;
      }
      if (isSelfDividing) {
        list.add(i);
      }
    }

    return list;
  }

  public static List<Integer> selfDividingNumbersOpt(int left, int right) 
  {
    ArrayList<Integer> a1 = new ArrayList<Integer>();
    for (int i = left; i <= right; i++) {
        if (isSelfDividing(i)) {
            a1.add(i);
        }
    }
    return a1;
  }

  public static boolean isSelfDividing(int num)
  {
    int originalNum = num;
    while (num > 0) {
        int digit = num % 10;
        if (digit == 0 || originalNum % digit != 0) {
            return false;
        }
        num /= 10;
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "A self-dividing number is a number that is divisible by every digit it contains.\n\n";

    str += "For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.\n\n";
    
    str += "A self-dividing number is not allowed to contain the digit zero.\n\n";
    
    str += "Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].\n";

    System.out.println(str);
  }

  public static void main()
  {
    SelfDividingNumbers.readme();

    int left;
    int right;
    // left = 1, right = 22 => [1,2,3,4,5,6,7,8,9,11,12,15,22]
    left = 1;
    right = 22;
    System.out.println("selfDividingNumbers(" + left + ", " + right + ") = ");
    List list1 = selfDividingNumbers(left, right);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }

    // left = 47, right = 85 => [48,55,66,77]
    left = 47;
    right = 85;
    System.out.println("selfDividingNumbers(" + left + ", " + right + ") = ");
    List list2 = selfDividingNumbers(left, right);
    if (list2 != null) {
      System.out.println(Arrays.toString(list2.toArray()));
    }
    
    System.out.println("selfDividingNumbersOpt(" + left + ", " + right + ") = ");
    List list3 = selfDividingNumbersOpt(left, right);
    if (list3 != null) {
      System.out.println(Arrays.toString(list3.toArray()));
    }

  }
}