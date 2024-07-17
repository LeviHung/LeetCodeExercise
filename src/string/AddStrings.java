package string;

public class AddStrings
{
  public static String addStrings(String num1, String num2)
  {    
    int num1Len = num1.length();
    int num2Len = num2.length();
    StringBuilder numSum = new StringBuilder();
    
    int maxLen;
    if (num1Len > num2Len) {
      maxLen = num1Len;
    } else {
      maxLen = num2Len;
    }
    int n1 = 0;
    int n2 = 0;
    int carry = 0;
    int remain = 0;
    for (int i = 0; i < maxLen; i++) {
      if (i < num1Len) {
        n1 = num1.charAt(num1Len - i - 1) - '0'; 
      } else {
        n1 = 0;
      }
      if (i < num2Len) {
        n2 = num2.charAt(num2Len - i - 1) - '0';
      } else {
        n2 = 0;
      }
      remain = (n1 + n2 + carry) % 10;
      carry = (n1 + n2 + carry) / 10;
      numSum.append(remain);
    }
    if (carry == 1) {
      numSum.append(1);
    }
    
    return numSum.reverse().toString();
  }

  public static void readme()
  {
    String str = "Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.\n\n";

    str += "You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    AddStrings.readme();

    // num1 = "11", num2 = "123" => "134"
    String num1;
    String num2;

    num1 = "11";
    num2 = "123";
    System.out.println("addStrings(" + num1 + ", " + num2 + ") = " + 
                       addStrings(num1, num2));

    // num1 = "456", num2 = "77" => "533"
    num1 = "456";
    num2 = "77";
    System.out.println("addStrings(" + num1 + ", " + num2 + ") = " + 
                       addStrings(num1, num2));

    // num1 = "0", num2 = "0" => 0
    num1 = "0";
    num2 = "0";
    System.out.println("addStrings(" + num1 + ", " + num2 + ") = " + 
                       addStrings(num1, num2));

    num1 = "98";
    num2 = "9";
    System.out.println("addStrings(" + num1 + ", " + num2 + ") = " + 
                       addStrings(num1, num2));

    }
}