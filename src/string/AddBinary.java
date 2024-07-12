package string;
import java.math.BigInteger;

public class AddBinary
{
  public static String addBinary(String a, String b)
  {    
    //System.out.println("binaryStringToInt(a) = " + binaryStringToInt(a));
    //System.out.println("Large Number: " + BigDecimal.valueOf(binaryStringToInt(a)).toPlainString());
    
    //System.out.println("binaryStringToInt(b) = " + binaryStringToInt(b));
    //BigInteger A = binaryStringToInt(a);
    //BigInteger B = binaryStringToInt(b);
    //return intToBinaryString(A.add(B));
    return intToBinaryString(binaryStringToInt(a).add(binaryStringToInt(b)));
  }

  public static BigInteger binaryStringToInt(String a)
  {
    BigInteger number = new BigInteger("0");
    BigInteger b1 = new BigInteger("2");
    int digitA = a.length() - 1;
    int powA = 0;
    while (digitA >= 0) {
      if (a.charAt(digitA) == '1') {
        BigInteger result = b1.pow(powA);        
        number = number.add(result);
      }
      powA++;
      digitA--;
    }

    return number;
  }

  //10000  16 / 31  11111
  public static String intToBinaryString(BigInteger n)
  {
    String str = "";
    int number = 0;
    int digit = 0;
    int powA = 0;
    BigInteger value = new BigInteger("0");
    BigInteger a1 = new BigInteger("0");
    BigInteger a2 = new BigInteger("1");

    // System.out.println("n = " + n);
    if (n.equals(a1)) {
      return "0";
    } else if (n.equals(a2)) {
      return "1";
    }
    

    BigInteger b2 = new BigInteger("1");
    BigInteger b1;
    b1 = new BigInteger("2");

    while (digit == 0 || (n.divide(value).compareTo(b2)) == 1) {
      digit++;
      value = b1.pow(digit);
    }


    //System.out.println("n = " + n);
    //System.out.println("digit = " + digit);
    //System.out.println("Math.pow(2,digit) = " + Math.pow(2,digit));
    BigInteger b3 = new BigInteger("1");
    while (digit >= 0) {
      value = b1.pow(digit);
      if ( n.divide(value).compareTo(b3) == 0) {
        str += "1";
        n = n.subtract(value);
      } else {
        //System.out.println(digit + ": 0, " + n);
        str += '0';
      }
      digit--;
    }
    return str;
  }

  public static String addBinaryEx(String a, String b)
  {
    int digitA = a.length() - 1;
    int digitB = b.length() - 1;
    int carry = 0;
    int sum = 0;
    StringBuilder sb = new StringBuilder();

    while (digitA >= 0 || digitB >= 0 || carry > 0) {
      if (digitA >= 0)
        sum += a.charAt(digitA--) - '0'; 
      if (digitB >= 0)
        sum += b.charAt(digitB--) - '0'; 
      sum += carry;
      
      if (sum > 1) {
        carry = 1;
      } else {
        carry = 0;
      }

      sb.append(sum % 2);
      sum = 0;
    }
    
    return sb.reverse().toString();

    /*
    for (int i = str.length() - 1; i >= 0; i--) {
      result += str.charAt(i);
    }
    return result;
    */
}
  
  public static String addBinaryOpt(String a, String b) 
  {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry == 1) 
    {
      if (i >= 0)
        carry += a.charAt(i--) - '0';//to change char to int
      if (j >= 0)
        carry += b.charAt(j--) - '0';//to change char to int
      sb.append(carry % 2);
      carry /= 2;
    }
    return sb.reverse().toString();
  }
  
  public static void readme()
  {
    String str = "Given two binary strings a and b, return their sum as a binary string.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AddBinary.readme();

    String a = "11";
    String b = "1";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "0";
    b = "0";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "0";
    b = "1";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "1010";
    b = "1011";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));


    a =     "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    System.out.println("addBinaryOpt(" + a + ", " + b + ") = " + 
     AddBinary.addBinaryOpt(a, b));

    }
}