package bit;

public class NumberComplement
{
  public static int findComplement(int num)
  { 
    int value = 1;
    int total = 0;
    while (num != 0) {
      if ((num & 1) == 0) {
        total += value;
      }
      num = num >> 1;
      value = value << 1;
    }

    return total;
    // Use while loop and check if the number is shifted to be zeron.
    // It is better for runtime.
    /*
    int value = 0;
    int leading = 0;
    for (int i = 0; i < 32; i++) {
      if (((num >> i) & 1) == 1) {
        leading = i;
      }
    }

    for (int i = 0; i < leading; i++) {
      if (((num >> i) & 1) == 0) {
        value += 1 << i;
      }
    }
    return value;
    */
  }

  public static int findComplementOpt(int num) 
  {
    int i = 0, re = 0;
    while (num!=0) {
      if ((num & 1) ==0) {
        re += (int)Math.pow(2, i);
      }
      num >>= 1;
      i++;
    }
    
    return re;
  }

  
  public static void readme()
  {
    String str = "The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.\n\n";

    str += "For example, The integer 5 is \"101\" in binary and its complement is \"010\" which is the integer 2.\n\n";

    str += "Given an integer num, return its complement.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    NumberComplement.readme();

    int num;
    // num = 5 => 2
    num = 5;
    System.out.println("findComplement(" + num + ") = " +       
                        findComplement(num));

    // num = 1 => 0
    num = 1;
    System.out.println("findComplement(" + num + ") = " +       
                        findComplement(num));

    System.out.println("findComplementOpt(" + num + ") = " +       
                        findComplementOpt(num));

  }

}