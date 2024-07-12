package easy;
import java.util.HashMap;

public class WordPattern
{
  public static boolean wordPattern(String pattern, String s)
  {
    HashMap<Character, String> map = new HashMap<>();
    int index = 0;
    String [] tokens = s.split(" ");
    
    if (pattern.length() != tokens.length) {
        return false;
    }
    
    for (String str : tokens) {
      if (map.containsKey(pattern.charAt(index))) {
        if (str.equals(map.get(pattern.charAt(index))) == false) {
          return false;
        }
      } else {
        if (map.containsValue(str) == true) {
          return false;
        }
        map.put(pattern.charAt(index), str);
      }
      index++;
    }

    return true;
  }

  public static void readme()
  {
    String str = "Given a pattern and a string s, find if s follows the same pattern.\n\n";

    str += "Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    WordPattern.readme();

    // pattern = "abba", s = "dog cat cat dog" => true
    String pattern = "abba";
    String s = "dog cat cat dog";
    System.out.println("wordPattern(" + pattern + ", " + s + ") = " + 
                        wordPattern(pattern, s));

    // pattern = "abba", s = "dog cat cat fish" => false
    pattern = "abba";
    s = "dog cat cat fish"; 
    System.out.println("wordPattern(" + pattern + ", " + s + ") = " + 
                        wordPattern(pattern, s));

    // pattern = "aaaa", s = "dog cat cat dog" => true;
    pattern = "aaaa";
    s = "dog cat cat dog";
    System.out.println("wordPattern(" + pattern + ", " + s + ") = " + 
                        wordPattern(pattern, s));

    // pattern = "abba", s = "dog dog dog dog" => true;
    pattern = "abba";
    s = "dog dog dog dog";
    System.out.println("wordPattern(" + pattern + ", " + s + ") = " + 
                        wordPattern(pattern, s));

  }
}