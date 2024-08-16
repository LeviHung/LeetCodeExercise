package string;

import java.util.Arrays;

public class OccurrencesAfterBigram
{
  public static String[] findOcurrences(String text, String first, String second) 
  {
      String[] tokens = text.split(" ");
      int size = 0;
      int [] index = new int[tokens.length];
      for (int i = 0; i < tokens.length-2; i++) {
          if (tokens[i].equals(first) && tokens[i + 1].equals(second)) {
              index[size] = i+2;
              size++;
          }
      }
      String[] res = new String[size];
      for (int i = 0; i < size; i++) {
          res[i] = tokens[index[i]];
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given two strings first and second, consider occurrences in some text of the form \"first second third\", where second comes immediately after first, and third comes immediately after second.\n\n";

    str += "Return an array of all the words third for each occurrence of \"first second third\".\n";

    System.out.println(str);
  }

  public static void main()
  {
    OccurrencesAfterBigram.readme();

    String text;
    String first;
    String second;
    //Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
    //Output: ["girl","student"]
    text = "alice is a good girl she is a good student";
    first = "a";
    second = "good";
    System.out.println("findOcurrences(" + text + ", " + first + ", " + second + ") = " + 
                       Arrays.toString(findOcurrences(text, first, second)));
    System.out.println("");
    
    //Input: text = "we will we will rock you", first = "we", second = "will"
    //Output: ["we","rock"]
    text = "we will we will rock you";
    first = "we";
    second = "will";
    System.out.println("findOcurrences(" + text + ", " + first + ", " + second + ") = " + 
                       Arrays.toString(findOcurrences(text, first, second)));


    }
}