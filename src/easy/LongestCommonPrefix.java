package easy;

import java.util.HashSet;

public class LongestCommonPrefix
{
  public static String longestCommonPrefix(String[] strs)
  {
    if (strs.length == 1) {
      return strs[0];
    }

    // Method 2: Use for loop
    // find the minimum length word.
    int minSize = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < minSize) {
         minSize = strs[i].length();
      }
    }

    String commonPrefix = "";
    for (int j = 0; j < minSize; j++) {
      for (int i = 0; i < strs.length - 1; i++) {
        if (strs[i].charAt(j) != strs[i + 1].charAt(j)) {
            return commonPrefix;
        }        
      }
      commonPrefix += strs[0].charAt(j);
    }

    return commonPrefix;
    
    // Method 1: Use HashSet
    /*
    HashSet<String> compareArray = new HashSet<>();
    HashSet<String> commonArray = new HashSet<>();
    String prefix = "";
    for (int i = 0; i < strs[0].length(); i++) {
      prefix += strs[0].charAt(i);
      commonArray.add(prefix);
    }

    for (int i = 1; i < strs.length - 1; i++) {
      compareArray.clear();
      compareArray.addAll(commonArray);
      prefix = "";
      commonArray.clear();
      for (int j = 0; j < strs[i].length(); j++) {
        prefix += strs[i].charAt(j);
        if (compareArray.contains(prefix)) {
          commonArray.add(prefix);
        }
      }
    }

    compareArray.clear();
    compareArray.addAll(commonArray);
    prefix = "";
    commonArray.clear();
    String commonPrefix = "";
    for (int j = 0; j < strs[strs.length - 1].length(); j++) {
      prefix += strs[strs.length - 1].charAt(j);
      if (compareArray.contains(prefix)) {
        commonPrefix = prefix;
      }
    }

    return commonPrefix;

    */
  }

  public static String longestCommonPrefixOpt(String[] strs)
  {
    if (strs == null || strs.length == 0) {
      return "";
    }

    // Start with the first string in the array as the initial prefix
    String prefix = strs[0];
  
    // Iterate through the rest of the strings
    for (int i = 1; i < strs.length; i++) {
      // Check the current prefix against the current string
      while (strs[i].indexOf(prefix) != 0) {
        // Reduce the prefix by one character from the end until 
        //it matches the start of the current string
        prefix = prefix.substring(0, prefix.length() - 1);
        // If the prefix becomes empty, return an empty string
        if (prefix.isEmpty()) {
            return "";
        }
      }
    }

    return prefix;
  }
  
  public static void readme()
  {
    String str = "Write a function to find the longest common prefix string amongst an array of strings.\n\n";

    str += "If there is no common prefix, return an empty string \"\"\n";

    System.out.println(str);
  }
}