package hashtable;

import java.util.HashSet;
import java.util.Arrays;

public class UniqueMorseCodeWords
{
  private static int uniqueMorseRepresentations(String[] words)
  {
    HashSet<String> set = new HashSet<>();
    
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    StringBuilder sb = new StringBuilder();
    for (String str: words) {
      sb.setLength(0);
      for (char ch: str.toCharArray()) {
        sb.append(morse[ch - 'a']);
      }
      set.add(sb.toString());
    }
    
    return set.size(); 
  }

  public static void readme()
  {
    String str = "International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:\n\n";

    str += "'a' maps to \".-\",\n\n";
    str += "'b' maps to \"-...\",\n\n";
    str += "'c' maps to \"-.-.\", and so on.\n\n";
    str += "For convenience, the full table for the 26 letters of the English alphabet is given below:\n\n";
    str += "Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.\n\n";
    str += "For example, \"cab\" can be written as \"-.-..--...\", which is the concatenation of \"-.-.\", \".-\", and \"-...\". We will call such a concatenation the transformation of a word.\n\n";
    str += "Return the number of different transformations among all words we have.\n";

    System.out.println(str);
  }

  public static void main()
  {
    UniqueMorseCodeWords.readme();

    // words = ["gin","zen","gig","msg"] => 2
    String[] words1 = {"gin","zen","gig","msg"};
    System.out.println("uniqueMorseRepresentations(" + Arrays.toString(words1) + 
                       ") = " + uniqueMorseRepresentations(words1));

    // words = ["a"] => 1
    String[] words2 = {"a"};
    System.out.println("uniqueMorseRepresentations(" + Arrays.toString(words2) + 
                       ") = " + uniqueMorseRepresentations(words2));

  }
}