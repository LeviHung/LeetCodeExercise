package easy;

public class FirstOccurrenceString
{
  public static int strStr(String haystack, String needle) 
  {
    int index = -1;
    int startIndex = 0;
    int checkIndex = 0;
    
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(checkIndex)) {
        if (checkIndex == 0) {
          startIndex = i;
          checkIndex++;
          if (checkIndex >= needle.length()) {
            return startIndex;
          }
        }

        for (int j = startIndex + 1; j < needle.length() + startIndex; j++) {
          if (j >= haystack.length()) {
            return index;
          }
          
          if (haystack.charAt(j) == needle.charAt(checkIndex)) {
            checkIndex++;
            if (checkIndex >= needle.length()) {
              return startIndex;
            }
          } else {
            checkIndex = 0;
            break;
          }
        }
      }
    }
    
    return index;
  }

  public static int strStrOpt(String haystack, String needle) 
  {
    final int m = haystack.length();
    final int n = needle.length();

    for (int i = 0; i < m - n + 1; ++i) {
      if (haystack.substring(i, i + n).equals(needle)) {
        return i;
      }
    }
  
    return -1;
  }

  public static void readme()
  {
    String str = "Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.\n";

    System.out.println(str);
  }
}