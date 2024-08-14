package hashtable;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindCommonCharacters
{
  public static List<String> commonChars(String[] words)
  {
    int[] alphabet = new int [26];
    List<String> res = new ArrayList<>();

    for (char ch: words[0].toCharArray()) {            
      alphabet[ch - 'a']++;
    }

    for (int i = 1; i < words.length; i++) {
      int[] alphaNext = new int [26];
      for (char ch: words[i].toCharArray()) {
        alphaNext[ch - 'a']++;
      }
      for (int j = 0; j < 26; j++) {
        alphabet[j] = Math.min(alphabet[j], alphaNext[j]);
      }
    }
    //System.out.println(Arrays.toString(array));
    for (int i = 0; i < 26; i++) {
      while (alphabet[i] > 0) {
        res.add(Character.toString('a' + i));
        alphabet[i] -= 1;
      }
    }
    return res; 
  }

  public static List<String> commonCharsOpt(String[] words) 
  {
    int[] last = count(words[0]);
    for(int i = 1; i < words.length; i++) {
        last = intersection(last, count(words[i]));
    }

    List<String> arr = new ArrayList<>();

    for(int i = 0; i < 26; i++) {
        if(last[i] != 0) {
            char a = 'a';
            a += i;
            String s = String.valueOf(a);
            while(last[i] > 0) {
                arr.add(s);
                last[i]--;
            }
        }
    }

    return arr;
  }

  static int[] intersection(int[] a, int[] b){
    int[] t = new int[26];
    for(int i = 0; i < 26; i++) {
        t[i] = Math.min(a[i], b[i]);
    }

    return t;
  }

  static int[] count(String str) {
    int[] t = new int[26];
    for(char c : str.toCharArray()) {
        t[c-'a']++;
    }

    return t;
  }
  
  public static void readme()
  {
    String str = "Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    FindCommonCharacters.readme();

    // words = ["bella","label","roller"] => ["e","l","l"]
    String[] words1 = {"bella","label","roller"};
    System.out.println("commonChars(\"" + Arrays.toString(words1) + "\") = ");     
    List list1 = commonChars(words1);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }

    // words = ["cool","lock","cook"] => ["c","o"]
    String[] words2 = {"cool","lock","cook"};
    System.out.println("commonChars(\"" + Arrays.toString(words2) + "\") = ");     List list2 = commonChars(words2);
    if (list2 != null) {
      System.out.println(Arrays.toString(list2.toArray()));
    }

    System.out.println("commonCharsOpt(\"" + Arrays.toString(words2) + "\") = ");     List list3 = commonCharsOpt(words2);
    if (list3 != null) {
      System.out.println(Arrays.toString(list3.toArray()));
    }

  }
}