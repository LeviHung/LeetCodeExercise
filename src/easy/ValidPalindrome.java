package easy;

public class ValidPalindrome
{
  public static boolean isPalindrome(String s)    
  {
    int l = 0;
    int r = s.length() - 1;
    char leftChar = '\0';
    char rightChar = '\0';

    while (l < r) {
      leftChar = s.charAt(l);
      rightChar = s.charAt(r);
      if (Character.isLetter(leftChar) == false &&
          Character.isDigit(leftChar) == false) {
        l++;
        continue;
      }

      if (Character.isLetter(rightChar) == false &&
          Character.isDigit(rightChar) == false) {
        r--;
        continue;
      }
      if (leftChar >= 'A' && leftChar <= 'Z') {
        leftChar -= ('A' - 'a');
      }
      if (rightChar >= 'A' && rightChar <= 'Z') {
        rightChar -= ('A' - 'a');
      }
      if (leftChar != rightChar) {
          return false;
      }
      // Use substracting the char instead of toLowerCase function
      // to get better for the runtime.
      /*
      if (Character.toLowerCase(s.charAt(l)) !=
          Character.toLowerCase(s.charAt(r))) {
        return false;
      }
      */
      l++;
      r--;
    }
    return true;
  }

  public static boolean isPalindromeOpt(String s) 
  {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);

      // Change case
      if (leftChar >= 'A' && leftChar <= 'Z') {
          leftChar -= ('A' - 'a');
      }
      if (rightChar >= 'A' && rightChar <= 'Z') {
          rightChar -= ('A' - 'a');
      }

      if (! (leftChar >= 'a' && leftChar <= 'z') &&
          ! (leftChar >= '0' && leftChar <= '9')) {
          left++;
          continue;
      }
      if (! (rightChar >= 'a' && rightChar <= 'z') &&
          ! (rightChar >= '0' && rightChar <= '9')) {
          right--;
          continue;
      }

      if (leftChar != rightChar) {
          return false;
      }
      left++;
      right--;
    }
    return true;
  }
  public static void readme()
  {
    String str = "A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.\n\n";

    str += "Given a string s, return true if it is a palindrome, or false otherwise.\n";

    System.out.println(str);
  }
}