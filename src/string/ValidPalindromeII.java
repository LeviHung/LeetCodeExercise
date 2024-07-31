package string;

public class ValidPalindromeII
{
  public static boolean validPalindrome(String s) 
  {
    char [] array = s.toCharArray();
    int l = 0;
    int r = array.length - 1;
    int resetL = 0;
    int resetR = 0;
    boolean hasDelL = false;
    boolean hasDelR = false;
    while (l < r) {
      if (array[l] == array[r]) {
        l++;
        r--;
      } else {
        if (hasDelR) {
          return false;
        } else if (hasDelL) {
          l = resetL;
          r = resetR;
        }
  
        if (array[l+1] == array[r] && hasDelL == false) {
          resetL = l;
          resetR = r;
          l++;
          l++;
          r--;
          hasDelL = true;
        } else if (array[l] == array[r-1]) {
          l++;
          r--;
          r--;
          hasDelR = true;
        } else {
          return false;
        }
      }
    }
    
    return true;
  }

  public static boolean validPalindromeOpt(String s) 
  {

      byte[] chars = s.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1);
      int i = 0, j = s.length() - 1;

      while(i < j) {
          if(chars[i] != chars[j]) {
              return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
          }
          i++;
          j--;
      }
      return true;
  }

  public static boolean isPalindrome(byte[] chars, int i , int j) {
      while(i < j) {
          if(chars[i] != chars[j]) {
              return false;
          }
          i++;
          j--;
      }
      return true;
  }

  public static void readme()
  {
    String str = "Given a string s, return true if the s can be palindrome after deleting at most one character from it.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    ValidPalindromeII.readme();

    String s;
    // s = "aba" => true
    s = "aba";
    System.out.println("validPalindrome(" + s + ") = " + 
                       validPalindrome(s));

    // s = "abca" => true
    s = "abca";
    System.out.println("validPalindrome(" + s + ") = " + 
                       validPalindrome(s));

    // s = "abc" => false
    s = "abc";
    System.out.println("validPalindrome(" + s + ") = " + 
                       validPalindrome(s));

    System.out.println("validPalindromeOpt(" + s + ") = " + 
                       validPalindromeOpt(s));

  }
}