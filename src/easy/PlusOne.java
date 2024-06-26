package easy;
import java.util.Arrays;

public class PlusOne
{
  public static int[] plusOne(int[] digits)
  {
    int [] result;
    int index;
    for (index = 0; index < digits.length; index++) {
      if (digits[index] != 9) {
        break;
      } 
    }

    if (index == digits.length) {
      result = new int [digits.length + 1];
    } else {
      result = new int [digits.length];
    }

    int checkDigit = digits.length - 1;
    int resultDigit = result.length - 1;
    while (checkDigit >= 0) {
      if (digits[checkDigit] == 9) {
        result[resultDigit] = 0;
      } else {
        result[resultDigit] = digits[checkDigit] + 1;
        checkDigit--;
        resultDigit --;

        while (resultDigit >= 0) {
          result[resultDigit] = digits[checkDigit];
          checkDigit--;
          resultDigit--;
        }
        break;
      }
      checkDigit--;
      resultDigit --;
    } 
    
    if (checkDigit != resultDigit) {
      result[0] = 1;
    }
    
    return result;
  }

  public static void readme()
  {
    String str = "You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.\n\n";

    str += "Increment the large integer by one and return the resulting array of digits.\n";

    System.out.println(str);
  }
}