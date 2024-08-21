package math;

public class MaximumSixNineNumber
{
  public static int maximum69Number (int num) {
      int tmp = num; 
      int val = 1;
      int add = 0;
      int res = 0;
      while (tmp > 0) {
          if (tmp % 10 == 6) {
              add = val;
          }
          val = val * 10;
          tmp = tmp / 10;
      }
      res = num + add * 3;
      return res;
      /*
      String temp = Integer.toString(num);
      int[] arr = new int [temp.length()];
      int index = arr.length - 1;
      while (num > 0) {
          arr[index--] = num%10;
          num = num / 10;
      }

      int l = 0;
      while (l < arr.length) {
          if (arr[l] == 6) {
              break;
          }
          l++;
      }
      System.out.println("l = " + l);
      if (l != arr.length) {
          arr[l] = 9;
      }

      int res = 0;
      for (int i = 0; i < arr.length; i++) {
          res = res * 10 + arr[i];
      }
      return res;
      */
  }

  public static void readme()
  {
    String str = "You are given a positive integer num consisting only of digits 6 and 9.\n\n";

    str += "Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).\n";

    System.out.println(str);
  }

  public static void main()
  {
    MaximumSixNineNumber.readme();

    int num;
    // Input: num = 9669
    // Output: 9969
    num = 9669;
    System.out.println("maximum69Number(" + num + ") = " + maximum69Number(num));

    // Input: num = 9996
    // Output: 9999
    num = 9996;
    System.out.println("maximum69Number(" + num + ") = " + maximum69Number(num));

    // Input: num = 9999
    // Output: 9999
    num = 9999;
    System.out.println("maximum69Number(" + num + ") = " + maximum69Number(num));

  }
}