package bit;

public class BinaryNumberAlternatingBits
{
  public static boolean hasAlternatingBits(int n) 
  {
    boolean hasBit;
    if (n % 2 == 1)
      hasBit = true;
    else
      hasBit = false;
    n = n / 2;
    while ( n > 0) {
      if (n % 2 == 1) {
        if (hasBit == true)
          return false;
        hasBit = true;
      } else if (n % 2 == 0) {
        if (hasBit == false)
          return false;
        hasBit = false;
      }
    
      n = n / 2;
    }
    
    return true;
  }

  public static void readme()
  {
    String str = "Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinaryNumberAlternatingBits.readme();

    int n;
    // n = 5 => true
    n = 5;
    System.out.println("hasAlternatingBits(" + n + ") = " +
                       hasAlternatingBits(n));

    // n = 7 => false
    n = 7;
    System.out.println("hasAlternatingBits(" + n + ") = " +
                       hasAlternatingBits(n));
    // n = 11 => false
    n = 11;
    System.out.println("hasAlternatingBits(" + n + ") = " +
                       hasAlternatingBits(n));

  }
}