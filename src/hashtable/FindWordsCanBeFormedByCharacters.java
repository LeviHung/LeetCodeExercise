package hashtable;

import java.util.Arrays;

public class FindWordsCanBeFormedByCharacters
{
  public static int countCharacters(String[] words, String chars) {
    int res = 0;
    int[] alphabet = new int [26];
    for (char ch: chars.toCharArray()) {
        alphabet[ch-'a']++;
    }

    for (String str: words) {
        if (isGood(str, alphabet) == true) {
            res = res + str.length();
        }
    }
    return res;
  }

  public static boolean isGood(String word, int[] alphabet) {
    int [] freq = new int[26];

    for (char ch: word.toCharArray()) {
        int n = ch-'a';
        if (freq[n] >= alphabet[n]) {
            return false;
        }
        freq[n]++;
    }
    return true;
  }

  public static void readme()
  {
    String str = "You are given an array of strings words and a string chars.\n\n";

    str += "A string is good if it can be formed by characters from chars (each character can only be used once).\n\n";
    
    str += "Return the sum of lengths of all good strings in words.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindWordsCanBeFormedByCharacters.readme();

    String chars;
    // Input: words = ["cat","bt","hat","tree"], chars = "atach"
    // Output: 6
    chars = "atach";
    String[] words1 = {"cat","bt","hat","tree"};
    System.out.println("countCharacters(" + Arrays.toString(words1) + 
                       ", \"" + chars + "\") = " +     
                       countCharacters(words1, chars));

    // Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
    // Output: 10

    chars = "welldonehoneyr";
    String[] words2 = {"hello","world","leetcode"};
    System.out.println("countCharacters(" + Arrays.toString(words2) + 
                       ", \"" + chars + "\") = " +     
                       countCharacters(words2, chars));

  }
}