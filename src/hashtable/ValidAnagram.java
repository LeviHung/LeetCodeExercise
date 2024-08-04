package hashtable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class ValidAnagram
{
  public static boolean isAnagram(String s, String t)
  {
    int [] arrayS = new int [26];
    int [] arrayT = new int [26];

    int lenS = s.length();
    int lenT = t.length();
    if (lenS != lenT) {
      return false;
    }
    
    for (int i = 0; i < lenS; i++) {
      arrayS[(s.charAt(i) - 'a')]++;
    }

    for (int i = 0; i < lenS; i++) {
      arrayT[(t.charAt(i) - 'a')]++;
    }

    for (int i = 0; i < 26; i++) {
      if (arrayS[i] != arrayT[i]) {
        return false;
      }
    }
    
    return true;
  }

  public static boolean isAnagramOpt(String s, String t) 
  {
    int[] arr = new int[26];
    for (char x : s.toCharArray()) {
        arr[x - 'a']++;
    }
    for (char x : t.toCharArray()) {
        arr[x - 'a']--;
    }
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) return false;
    }

    return true;
  }
  
  public static void readme()
  {
    String str = "Given two strings s and t, return true if t is an anagram of s, and false otherwise.\n\n";

    str += "An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ValidAnagram.readme();

    // s = "anagram", t = "nagaram" => true
    String s = "anagram";
    String t = "nagaram";

    System.out.println("isAnagram(" + s + ", " + t + ") = " + 
                        ValidAnagram.isAnagram(s, t));

    // s = "rat", t = "car" => false
    s = "rat";
    t = "car"; 
    System.out.println("isAnagram(" + s + ", " + t + ") = " + 
                        ValidAnagram.isAnagram(s, t));

    s = "nl";
    t = "cx"; 
    System.out.println("isAnagram(" + s + ", " + t + ") = " + 
                        ValidAnagram.isAnagram(s, t));

    System.out.println("isAnagramOpt(" + s + ", " + t + ") = " + 
                        ValidAnagram.isAnagramOpt(s, t));

  }
}