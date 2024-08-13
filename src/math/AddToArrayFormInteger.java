package math;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddToArrayFormInteger
{
  public static List<Integer> addToArrayForm(int[] num, int k) 
  {
    List <Integer> res = new ArrayList<>();
    for (int i = num.length - 1; i >= 0; i--) {
      res.add((num[i] + k) % 10);
      k = (num[i] + k) / 10;
    }
    while (k > 0) {
      res.add(k % 10);
      k = k / 10;
    }

    Collections.reverse(res);  
    return res;
    /*
    List <Integer> res = new ArrayList<>();
    int carry = 0;
    int remain = 0;
    int index = 0;
    for (int i = num.length - 1; i >= 0; i--) {
        remain = (num[i] + k % 10 + carry) % 10;
        carry =  (num[i] + k % 10 + carry) / 10;
        k = k/10;
        res.add(remain);
    }
    while (k > 0) {
        remain = (k % 10 + carry) % 10;
        carry =  (k % 10 + carry) / 10;
        k = k/10;
        res.add(remain);
    }

    if (carry == 1) {
        res.add(carry);
    }
    Collections.reverse(res);  
    return res;
    */
    // Use array
    /*
    int carry = 0;
    int remain = 0;
    int bits = Integer.bitCount(k);
    int len = Math.max(bits, num.length);
    int[] res = new int[len + 1];
    int index = 0;
    for (int i = num.length - 1; i >= 0; i--) {
        int total = num[i] + k % 10 + carry;
        remain = total % 10;
        carry =  total / 10;
        k = k/10;
        res[index++] = remain;
    }
    while (k > 0) {
        int total = k % 10 + carry;
        remain = total % 10;
        carry =  total / 10;
        k = k/10;
        res[index++] = remain;
    }

    if (carry == 1) {
        res[index] = carry;
    } else {
        index = index - 1;
    }

    List <Integer> list = new ArrayList<>();
    for (int i = index; i >= 0; i--) {
        list.add(res[i]);
    }

    return list;
    */
  }

  public static List<Integer> addToArrayFormOpt(int[] num, int k) 
  {
      List<Integer> result = new ArrayList<>();
      int carry = 0;
      for (int i = num.length - 1; i >= 0 && (k > 0 || carry == 1); i--) {
          int curr = k % 10;
          k /= 10;
          num[i] += curr + carry;
          carry = 0;
          if (num[i] > 9) {
              num[i] %= 10;
              carry = 1;
          }
      }
      k += carry;
      while (k > 0) {
         result.add(0, k % 10);
         k /= 10;
      }
      for (int n : num) {
          result.add(n);
      }
      return result;
  }

  public static void readme()
  {
    String str = "The array-form of an integer num is an array representing its digits in left to right order.\n\n";

    str += "For example, for num = 1321, the array form is [1,3,2,1].\n\n";

    str += "Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AddToArrayFormInteger.readme();

    int k;

    // num = [1,2,0,0], k = 34 => [1,2,3,4]
    int[] num1 = {1,2,0,0};
    k = 34;
    System.out.println("addToArrayForm(" + num1 + ", " + k + ") = ");
    List list1 = addToArrayForm(num1, k);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }

    // num = [2,7,4], k = 181 => [4,5,5]
    int[] num2 = {2,7,4};
    k = 181;
    System.out.println("addToArrayForm(" + num2 + ", " + k + ") = ");
    List list2 = addToArrayForm(num2, k);
    if (list2 != null) {
      System.out.println(Arrays.toString(list2.toArray()));
    }
    // num = [2,1,5], k = 806 => [1,0,2,1]
    int[] num3 = {2,1,5};
    k = 806;
    System.out.println("addToArrayForm(" + num3 + ", " + k + ") = ");
    List list3 = addToArrayForm(num3, k);
    if (list3 != null) {
      System.out.println(Arrays.toString(list3.toArray()));
    }

    System.out.println("addToArrayFormOpt(" + num3 + ", " + k + ") = ");
    List list4 = addToArrayFormOpt(num3, k);
    if (list4 != null) {
      System.out.println(Arrays.toString(list4.toArray()));
    }

  }
}