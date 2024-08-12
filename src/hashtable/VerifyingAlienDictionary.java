package hashtable;

import java.util.Arrays;

public class VerifyingAlienDictionary
{
  private static boolean isAlienSorted(String[] words, String order) {
    char[] array = order.toCharArray();
    int [] dict = new int [26];
    for (int i = 0; i < 26; i++) {
      dict[array[i] - 'a'] = i;
    }

    for (int i = 1; i < words.length; i++) {
      int len = Math.min(words[i-1].length(), words[i].length());
      for (int j = 0; j < len; j++) {
        if (dict[words[i-1].charAt(j) - 'a'] < dict[words[i].charAt(j) - 'a']) {
          break;
        } else {
          if (dict[words[i-1].charAt(j) - 'a'] > dict[words[i].charAt(j) - 'a']) {
            return false;
          }
        }
      }

      if (words[i].length() < words[i-1].length()) {
        if (words[i].equals(words[i-1].substring(0, words[i].length())) == true) {
          return false;
        }
      }
    }    
    return true;
  }

  static int[] dictOpt = new int[26];
  public static boolean isAlienSortedOpt(String[] words, String order) 
  {
      for (int i = 0; i < order.length(); i++) {
          char c = order.charAt(i);
          dictOpt[c-'a'] = i;
      }
      for (int i = 0; i < words.length - 1; i++) {
          if (!sorted(words[i], words[i+1])) {
              return false;
          }
      }
      return true;
  }

  private static boolean sorted(String word1, String word2) 
  {
      int i = 0, j = 0;
      while (i < word1.length() && j < word2.length()) {
        if (word1.charAt(i) != word2.charAt(j)) {
          return dictOpt[word1.charAt(i) - 'a'] < dictOpt[word2.charAt(j) - 'a'];
        }
        i++;
        j++;
      }
      return word1.length() <= word2.length();
  }
  public static void readme()
  {
    String str = "In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.\n\n";

    str += "Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    VerifyingAlienDictionary.readme();

    String order;
    // words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz" => true
    String[] words1 = {"hello","leetcode"};
    order = "hlabcdefgijkmnopqrstuvwxyz";
    
    System.out.println("isAlienSorted(" + Arrays.toString(words1) + 
                       ", \"" + order + "\") = " + 
                       isAlienSorted(words1, order));
    System.out.println("");

    // words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz" => false
    String[] words2 = {"word","world","row"};
    order = "worldabcefghijkmnpqstuvxyz";

    System.out.println("isAlienSorted(" + Arrays.toString(words2) + 
                       ", \"" + order + "\") = " + 
                       isAlienSorted(words2, order));
    System.out.println("");

      // words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz" => false
    String[] words3 = {"apple","app"};
    order = "abcdefghijklmnopqrstuvwxyz";

    System.out.println("isAlienSorted(" + Arrays.toString(words3) + 
                       ", \"" + order + "\") = " + 
                       isAlienSorted(words3, order));
    System.out.println("");

    System.out.println("isAlienSortedOpt(" + Arrays.toString(words3) + 
                       ", \"" + order + "\") = " + 
                       isAlienSortedOpt(words3, order));
    System.out.println("");

  }
}