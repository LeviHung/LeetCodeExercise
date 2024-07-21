package string;

public class LongestUncommonSubsequenceI
{
  public static int findLUSlength(String a, String b)
  {    
    if (a.equals(b) == true) {
      return -1;
    } else {
      if (a.length() > b.length()) {
          return a.length();
      } else {
          return b.length();
      }
    }
  }

  public static void readme()
  {
    String str = "Given two strings a and b, return the length of the longest uncommon subsequence between a and b. If no such uncommon subsequence exists, return -1.\n\n";

    str += "An uncommon subsequence between two strings is a string that is a subsequence of exactly one of them.\n";

    System.out.println(str);
  }

  public static void main()
  {
    LongestUncommonSubsequenceI.readme();

    // a = "aba", b = "cdc" => 3
    String a;
    String b;

    a = "aba";
    b = "cdc";
    System.out.println("findLUSlength(" + a + ", " + b + ") = " + 
                        findLUSlength(a, b));

    // a = "aaa", b = "bbb" => 3
    a = "aaa";
    b = "bbb";
    System.out.println("findLUSlength(" + a + ", " + b + ") = " + 
                        findLUSlength(a, b));

    // a = "aaa", b = "aaa" => -1
    a = "aaa";
    b = "aaa";
    System.out.println("findLUSlength(" + a + ", " + b + ") = " + 
                        findLUSlength(a, b));

    }
}