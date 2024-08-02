package array;
import java.util.Arrays;

public class OneBitTwoBitCharacters
{
  public static boolean isOneBitCharacter(int[] bits)
  {
    int index = 0;
    //boolean isOneBit = false;
    while (index < bits.length - 1) {
      if (bits[index] == 1) {
        index = index + 2;
        //isOneBit = false;
      } else {
        index++;
        //isOneBit = true;
      }
    }
    if (index == bits.length)
      return false;
    else 
      return true;
    //return isOneBit;
  }

  public static void readme()
  {
    String str = "We have two special characters:\n\n";

    str += "The first character can be represented by one bit 0.\n\n";

    str += "The second character can be represented by two bits (10 or 11).\n\n";

    str += "Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.\n";

    System.out.println(str);
  }

  public static void main()
  {
    OneBitTwoBitCharacters.readme();

    // bits = [1,0,0] => true
    int [] bits1 = {1,0,0};
    System.out.println("isOneBitCharacter(" + Arrays.toString(bits1) + ") = " +
                       isOneBitCharacter(bits1));

    // bits = [1,1,1,00] => false
    int [] bits2 = {1,1,1,0};
    System.out.println("isOneBitCharacter(" + Arrays.toString(bits2) + ") = " +
                       isOneBitCharacter(bits2));

  }
}