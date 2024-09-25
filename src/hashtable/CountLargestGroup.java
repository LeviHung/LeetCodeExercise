package hashtable;
import java.util.Arrays;

public class CountLargestGroup
{
  public static int countLargestGroup(int n) {
    int[] digitGroupFreq = new int [37];
    int[] t = new int[n+1];
    for (int i = 1; i <= n; i++) {
        t[i] = i % 10 + t[i / 10];
    }
    for (int i = 1; i <= n; i++) {
        digitGroupFreq[t[i]]++;
    }
    /*
    for (int i = 1; i <= n; i++) {
        digitGroupFreq[getDigitSum(i)]++;
    }
    */
    //System.out.println(Arrays.toString(digitGroupFreq));
    int max = 0;
    int maxCnt = 0;
    for (int i = 0; i < 37; i++) {
        if (digitGroupFreq[i] >= max) {
            if (digitGroupFreq[i] > max) {
                max = digitGroupFreq[i];
                maxCnt = 1;
            } else {
                maxCnt++;
            }
        }

    }
    return maxCnt;
  }

  public static int getDigitSum(int n) {
    int res = 0;
    while (n > 0) {
        res +=  n % 10;
        n = n / 10;
    }
    return res;
  }

  public static void readme()
  {
    String str = "You are given an integer n.\n\n";

    str += "Each number from 1 to n is grouped according to the sum of its digits.\n\n";

    str += "Return the number of groups that have the largest size.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CountLargestGroup.readme();
    int n;
    
    // Input: n = 13
    // Output: 4
    n = 13;
    System.out.println("countLargestGroup(" + n + ") = " +
                       countLargestGroup(n));

    // Input: n = 2
    // Output: 2
    n = 2;
    System.out.println("countLargestGroup(" + n + ") = " +
                       countLargestGroup(n));

  }
}