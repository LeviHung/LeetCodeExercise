package dynamic;

public class IsSubsequence
{
  public static boolean isSubsequence(String s, String t)
  {
    if (s.length() > t.length()) {
      return false;
    }

    if (s.length() == 0) {
        return true;
    }
    
    int[] lookup = new int[26];
    char last = s.charAt(0);
    for (char c : s.toCharArray()) {
      int i = t.indexOf(c, lookup[last - 'a']);
      if (i == -1) {
        return false;
      }
      lookup[c - 'a'] = i + 1;
      last = c;
    }
    
    return true;
  }

  public static void readme()
  {
    String str = "Given two strings s and t, return true if s is a subsequence of t, or false otherwise.\n\n";

    str += "A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., \"ace\" is a subsequence of \"abcde\" while \"aec\" is not).\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    IsSubsequence.readme();

    // s = "abc", t = "ahbgdc" => true
    String s = "abc";
    String t = "ahbgdc";
    System.out.println("isSubsequence(" + s + ", " + t + ") = " + 
                       isSubsequence(s, t));

    // s = "axc", t = "ahbgdc" => false
    s = "axc";
    t = "ahbgdc";
    System.out.println("isSubsequence(" + s + ", " + t + ") = " + 
                       isSubsequence(s, t));

    // s = "acb", t ="ahbgdc" => false
    s = "acb";
    t ="ahbgdc";
    System.out.println("isSubsequence(" + s + ", " + t + ") = " + 
                        isSubsequence(s, t));

  }
}