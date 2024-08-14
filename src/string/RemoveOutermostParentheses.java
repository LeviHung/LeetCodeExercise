package string;

import java.util.StringTokenizer;

public class RemoveOutermostParentheses
{
  public static String removeOuterParentheses(String s) 
  {
    char[] array = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    int beginP = 1;

    for (int i = 1; i < array.length - 1; i++) {
      if (array[i] == '(') {
        if (beginP == 0) {
          beginP++;
        } else {
          beginP++;
          sb.append('(');
        }
      } else {
        if (beginP > 1) {
          beginP--;
          sb.append(')');
        } else {
          beginP--;
        }
      }
    }
    return sb.toString();
  }

  public static void readme()
  {
    String str = "A valid parentheses string is either empty \"\", \"(\" + A + \")\", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.\n\n";
    str += "For example, \"\", \"()\", \"(())()\", and \"(()(()))\" are all valid parentheses strings.\n\n";
    str += "A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.\n\n";
    str += "Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.\n\n";
    str += "Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    RemoveOutermostParentheses.readme();
    String s;

    // s = "(()())(())" => "()()()"
    s = "(()())(())";
    System.out.println("removeOuterParentheses(" + s + ") = " + 
                       removeOuterParentheses(s));

    //  s = "(()())(())(()(()))" => "()()()()(())"
    s = "(()())(())(()(()))";
    System.out.println("removeOuterParentheses(" + s + ") = " + 
                       removeOuterParentheses(s));

    // s = "()()" => ""
    s = "()()";
    System.out.println("removeOuterParentheses(" + s + ") = " + 
                       removeOuterParentheses(s));

  }

}