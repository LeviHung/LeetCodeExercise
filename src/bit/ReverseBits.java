package bit;
import java.math.BigInteger;

// https://www.binaryhexconverter.com/decimal-to-binary-converter
// https://www.binaryhexconverter.com/binary-to-decimal-converter
public class ReverseBits
{

  public static int reverseBits(int n)
  {    
    return binaryStringToInt(ReverseBits.intToBinaryString(n));
  }

  public static int binaryStringToInt(String a)
  {
    long number = 0;
    int digitA = a.length() - 1;
    int powA = 0;
    while (digitA >= 0) {
      if (a.charAt(digitA) == '1') {
        long result = (long) Math.pow(2, powA);        
        number = number + result;
      }
      powA++;
      digitA--;
    }
    return (int)number;
  }
  public static String intToBinaryString(int n)
  {
    StringBuilder sb = new StringBuilder();

    String str = "";
    int number = 0;
    int digit = 0;
    int powA = 0;
    int value = 0;
    boolean isNeg = false;
    if (n < 0) {
      n = 2147483647 + n + 1;
      isNeg = true;
    }

    while (digit == 0 || (n/value > 1)) {
      digit++;
      value = (int) Math.pow(2, digit);
    }

    //System.out.println("n = " + n);
    //System.out.println("digit = " + digit);
    for (int i = 31; i > digit; i--) {
      if (i==31 && isNeg == true ) {
        sb.append(1);
        
      } else {
        sb.append(0);
      }
    }
    
    while (digit >= 0) {
      value = (int) Math.pow(2, digit);
      if ( n/value > 0) {
        sb.append(1);
        n = n - value;
      } else {
        sb.append(0);
      }
      digit--;
    }
    
    return sb.reverse().toString();
  }

  public int reverseBitsOpt(int n) 
  {
    int ans = 0;
    
    for (int i = 0; i < 32; i++) {
        ans <<= 1;
        ans |= (n & 1);
        n >>= 1;
    }
    
    return ans;
  }

  public static void readme()
  {
    String str = "Reverse bits of a given 32 bits unsigned integer.\n\n";

    str += "Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.\n\n";

    str += "In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.\n";
    System.out.println(str);
  }

  public static void main() 
  {
    ReverseBits.readme();

    // n = 00000010100101000001111010011100
    // => 964176192 (00111001011110000010100101000000)
    String s = "00000010100101000001111010011100";
    int n = 43261596;
    System.out.println("reverseBits(" + n + ") = " + ReverseBits.reverseBits(n));

    n = -3;
    System.out.println("reverseBits(" + n + ") = " + ReverseBits.reverseBits(n));
    // n = 11111111111111111111111111111101
    // => 3221225471 (10111111111111111111111111111111)
    //                11111111111111111111111111111101

    n = 1;
    System.out.println("reverseBits(" + n + ") = " + ReverseBits.reverseBits(n));

  }

}