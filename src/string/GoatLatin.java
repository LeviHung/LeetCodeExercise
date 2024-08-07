package string;

import java.util.StringTokenizer;

public class GoatLatin
{
  public static String toGoatLatin(String sentence)
  {    
    StringBuilder sb = new StringBuilder();
    //String suffixStr = "ma";
    StringTokenizer st = new StringTokenizer(sentence);
    int index = 0;
    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      char fCh = word.charAt(0);
      if (fCh == 'a' || fCh == 'A' ||
          fCh == 'e' || fCh == 'E' ||
          fCh == 'i' || fCh == 'I' ||
          fCh == 'o' || fCh == 'O' ||
          fCh == 'u' || fCh == 'U' ) {
         sb.append(word);
      } else {
           sb.append(word.substring(1));
           sb.append(fCh);
      }
      sb.append("ma");
      for (int i = 0; i <= index; i++) {
          sb.append("a");
      }
      // It is bad for runtime to use suffixStr += ""; 
      //suffixStr += "a";
      //sb.append(suffixStr);
      sb.append(" ");
      index++;
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }

  public static void readme()
  {
    String str = "You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.\n\n";
    str += "We would like to convert the sentence to \"Goat Latin\" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:\n\n";
    str += "If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append \"ma\" to the end of the word.\n\n";
    str += "For example, the word \"apple\" becomes \"applema\".\n\n";
    str += "If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add \"ma\".\n\nFor example, the word \"goat\" becomes \"oatgma\".\n\nAdd one letter 'a' to the end of each word per its word index in the sentence, starting with 1.\n\n";
    str += "For example, the first word gets \"a\" added to the end, the second word gets \"aa\" added to the end, and so on.\n\n";
    str += "Return the final sentence representing the conversion from sentence to Goat Latin.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    GoatLatin.readme();
    String sentence;
    // sentence = "I speak Goat Latin"
    // => "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

    sentence = "I speak Goat Latin";
    System.out.println("toGoatLatin(" + sentence + ") = " + 
                       toGoatLatin(sentence));
    System.out.println("");
    
    // sentence = "The quick brown fox jumped over the lazy dog" 
    // => "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
    sentence = "The quick brown fox jumped over the lazy dog";
    System.out.println("toGoatLatin(" + sentence + ") = " + 
                        toGoatLatin(sentence));

  }

}