package hashtable;

import java.util.Arrays;

public class ShortestCompletingWord
{
  public static String shortestCompletingWord(String licensePlate, String[] words)
  { 
    int[] arrayP = new int [26];
    for (int i = 0; i < licensePlate.length(); i++) {
      char ch = licensePlate.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        arrayP[ch - 'A']++;
      } else if (ch >= 'a' && ch <= 'z') {
        arrayP[ch - 'a']++;
      }
    }

    int max = 0;
    int[] arrayW = new int [words.length];
    for (int i = 0; i < words.length; i++) {
      int[] arrayTmp = arrayP.clone();
      for (char ch: words[i].toCharArray()) {
        if (arrayTmp[ch - 'a'] > 0) {
          arrayW[i]++;
          arrayTmp[ch - 'a']--;
        }
      }
      if (arrayW[i] > max) {
        max = arrayW[i];
      }
    }
    
    String ans = null;
    int minLen = 15;
    for (int i = 0; i < words.length; i++) {
      if (arrayW[i] == max) {
        if (words[i].length() < minLen) {
          minLen = words[i].length();
          ans = words[i];
        }
      }
    }
    
    return ans;
  }

  public static String shortestCompletingWordOpt(String licensePlate, String[] words) 
  {
    int licenseFreq[] = new int[26];
    int len = words.length;
    int licenseLen = 0;
    for(char c : licensePlate.toCharArray()) {
        if(c >= 'a' && c <= 'z') {
            licenseFreq[c - 'a']++;
            licenseLen++;
        } else if(c >= 'A' && c <= 'Z') {
            licenseFreq[c - 'A']++;
            licenseLen++;
        }
    }
    int minLength = Integer.MAX_VALUE;
    String result = "";
    int wordLen;
    for(int i = 0; i < len; i++) {
        wordLen = words[i].length();
        if(wordLen < minLength && wordLen >= licenseLen &&
           isCompletingWord(words[i], licenseFreq)) {
            result = words[i];
            minLength = wordLen;
        }
    } 
    return result;
  }

  public static boolean isCompletingWord(String s, int[] licenseFreq) {
    int[] freq = new int[26];
    for(char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    for(int i = 0; i < 26; i++) {
        if(freq[i] < licenseFreq[i]) {
            return false;
        }
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "Given a string licensePlate and an array of strings words, find the shortest completing word in words.\n\n";

    str += "A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.\n\n";

    str += "For example, if licensePlate = \"aBc 12c\", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are \"abccdef\", \"caaacab\", and \"cbca\".\n\n";

    str += "Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ShortestCompletingWord.readme();
    String licensePlate;
    
    // licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
    // => "steps"
    licensePlate = "1s3 PSt";
    String[] words1 = {"step","steps","stripe","stepple"};
    System.out.println("shortestCompletingWord(" + licensePlate + 
                       Arrays.toString(words1) + ") = " + 
                       shortestCompletingWord(licensePlate, words1));

    // licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
    // => "pest"
    licensePlate = "1s3 456";
    String[] words2 = {"looks","pest","stew","show"};
    System.out.println("shortestCompletingWord(" + licensePlate + 
                       Arrays.toString(words2) + ") = " + 
                       shortestCompletingWord(licensePlate, words2));
    
    System.out.println("shortestCompletingWordOpt(" + licensePlate + 
                       Arrays.toString(words2) + ") = " + 
                       shortestCompletingWordOpt(licensePlate, words2));

  }
}