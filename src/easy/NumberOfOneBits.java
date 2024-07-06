package easy;

public class NumberOfOneBits
{

  public static int hammingWeight(int n) 
  {    
    int number = 0;
    int digit = 0;
    int value = 1;

    while ((n / value) > 1) {
      digit++;
      value = value * 2;
    }
    while (digit >= 0) {
      if ( n / value > 0) {
        number++;
        n = n - value;
      }
      value = value / 2;
      digit--;
    }
    return number;
  }

  public static int hammingWeightOpt(int n) 
  {
    int count = 0;

    for (int i = 0; i < 32; i++) {
      if (((n >> i) & 1) == 1) {
        count++;
      }
    }

    return count;
  }
  public static void readme()
  {
    String str = "Write a function that takes the binary representation of a positive integer and returns the number of set bits it has (also known as the Hamming weight).\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
      NumberOfOneBits.readme();

    // n = 11 => 3
    int n = 11;
    System.out.println("hammingWeight(" + n + ") = " + NumberOfOneBits.hammingWeight(n));

    // n = 128 => 1
    n = 128;
    System.out.println("hammingWeight(" + n + ") = " + NumberOfOneBits.hammingWeight(n));

    // n = 2147483645 => 30
    n = 2147483645;
    System.out.println("hammingWeight(" + n + ") = " + NumberOfOneBits.hammingWeight(n));

    n = 2147483647;
    System.out.println("hammingWeightOpt(" + n + ") = " + NumberOfOneBits.hammingWeightOpt(n));

  }

}