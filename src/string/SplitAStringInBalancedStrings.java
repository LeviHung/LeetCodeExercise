package string;

public class SplitAStringInBalancedStrings
{
  public static int balancedStringSplit(String s) {
      int res = 0;
      char[] arr = s.toCharArray();
      int l = 0;
      int r = arr.length;
      int cntR = 0;
      int cntL = 0;
      while (l < r) {
          if (arr[l] == 'L') {
              cntL++;
          } else {
              cntR++;
          }
          if (cntL == cntR) {
              res++;
              cntL = 0;
              cntR = 0;
          }
          l++;
      }
      return res;
  }


  public static void readme()
  {
    String str = "Balanced strings are those that have an equal quantity of 'L' and 'R' characters.\n\n";

    str += "Given a balanced string s, split it into some number of substrings such that:\n\n";

    str += "Each substring is balanced.\n\n";

    str += "Return the maximum number of balanced strings you can obtain.\n";

    System.out.println(str);
  }

  public static void main()
  {
    SplitAStringInBalancedStrings.readme();
    String s;
    
    // Input: s = "RLRRLLRLRL"
    // Output: 4
    s = "RLRRLLRLRL";
    System.out.println("balancedStringSplit(" + s + ") = " + 
                       balancedStringSplit(s));

    // Input: s = "RLRRRLLRLL"
    // Output: 2
    s = "RLRRRLLRLL";
    System.out.println("balancedStringSplit(" + s + ") = " + 
                       balancedStringSplit(s));

    // Input: s = "LLLLRRRR"
    // Output: 1
    s = "LLLLRRRR";
    System.out.println("balancedStringSplit(" + s + ") = " + 
                       balancedStringSplit(s));
  }
}