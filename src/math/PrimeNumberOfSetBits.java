package math;

public class PrimeNumberOfSetBits
{
  public static int countPrimeSetBits(int left, int right)
  {
    int count = 0;
    for (int i = left; i <= right; i++) {
      int set = countBits(i);
      if (set == 2 || set == 3 || set == 5 || set == 7 || set == 11 ||
          set == 13 || set == 17 || set == 19) {
        count++;
      }
    }
    return count;
  }

  public static int countBits(int n)
  {
    int [] bits = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    int num = 0;
    int index = n;
    while (index > 0) {
      num += bits[(index % 16)];
      index = index / 16;
    }

    return num;
  }

  public static int countPrimeSetBitsOpt(int left, int right) 
  {
    // Precompute primes up to 20
    boolean[] isPrime = new boolean[21];
    isPrime[2] = true;
    isPrime[3] = true;
    isPrime[5] = true;
    isPrime[7] = true;
    isPrime[11] = true;
    isPrime[13] = true;
    isPrime[17] = true;
    isPrime[19] = true;

    int count = 0;
    for (int num = left; num <= right; num++) {
        int setBits = Integer.bitCount(num);
        if (isPrime[setBits]) {
            count++;
        }
    }

    return count;
  }
  
  public static void readme()
  {
    String str = "Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.\n\n";

    str += "Recall that the number of set bits an integer has is the number of 1's present when written in binary.\n\n";

    str += "For example, 21 written in binary is 10101, which has 3 set bits.\n";

    System.out.println(str);
  }

  public static void main()
  {
    PrimeNumberOfSetBits.readme();

    int left;
    int right;
    // left = 6, right = 10 => 4
    left = 6;
    right = 10;
    System.out.println("countPrimeSetBits(" + left + ", " + right + ") = " +
                       countPrimeSetBits(left, right));

    // left = 10, right = 15 => 5
    left = 10;
    right = 15;
    System.out.println("countPrimeSetBits(" + left + ", " + right + ") = " +
                       countPrimeSetBits(left, right));
    System.out.println("countPrimeSetBitsOpt(" + left + ", " + right + ") = " +
                       countPrimeSetBitsOpt(left, right));

  }
}