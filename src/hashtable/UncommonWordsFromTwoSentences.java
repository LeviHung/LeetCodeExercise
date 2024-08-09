package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class UncommonWordsFromTwoSentences
{
  public static String[] uncommonFromSentences(String s1, String s2) 
  {
    HashMap <String, Integer> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(s1);
    String[] arrayS1 = new String[st.countTokens()];
    int index = 0;
    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      arrayS1[index++] = word;
      if (map.containsKey(word) == true) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    List <String> uncommon = new ArrayList<>();
    st = new StringTokenizer(s2);
    String[] arrayS2 = new String[st.countTokens()];
    index = 0;

    while(st.hasMoreTokens()) {
      String word = st.nextToken();
      arrayS2[index++] = word;
      if (map.containsKey(word) == true) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }
    
    for (int i = 0; i < arrayS1.length; i++) {
      if (map.containsKey(arrayS1[i]) == true) {
        if (map.get(arrayS1[i]) == 1) {
          uncommon.add(arrayS1[i]);
        }
      }
    }

    for (int i = 0; i < arrayS2.length; i++) {
      if (map.containsKey(arrayS2[i]) == true) {
        if (map.get(arrayS2[i]) == 1) {
          uncommon.add(arrayS2[i]);
        }
      }
    }

    String[] res = new String[uncommon.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = uncommon.get(i);
    }
    
    return res;
  }

  public static String[] uncommonFromSentencesOpt(String s1, String s2) 
  {
    HashMap<String,Integer> map=new HashMap<>();
    String one[]=s1.split(" ");
    String two[]=s2.split(" ");
    for(String a:one){
      map.put(a,map.getOrDefault(a,0)+1);
    }
    for(String b:two){
      map.put(b,map.getOrDefault(b,0)+1);
    }
    List<String> list=new ArrayList<>();
    for(String k:map.keySet()){
      if(map.get(k)==1){
        list.add(k);
      }
    }
    return list.toArray(new String[0]);
  }

  public static void readme()
  {
    String str = "A sentence is a string of single-space separated words where each word consists only of lowercase letters.\n\n";

    str += "A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.\n\n";

    str += "Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    UncommonWordsFromTwoSentences.readme();

    String s1;
    String s2;
    // s1 = "this apple is sweet", s2 = "this apple is sour" => ["sweet","sour"]
    s1 = "this apple is sweet";
    s2 = "this apple is sour";
    System.out.println("uncommonFromSentences(" + s1 + ", " + s2 + ") = " + 
                       Arrays.toString(uncommonFromSentences(s1, s2)));

    // s1 = "apple apple", s2 = "banana" => [banana]
    s1 = "apple apple";
    s2 = "banana";
    System.out.println("uncommonFromSentences(" + s1 + ", " + s2 + ") = " + 
                       Arrays.toString(uncommonFromSentences(s1, s2)));

    System.out.println("uncommonFromSentencesOpt(" + s1 + ", " + s2 + ") = " + 
     Arrays.toString(uncommonFromSentencesOpt(s1, s2)));

  }
}