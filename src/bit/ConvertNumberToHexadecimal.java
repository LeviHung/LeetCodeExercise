package bit;

public class ConvertNumberToHexadecimal
{
  public static String toHex(int num) 
  {
    StringBuilder sb = new StringBuilder();
    int remain = 0;
    boolean isNegative = false;
    
    if (num == 0) {
      return "0";
    }
    
    if (num == -2147483648) {
      return "80000000";
    }
    
    if (num < 0) {
      isNegative = true;
      num = 2147483647 + num + 1;
    }

    int digit = 0;
    while (num > 0) {
      remain = num % 16;
      if (digit == 7 && isNegative == true) {
        remain += 8;
      }
      if (remain < 10) {
        sb.append(remain);
      } else {
        sb.append((char)(remain - 10 + 'a'));
      }
      num = num / 16;
      digit++;
    }

    return sb.reverse().toString();
  }

  public static String toHexOpt(int num) {
      if (num == 0) {
          return "0";
      }
      char[] hex = 
          new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
      StringBuilder strBuilder = new StringBuilder();
      int count = 0;
      while (count < 8 && num != 0) {
          strBuilder.append(hex[num & 15]);
          num = num >> 4;
          count++;
      }
      return strBuilder.reverse().toString();
  }
  public static void readme()
  {
    String str = "Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.\n\n";

    str += "All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.\n\n";

    str += "Note: You are not allowed to use any built-in library method to directly solve this problem.";
    
    System.out.println(str);
  }

  public static void main()
  {
    ConvertNumberToHexadecimal.readme();

    int num;
    // num = 26 => "1a"
    num = 26;
    System.out.println("toHex(" + num + ") = " + toHex(num));

    // num = -1 => "ffffffff"
    num = -1;
    System.out.println("toHex(" + num + ") = " + toHex(num));

    num = 0;
    System.out.println("toHex(" + num + ") = " + toHex(num));

    num = -2147483648;
    System.out.println("toHex(" + num + ") = " + toHex(num));

    System.out.println("toHexOpt(" + num + ") = " + toHexOpt(num));

  }
}