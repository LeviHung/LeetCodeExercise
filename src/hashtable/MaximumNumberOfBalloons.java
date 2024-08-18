package hashtable;

public class MaximumNumberOfBalloons
{
  public static int maxNumberOfBalloons(String text) {
      int res = 0;
      int[] alphabet = new int [26];
      for (char ch: text.toCharArray()) {
          alphabet[ch-'a']++;
      }
      boolean found = true;
      char[] balloon = {'b','a','l','l','o','o','n'};
      int index = 0;
      while (found == true) {
          if (alphabet[balloon[index]-'a'] > 0) {
              alphabet[balloon[index]-'a']--;
              index++;
              if (index > balloon.length - 1) {
                  index = 0;
                  res++;
              }
          } else {
              found = false;
          }
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given a string text, you want to use the characters of text to form as many instances of the word \"balloon\" as possible.\n\n";

    str += "You can use each character in text at most once. Return the maximum number of instances that can be formed.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    FirstUniqueCharacterString.readme();

    String text;
    
    // Input: text = "nlaebolko"
    //Output: 1

    text = "nlaebolko";

    System.out.println("maxNumberOfBalloons(" + text + ") = " + 
                       maxNumberOfBalloons(text));

    // Input: text = "loonbalxballpoon"
    // Output: 2

    text = "loonbalxballpoon";

    System.out.println("maxNumberOfBalloons(" + text + ") = " + 
                       maxNumberOfBalloons(text));

    // Input: text = "leetcode"
    // Output: 0

    text = "leetcode";
    System.out.println("maxNumberOfBalloons(" + text + ") = " + 
                       maxNumberOfBalloons(text));


  }
}