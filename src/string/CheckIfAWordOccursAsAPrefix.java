package string;

public class CheckIfAWordOccursAsAPrefix
{
  public static int isPrefixOfWord(String sentence, String searchWord) {
      String[] tokens = sentence.split(" ");
      int lenPrefix = searchWord.length();
      int res = 0;
      for (int i = 0; i < tokens.length; i++) {
          if (tokens[i].length() >= lenPrefix) {
              if (tokens[i].substring(0, lenPrefix).equals(searchWord)) {
                  res = i + 1;
                  break;
              }
          }
      }
      if (res == 0) {
          return -1;
      } else {
          return res;
      }
  }

  public static void readme()
  {
    String str = "Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.\n\n";

    str += "Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.\n\n";

    str += "A prefix of a string s is any leading contiguous substring of s.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CheckIfAWordOccursAsAPrefix.readme();
    String sentence;
    String searchWord;

    // Input: sentence = "i love eating burger", searchWord = "burg"
    // Output: 4
    sentence = "i love eating burger";
    searchWord = "burg";
    System.out.println("isPrefixOfWord(" + sentence + ", " + searchWord + ") = " + 
                       isPrefixOfWord(sentence, searchWord));

    // Input: sentence = "this problem is an easy problem", searchWord = "pro"
    // Output: 2

    sentence = "this problem is an easy problem";
    searchWord = "pro";
    System.out.println("isPrefixOfWord(" + sentence + ", " + searchWord + ") = " + 
                       isPrefixOfWord(sentence, searchWord));

    // Input: sentence = "i am tired", searchWord = "you"
    // Output: -1
    sentence = "i am tired";
    searchWord = "you";
    System.out.println("isPrefixOfWord(" + sentence + ", " + searchWord + ") = " + 
                       isPrefixOfWord(sentence, searchWord));

    }
}