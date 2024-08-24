package string;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StringMatchingInAnArray
{
  public static List<String> stringMatching(String[] words) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < words.length; i++) {
          if (isSubstring(i, words) == true) {
              list.add(words[i]);
          }
      }
      return list;
      /*
      for (int i = 0; i < words.length; i++) {
          for (int j = 0; j < words.length; j++) {
              if (i != j && words[j].contains(words[i])) {
                      list.add(words[i]);
                      break;
              }
          }
      }
      return list;
      */
      /*
      for (int i = 0; i < words.length; i++) {
          for (int j = 0; j < words.length; j++) {
              if (i == j) {
                  continue;
              }
              if (words[i].length() < words[j].length()) {
                  if (words[j].contains(words[i])) {
                      list.add(words[i]);
                      break;
                  }
              }
          }
      }
      return list;
      */
  }
  
  public static boolean isSubstring(int i, String[] array) {
      for (int j = 0; j < array.length; j++) {
          if (i != j && array[j].contains(array[i])) {
              return true;
          }
      }
      return false;
  }

  public static void readme()
  {
    String str = "Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.\n\n";

    str += "A substring is a contiguous sequence of characters within a string\n";

    System.out.println(str);
  }

  public static void main()
  {
    StringMatchingInAnArray.readme();

    // Input: words = ["mass","as","hero","superhero"]
    // Output: ["as","hero"]
    String [] words1 = {"mass","as","hero","superhero"}; 
    System.out.println("stringMatching(" + Arrays.toString(words1) + ") = ");
    List<String> list1 = stringMatching(words1);
    System.out.println(Arrays.toString(list1.toArray()));
    System.out.println("");

    // Input: words = ["leetcode","et","code"]
    // Output: ["et","code"]

    String [] words2 = {"leetcode","et","code"}; 
    System.out.println("stringMatching(" + Arrays.toString(words2) + ") = ");
    List<String> list2 = stringMatching(words2);
    System.out.println(Arrays.toString(list2.toArray()));
    System.out.println("");

    // Input: words = ["blue","green","bu"]
    // Output: []
    String [] words3 = {"blue","green","bu"}; 
    System.out.println("stringMatching(" + Arrays.toString(words3) + ") = ");
    List<String> list3 = stringMatching(words3);
    System.out.println(Arrays.toString(list3.toArray()));
    System.out.println("");

  }
}