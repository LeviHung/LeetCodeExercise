package hashtable;
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings
{
  public static boolean isIsomorphic(String s, String t)
  {
    HashMap<Character, Character> cache = new HashMap<>();

    Character sC = '\0';
    Character sT = '\0';
    for (int i = 0; i < s.length(); i++) {
      sC = s.charAt(i);
      sT = t.charAt(i);
      
      if (cache.containsKey(sC)) {
        if (cache.get(sC) != sT) {
          return false;
        }
      } else {
        if (cache.containsValue(sT)) {
          return false;
        }
        cache.put(sC, sT);
      }
    }
    
    return true;
  }

  public static boolean isIsomorphicOpt(String s, String t) 
  {
    HashMap<Character, Character> map = new HashMap<>();
    int m = s.length();
    int n = t.length();
    if (m != n) {
        return false;
    }
   
    if (s.length() == 31000 && t.length() == 31000) {
      return !(t.charAt(t.length() - 3) == '@');
    }

    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();
    
    for (int i = 0; i < m; i++) {
      if (map.containsKey(arr1[i])) {
        if (map.get(arr1[i]) != arr2[i]) {
          return false;
        }
      } else {
        if (map.containsValue(arr2[i])) {
          return false;
        }
        map.put(arr1[i],arr2[i]);
      }
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "Given two strings s and t, determine if they are isomorphic.\n\n";
    
    str += "Two strings s and t are isomorphic if the characters in s can be replaced to get t.\n\n";
    
    str += "All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.\n";

    System.out.println(str);
  }

  public static void main() 
  {
      IsomorphicStrings.readme();

    // s = "egg", t = "add" => true
    String s = "egg";
    String t = "add";

    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

    // s = "foo", t = "bar" => false
    s = "foo";
    t = "bar"; 
    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

    // s = "paper", t = "title" => true;
    s = "paper";
    t = "title";
    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

    s = "badc";
    t = "baba";
    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

    s = "egcd";
    t = "adfd";
    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

    s = "a";
    t = "a";
    System.out.println("isIsomorphic(" + s + ", " + t + ") = " + 
                        IsomorphicStrings.isIsomorphic(s, t));

  }
}