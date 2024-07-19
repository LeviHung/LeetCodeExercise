package string;

import java.util.Arrays;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class KeyboardRow
{
  public static String[] findWords(String[] words)
  {    
    HashMap <Character, Integer> map = new HashMap<>();
    map.put('q', 1);
    map.put('w', 1);
    map.put('e', 1);
    map.put('r', 1);
    map.put('t', 1);
    map.put('y', 1);
    map.put('u', 1);
    map.put('i', 1);
    map.put('o', 1);
    map.put('p', 1);
    map.put('a', 2);
    map.put('s', 2);
    map.put('d', 2);
    map.put('f', 2);
    map.put('g', 2);
    map.put('h', 2);
    map.put('j', 2);
    map.put('k', 2);
    map.put('l', 2);
    map.put('z', 3);
    map.put('x', 3);
    map.put('c', 3);
    map.put('v', 3);
    map.put('b', 3);
    map.put('n', 3);
    map.put('m', 3);

    List <String> list = new ArrayList<>();
    int firstValue = 0;
    for (int i = 0; i < words.length; i++) {
      firstValue = map.get(Character.toLowerCase(words[i].charAt(0)));
      for (int j = 1; j < words[i].length(); j++) {
        if (firstValue != map.get(Character.toLowerCase(words[i].charAt(j)))) {
          firstValue = 0;
          break;
        }
      }
      if (firstValue != 0) {
        list.add(words[i]);
      }
    }

    String[] ans = new String [list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }

    return ans;
  }

  public static String[] findWordsOpt(String[] words) 
  {
    String[] n = new String[words.length];
    int k = 0;
    for(int i = 0; i < words.length; i++){
        int check = row(words[i].charAt(0));
        for(int j = 1; j < words[i].length(); j++){
            if(check != row(words[i].charAt(j))){
                check = 0;
                break;
            }
        }
        if(check!=0){
            n[k] = words[i];
            k++;
        }
    }
    String ans[] = new String[k];
    for(int i = 0; i < k; i ++){
        ans[i] = n[i]; 
    }
    return ans;
  }
  public static int row(char c)
  {
    c = Character.toLowerCase(c);
    String str1= "qwertyuiop";
    String str2= "asdfghjkl";
    String str3= "zxcvbnm";
    if (str1.contains(String.valueOf(c))){
        return 1;            
    }else if(str2.contains(String.valueOf(c))){
        return 2;
    }else if(str3.contains(String.valueOf(c))){
        return 3;
    }
    return 0;
  }

  public static void readme()
  {
    String str = "Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.\n\n";

    str += "In the American keyboard:\n\n";

    str += "the first row consists of the characters \"qwertyuiop\",\n\n";

    str += "the second row consists of the characters \"asdfghjkl\", and\n\n";

    str += "the third row consists of the characters \"zxcvbnm\".\n";

    System.out.println(str);
  }

  public static void main()
  {
    KeyboardRow.readme();

    // words = ["Hello","Alaska","Dad","Peace"] => ["Alaska","Dad"]
    String[] words1 = {"Hello","Alaska","Dad","Peace"};
    System.out.println("findWords(" + Arrays.toString(words1) + ") = " + 
                       Arrays.toString(findWords(words1)));

    // words = ["omk"] => []
    String[] words2 = {"omk"};
    System.out.println("findWords(" + Arrays.toString(words2) + ") = " + 
                       Arrays.toString(findWords(words2)));

    // words = ["adsdf","sfd"] => ["adsdf","sfd"]
    String[] words3 = {"adsdf","sfd"};
    System.out.println("findWords(" + Arrays.toString(words3) + ") = " + 
                       Arrays.toString(findWords(words3)));
    System.out.println("findWordsOpt(" + Arrays.toString(words3) + ") = " + 
                       Arrays.toString(findWordsOpt(words3)));
  }
}