package recursion;

import java.util.Stack;

public class DecodeString
{
  public static String decodeString(String s) {
    if (s.length() == 0) {
        return s;
    }

    StringBuilder res = new StringBuilder();
    char ch = s.charAt(0);
    if (Character.isLetter(ch)) {
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        int i = 1;
        while (i < s.length()) {
            ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                i++;
                sb.append(ch);
            } else {
                i--;
                break;
            }
        }
        res = sb;
        if (i < s.length()) {
            String decode = decodeString(s.substring(i+1)); 
            res.append(decode);
        }

    } else {
        int openBracket = s.indexOf('[');
        int num = Integer.parseInt(s.substring(0, openBracket));
        int closeBracket = getCloseBracketIndex(s, openBracket);
        String decode = decodeString(s.substring(openBracket+1, closeBracket));

        while (num-- > 0) {
            res.append(decode);
        }
        res.append(decodeString(s.substring(closeBracket+1)));
    }
    return res.toString();
  }

  public static int getCloseBracketIndex(String s, int start) {
    int openGroup = 1;
    int i = start + 1;
    char ch;
    while (i < s.length()) {
        ch = s.charAt(i);
        if (ch == '[') {
            openGroup++;
        } else if (ch == ']') {
            openGroup--;
        }
        if (openGroup == 0) {
            return i;
        }
        i++;
    }
    return 0;
  }
  
  public static String decodeStringOld(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<String> wordStack = new Stack<>();
    int number = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
            number = number * 10 + (ch - '0');

        } else if (Character.isLetter(ch)) {
            sb.append(ch);

        } else if (ch == '[') {
            countStack.add(number);
            wordStack.add(sb.toString());
            number = 0;
            sb = new StringBuilder();
        } else {
            int count = countStack.pop();
            StringBuilder sbDuplicate = new StringBuilder(wordStack.pop());
            for (int j = 0; j < count; j++) {
                sbDuplicate.append(sb);
            }
            sb = sbDuplicate;
        }
    }
    return sb.toString();
  }

  public static void readme()
  {
    String str = "Given an encoded string, return its decoded string.\n\n";

    str += "The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.\n\n";

    str += "You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].\n\n";

    str += "The test cases are generated so that the length of the output will never exceed 105.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DecodeString.readme();
    String s;
    int n;
    // Input: s = "3[a]2[bc]"
    // Output: "aaabcbc"
    s = "3[a]2[bc]";
    System.out.println("decodeString(" + s + ") = " + decodeString(s));

    // Input: s = "3[a2[c]]"
    // Output: "accaccacc"
    s = "3[a2[c]]";
    System.out.println("decodeString(" + s + ") = " + decodeString(s));

    // Input: s = "2[abc]3[cd]ef"
    // Output: "abcabccdcdcdef"
    s = "2[abc]3[cd]ef";
    System.out.println("decodeString(" + s + ") = " + decodeString(s));

  }
}