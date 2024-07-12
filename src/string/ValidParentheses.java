package string;

import java.util.Stack;

public class ValidParentheses
{
  public static boolean isValid(String s)
  {
    // "()", "()[]{}", "(]", "{[]}", "["
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(')');
      } else if (s.charAt(i) == '[') {
        stack.push(']');
      } else if (s.charAt(i) == '{') {
        stack.push('}');
        
      } else if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && 
          stack.empty()) {
        return false;
      } else if (s.charAt(i) == ')' && !stack.pop().equals(')')) {
        return false;
      } else if (s.charAt(i) == ']' && !stack.pop().equals(']')) {
        return false;
      } else if (s.charAt(i) == '}' && !stack.pop().equals('}')) {
        return false;
      }
    }

    return stack.empty();
  }

  public static boolean isValidOpt(String s) 
  {
    // create an empty stack
    Stack<Character> stack = new Stack<Character>(); 

    // loop through each character in the string
    for (char c : s.toCharArray()) { 
      if (c == '(') // if the character is an opening parenthesis
        stack.push(')'); // push the corresponding closing parenthesis onto the stack
      else if (c == '{') // if the character is an opening brace
        stack.push('}'); // push the corresponding closing brace onto the stack
      else if (c == '[') // if the character is an opening bracket
        stack.push(']'); // push the corresponding closing bracket onto the stack
      else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
      // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
      // does not match the closing bracket, the string is not valid, so return false
        return false;
      }
      // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
      // so the string is valid, otherwise, there are unmatched opening brackets, so return false
      return stack.isEmpty();
  }
  
  public static void readme()
  {
    String str = "Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.\n\n";

    str += "An input string is valid if:\n";

    str += "Open brackets must be closed by the same type of brackets.\n";

    str += "Open brackets must be closed in the correct order.\n";

    str += "Every close bracket has a corresponding open bracket of the same type\n";

    System.out.println(str);
  }

  public static void main()
  {
    ValidParentheses.readme();

    String str = "()";

    System.out.println("isValid(" + str + ") = " + 
                       ValidParentheses.isValid(str));

    String str2 = "()[]{}";

    System.out.println("isValid(" + str2 + ") = " + 
                       ValidParentheses.isValid(str2));

    String str3 = "(]";

    System.out.println("isValid(" + str3 + ") = " + 
                       ValidParentheses.isValid(str3));


    String str4 = "{[]}";

    System.out.println("isValid(" + str4 + ") = " + 
                       ValidParentheses.isValid(str4));

    String str5 = "]";

    System.out.println("isValid(" + str5 + ") = " + 
                       ValidParentheses.isValid(str5));

    String str6 = "{[Str]}";

    System.out.println("isValid(" + str6 + ") = " + 
                       ValidParentheses.isValidOpt(str6));

  }
}