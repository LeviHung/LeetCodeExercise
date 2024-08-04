package hashtable;

import java.util.Arrays;

public class FirstUniqueCharacterString
{
  public static int firstUniqChar(String s)
  {
    // Use array instead of String object to get better for runtime.
    char[] array = s.toCharArray();
    int[] map = new int[26];
    for (int i = 0; i < array.length; i++) {
      //map[s.charAt(i) - 'a']++;
      map[array[i] - 'a']++;
    }
    for (int i = 0; i < array.length; i++) {
      //if (map[s.charAt(i) - 'a'] == 1) {
      if (map[array[i] - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }

  public static int firstUniqCharOpt(String s) 
  {
      char[] ch = s.toCharArray();
      int[] freq = new int[26];
      Arrays.fill(freq,-1);
      for(int i=0; i<ch.length; i++){
         freq[ch[i]-'a']++;
      }
      for(int i=0; i<ch.length; i++){
          if(freq[ch[i]-'a']==0){
              return i;
          }
      }
      return -1;
  }
  
  public static void readme()
  {
    String str = "Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    FirstUniqueCharacterString.readme();

    // s = "leetcode" => 0
    String s = "leetcode";

    System.out.println("firstUniqChar(" + s + ") = " + 
                       firstUniqChar(s));

    // s = "loveleetcode" => 2
    s = "loveleetcode";

    System.out.println("firstUniqChar(" + s + ") = " + 
                       firstUniqChar(s));

    // s = "aabb" => -1
    s = "aabb";

    System.out.println("firstUniqChar(" + s + ") = " + 
                       firstUniqChar(s));

  }
}