package string;

public class ReverseVowelsString
{
  public static String reverseVowels(String s)
  { 
    int l = 0;
    int r = s.length() - 1;
    StringBuilder sb = new StringBuilder(s);
    char cL = '\0';
    char cR = '\0';

    while (l < r) {
      cL = s.charAt(l);
      if (cL == 'a' || cL == 'A' || cL == 'e' || cL == 'E' || 
          cL == 'i' || cL == 'I' || cL == 'o' || cL == 'O' ||
          cL == 'u' || cL == 'U') {
      } else {
        l++;
        continue;
      }
      
      cR = s.charAt(r);
      if (cR == 'a' || cR == 'A' || cR == 'e' || cR == 'E' || 
          cR == 'i' || cR == 'I' || cR == 'o' || cR == 'O' ||
          cR == 'u' || cR == 'U') {
      } else {
        r--;
        continue;
      }

      if (l < r) {
        sb.setCharAt(l, cR);
        sb.setCharAt(r, cL);
        l++;
        r--;
      }

    }
    return sb.toString();
  }

  public static String reverseVowelsEx(String s) 
  {
    boolean[] vowels = new boolean[128];
    for (char c : "aeiouAEIOU".toCharArray()) {
        vowels[c] = true;
    }
    char[] cs = s.toCharArray();
    int i = 0, j = cs.length - 1;
    while (i < j) {
        while (i < j && !vowels[cs[i]]) {
            ++i;
        }
        while (i < j && !vowels[cs[j]]) {
            --j;
        }
        if (i < j) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            ++i;
            --j;
        }
    }
    return String.valueOf(cs);
  }
  
  public static void readme()
  {
    String str = "Given a string s, reverse only all the vowels in the string and return it.\n\n";

    str += "The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReverseVowelsString.readme();

    // s = "hello" => "holle"
    String s1 = "hello";
    System.out.println("reverseVowels(" + s1 + ") = " + reverseVowels(s1));

    // s = "leetcode" => "leotcede"
    String s2 = "leetcode";
    System.out.println("reverseVowels(" + s2 + ") = " + reverseVowels(s2));
  }
}