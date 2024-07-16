package string;

public class LongestPalindrome
{
  public static int longestPalindrome(String s)
  {
    if (s == null) {
      return 0;
    }
    int[] array = new int[58];   //26 + 26 + 6
    char[] arrayS = s.toCharArray();

    for (int i = 0; i < arrayS.length; i++) {
      array[arrayS[i] - 'A'] ++;
    }

    int total = 0;
    boolean singleChar = false;
    for (int i = 0; i < array.length; i++) {
      if (singleChar == false && array[i] % 2 == 1) {
        total++;
        singleChar = true;
      }
        
      total += (array[i] / 2) * 2;
    }
    return total;
  }

  public static void readme()
  {
    String str = "Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.\n\n";

    str += "Letters are case sensitive, for example, \"Aa\" is not considered a palindrome.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ValidPalindrome.readme();
    // s = "abccccdd" => 7
    String s = "abccccdd"; 
    System.out.println("longestPalindrome(" + s + ") = " + 
                        longestPalindrome(s));

    // s = "a" => 1

    s = "a";
    System.out.println("longestPalindrome(" + s + ") = " + 
                        longestPalindrome(s));

    s = "bb";
    System.out.println("longestPalindrome(" + s + ") = " + 
                        longestPalindrome(s));

    s = "ccc";
    System.out.println("longestPalindrome(" + s + ") = " + 
                        longestPalindrome(s));

  }
}