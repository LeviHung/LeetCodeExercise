package bit;
import java.util.Arrays;

public class BinaryGap
{
  public static int binaryGap(int n)
  {
    int max = 0;
    int bitCnt = Integer.bitCount(n);
    if (bitCnt == 1) {
      return 0;
    }
    
    int bit = 0;
    int last = 0;
    boolean hasFirst = false;
    while (n > 0) {
      if (n % 2 == 1) {
        if (hasFirst == true && bit - last > max) {
            max = bit - last;
        }
        hasFirst = true;
        last = bit;
      }
      n /= 2;
      bit++;
    }

    return max;
  }

  public static void readme()
  {
    String str = "Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.\n\n";

    str += "Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in \"1001\" have a distance of 3.\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinaryGap.readme();

    int n;
    // n = 22 => 2
    n = 22;
    System.out.println("binaryGap(" + n + ") = " +
                       binaryGap(n));
    // n = 8 => 0
    n = 8;
    System.out.println("binaryGap(" + n + ") = " +
                       binaryGap(n));

    // n = 5 => 2
    n = 5;
    System.out.println("binaryGap(" + n + ") = " +
                       binaryGap(n));
    // n = 5 => 2
    n = 12;
    System.out.println("binaryGap(" + n + ") = " +
                       binaryGap(n));

  }
}