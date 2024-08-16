package math;

public class GreatestCommonDivisorOfStrings
{
  public static String gcdOfStrings(String str1, String str2) 
  {
    int num = gcd(str1.length(), str2.length());
    String subStr = str2.substring(0, num);
    int start = num;
    while (start < str2.length()) {
        String tmp = str2.substring(start, start+num);
        if (tmp.equals(subStr) != true) {
            return "";
        }
        start += num;
    }
    start = 0;
    while (start < str1.length()) {
        String tmp = str1.substring(start, start+num);
        if (tmp.equals(subStr) != true) {
            return "";
        }
        start += num;
    }
    return subStr;
    /*
    char [] subStr = new char [num];
    for (int i = 0; i < num; i++) {
        subStr[i] = ArrayStr2[i];
    }

    boolean isCommon = true;
    if (num != ArrayStr2.length) {
        for (int i = num; i < ArrayStr2.length; i=i+num) {
            for (int j = 0; j < num; j++) {
                if (ArrayStr2[i+j] != subStr[j]) {
                    return "";
                }
            }
        }
    }

    for (int i = 0; i < ArrayStr1.length; i=i+num) {
        for (int j = 0; j < num; j++) {
            if (ArrayStr1[i+j] != subStr[j]) {
                return "";
            }
        }
    } 
    return new String(subStr);
    */
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
  }

  public static void readme()
  {
    String str = "For two strings s and t, we say \"t divides s\" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).\n\n";

    str += "Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.\n";

    System.out.println(str);
  }

  public static void main()
  {
    GreatestCommonDivisorOfStrings.readme();

    String str1;
    String str2;
    // Input: str1 = "ABCABC", str2 = "ABC"
    // Output: "ABC"
    str1 = "ABCABC";
    str2 = "ABC";
    System.out.println("gcdOfStrings(" + str1 + ", " + str2 + ") = " + 
                       gcdOfStrings(str1, str2));

    //Input: str1 = "ABABAB", str2 = "ABAB"
    //Output: "AB"
    str1 = "ABABAB";
    str2 = "ABAB";
    System.out.println("gcdOfStrings(" + str1 + ", " + str2 + ") = " + 
                       gcdOfStrings(str1, str2));

    //Input: str1 = "LEET", str2 = "CODE"
    //Output: ""
    str1 = "LEET";
    str2 = "CODE";
    System.out.println("gcdOfStrings(" + str1 + ", " + str2 + ") = " + 
                      gcdOfStrings(str1, str2));

    }
}