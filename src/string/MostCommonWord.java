package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Map;

public class MostCommonWord
{
  public static String mostCommonWord(String paragraph, String[] banned)
  {
    HashMap<String, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    for (String str: banned) {
      set.add(str);
    }

    //paragraph = paragraph.toLowerCase();

    // Better runtime to use StringTokenizer class.
    StringTokenizer st = new StringTokenizer(paragraph, " ,.;!?'");
    int most = 0;
    String res = "";
    while(st.hasMoreTokens()) {
      String word = st.nextToken().toLowerCase();
      if (set.contains(word) == false) {
        if (map.containsKey(word) == true) {
          int value = map.get(word) + 1;
          map.put(word, value);
          if (value > most) {
            most = value;
            res = word;
          }
        } else {
          map.put(word, 1);
          if (most == 0) {
            most = Math.max(most, 1);
            res = word;
          }
        }
      }
    }
    
    return res;

    // Use split methods.
    /*
    String [] special = {"!", "?", "\'", ",", ";", "."};
    for (String ch: special) {
      paragraph = paragraph.replace(ch, " ");
    }
    String [] tokens = paragraph.split(" ");
    
    int most = 0;
    String res = "";
    for (int i = 0; i < tokens.length; i++) {
      tokens[i] = tokens[i].toLowerCase();
      
      if (map.containsKey(tokens[i]) == true) {
        int value = map.get(tokens[i]) + 1;
        map.put(tokens[i], value);
        if (tokens[i].length() > 0 && set.contains(tokens[i]) == false) {
          if (value > most) {
            most = value;
            res = tokens[i];
          }
        }
      } else {
        map.put(tokens[i], 1);
        if (tokens[i].length() > 0 && set.contains(tokens[i]) == false) {
          if (most == 0) {
            most = Math.max(most, 1);
            res = tokens[i];
          }
        }
      }
    }
    return res;
    */
  }

  public static String mostCommonWordOpt(String paragraph, String[] banned) 
  {
    TrieNode root = makeTrie(banned);
    TrieNode node = root;

    char[] arr = paragraph.toCharArray();
    boolean prevIsWord = false;
    int start = -1;
    int maxFreq = 0;
    int maxStart = -1;
    int maxEnd = -1;
    char ch;
    for (int i = 0; i < arr.length; i++) {
       switch(arr[i]) {
           case ' ':
           case '!':
           case '?':
           case '\'':
           case ',':
           case ';':
           case '.':
               if (prevIsWord) {
                   // calc max 
                   if (!node.banned) {
                       node.count+=1;
                       if (node.count > maxFreq) {
                           maxStart = start;
                           maxEnd = i;
                           maxFreq = node.count;
                       }
                    }
               }

               node = root;
               prevIsWord = false;
               break;
           default:

               if (!prevIsWord) {
                   start = i;
               }
                  if (arr[i] <='Z') {
                    ch =   (char)(arr[i] + 'a' - 'A');
                  }else {
                      ch = arr[i];
                  }

  //                     if (!node.contains(ch)) {
  //                         node.addChild(ch);
  //                     }

               node = node.addChild(ch);

               prevIsWord = true;
            }

       }

       if (node != root && !node.banned) {
                       node.count+=1;
                       if (node.count > maxFreq) {
                           maxStart = start;
                           maxEnd = arr.length;
                           maxFreq = node.count;
                       }
                    }

        return paragraph.substring(maxStart, maxEnd).toLowerCase();
    }

  public static TrieNode makeTrie(String[] banned) {
    TrieNode root = new TrieNode('0');
    TrieNode node;
    for (String w : banned) {
        node = root;

        for (char ch : w.toCharArray()) {
            // if (ch <='Z') {
            //     ch += 'a' - 'A';
            // }
            node = node.addChild(ch);
        }
        node.count += 1;
        node.banned = true;
    }
    return root;
  }


  static class TrieNode {
    char ch;
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
    boolean banned;

    public TrieNode(char ch) {
        this.ch = ch;
    }

    public boolean contains(char ch) {
        return children.containsKey(ch);
    }

    public TrieNode addChild(char ch) {
        if (contains(ch)) return children.get(ch);
        var child = new TrieNode(ch);
        children.put(ch, child);
        return child;
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }

  }
  
  public static void readme()
  {
    String str = "Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.\n\n";

    str += "The words in paragraph are case-insensitive and the answer should be returned in lowercase.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MostCommonWord.readme();

    String paragraph;
    //paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"] => "ball"
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned1 = {"hit"};
    System.out.println("mostCommonWord(\"" + paragraph + "\", " + 
                        Arrays.toString(banned1) + ") = " +     
                        mostCommonWord(paragraph, banned1));

    //paragraph = "paragraph = "a.", banned = [] => "a"
    paragraph = "a.";
    String[] banned2 = {"test"};
    System.out.println("mostCommonWord(\"" + paragraph + "\", " + 
                        Arrays.toString(banned2) + ") = " +     
                        mostCommonWord(paragraph, banned2));

    paragraph = "a, a, a, a, b,b,b,c, c";
    String[] banned3 = {"a"};
    System.out.println("mostCommonWord(\"" + paragraph + "\", " + 
                        Arrays.toString(banned3) + ") = " +     
                        mostCommonWord(paragraph, banned3));

    paragraph ="abc abc? abcd the jeff!";
    String[] banned4 = {"abc","abcd","jeff"};
    System.out.println("mostCommonWord(\"" + paragraph + "\", " + 
                        Arrays.toString(banned4) + ") = " +     
                        mostCommonWord(paragraph, banned4));

    System.out.println("mostCommonWordOpt(\"" + paragraph + "\", " + 
                        Arrays.toString(banned4) + ") = " +     
                        mostCommonWordOpt(paragraph, banned4));

  }
}