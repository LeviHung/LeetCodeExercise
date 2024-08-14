package bit;

public class ComplementOfBaseTenInteger
{
  public static int bitwiseComplement(int n)
  { 
    int value = 1;
    int sum = 0;
    if (n == 0) {
        return 1;
    }

    while(n > 0) {
        if (n % 2 == 0) {
            sum += value;
        }
        n = n / 2;
        value = value * 2;
    } 
    return sum; 
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
    ComplementOfBase10Integer.readme();

    int num;
    // num = 5 => 2
    num = 5;
    System.out.println("bitwiseComplement(" + num + ") = " +       
                       bitwiseComplement(num));

    // num = 7 => 0
    num = 7;
    System.out.println("bitwiseComplement(" + num + ") = " +       
                       bitwiseComplement(num));

    // num = 10 => 5
    num = 10;
    System.out.println("bitwiseComplement(" + num + ") = " +       
                       bitwiseComplement(num));

  }

}