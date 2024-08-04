package hashtable;

import java.util.HashMap;

public class RansomNote
{
  public static boolean canConstruct(String ransomNote, String magazine)
  {
    int[] map = new int[26];
    int lenMag = magazine.length();
    int lenRan = ransomNote.length();
    if (lenRan > lenMag) {
      return false;
    }
    char c = '\0';
    for (int i = 0; i < lenMag; i++) {
      map[magazine.charAt(i) - 'a']++;
    }
    int index = 0;
    for (int i = 0; i < lenRan; i++) {
      index = ransomNote.charAt(i) - 'a';
      map[index]--;
      if (map[index] < 0) {
        return false;
      }
    }

    return true;
  }
  
  public static boolean canConstructMap(String ransomNote, String magazine)
  {
    HashMap <Character, Integer> map = new HashMap<>();
    int lenMag = magazine.length();
    int lenRan = ransomNote.length();
    if (lenRan > lenMag) {
      return false;
    }
    char c = '\0';
    for (int i = 0; i < lenMag; i++) {
      c = magazine.charAt(i);
      if (map.containsKey(c) == true) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    for (int i = 0; i < lenRan; i++) {
      c = ransomNote.charAt(i);
      if (map.containsKey(c) == false) {
        return false;
      } else {
        map.put(c, map.get(c) - 1);
        if (map.get(c) < 0) {
          return false;
        }
      }
    }

    return true;
  }

  public static boolean canConstructOpt(String ransomNote, String magazine) 
  {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
        
    int[] lookup = new int[26];
        
    for (char c : ransomNote.toCharArray()) {
      int i = magazine.indexOf(c, lookup[c - 'a']);
      if (i == -1) {
        return false;
      }
      lookup[c - 'a'] = i + 1;
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.\n\n";

    str += "Each letter in magazine can only be used once in ransomNote.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    RansomNote.readme();

    // ransomNote = "a", magazine = "b" => false
    String ransomNote = "a";
    String magazine = "b";

    System.out.println("canConstruct(" + ransomNote + ", " + 
                        magazine + ") = " + 
                        canConstruct(ransomNote, magazine));

    // ransomNote = "aa", magazine = "ab" => false
    ransomNote = "aa";
    magazine = "ab"; 
    System.out.println("canConstruct(" + ransomNote + ", " +
                        magazine + ") = " + 
                        canConstruct(ransomNote, magazine));

    //ransomNote = "aa", magazine = "aab" => true
    ransomNote = "aa";
    magazine = "aab"; 
    System.out.println("canConstruct(" + ransomNote + ", " + 
                        magazine + ") = " + 
                        canConstructOpt(ransomNote, magazine));

  }
}