package string;

public class MaximumScoreAfterSplittingAString
{
    public static int maxScore(String s) {
        char [] arr = s.toCharArray();
        int max = 0;
        int score = 0;
        int one = 0;
        int zero = 0;
        for (char ch: arr) {
            if (ch == '1') {
                one++;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '1') {
                one--;
            } else {
                zero++;
            }
            if (zero+one > max) {
                max = zero+one;
            }
        }
        /*
        for (int i = 1; i < arr.length; i++) {
            score = getScore(arr, i, one);
            if (score > max) {
                max = score;
            }
        }
        */
        return max;

    }
    public static int getScore(char[] arr, int split, int one) {
        int res = 0;
        for (int i = 0; i < split; i++) {
            if (arr[i] == '0') {
                res++;
            } else {
                one--;
            }
        }

        return res + one;
    }

    public static int maxScoreOpt(String s) {
        int ans = -1;
        int len = s.length();

        int ones = 0;
        int tempSum = 0;
        for(int i=0;i<len-1;i++) {
            if(s.charAt(i) == '0') tempSum++;
            else {
                ones++;
                tempSum--;
            }
            if(ans < tempSum) ans = tempSum;
        }

        ones += s.charAt(len-1) == '1' ? 1 : 0;

        return ones + ans;
    }

  public static void readme()
  {
    String str = "Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).\n\n";

    str += "The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    MaximumScoreAfterSplittingAString.readme();
    String s;

    // Input: s = "011101"
    // Output: 5 
    s = "011101";
    System.out.println("maxScore(" + s + ") = " + maxScore(s));
    System.out.println("");

      // Input: s = "00111"
      // Output: 5
      s = "00111";
      System.out.println("maxScore(" + s + ") = " + maxScore(s));
      System.out.println("");

      // Input: s = "1111"
      // Output: 3
      s = "1111";
      System.out.println("maxScore(" + s + ") = " + maxScore(s));
      System.out.println("");

  }

}