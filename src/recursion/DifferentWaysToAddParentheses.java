package recursion;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DifferentWaysToAddParentheses
{
    static HashMap<String, List<Integer>> map = new HashMap<>();
    public static List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (Integer l: left) {
                    for (Integer r: right) {
                        if (ch == '+') {
                            res.add(l + r);
                        } else if (ch == '-') {
                            res.add(l - r);
                        } else if (ch == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        map.put(expression, res);
        return res;
    }

  public static void readme()
  {
    String str = "Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.\n\n";

    str += "The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DifferentWaysToAddParentheses.readme();
    String expression;
    // Input: expression = "2-1-1"
    // Output: [0,2]
    expression = "2-1-1";
    System.out.println("diffWaysToCompute(" + expression + ") = ");
    List<Integer> list1 = diffWaysToCompute(expression);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: expression = "2*3-4*5"
    // Output: [-34,-14,-10,-10,10]
    expression = "2*3-4*5";
    System.out.println("diffWaysToCompute(" + expression + ") = ");
    List<Integer> list2 = diffWaysToCompute(expression);
    System.out.println(Arrays.toString(list2.toArray()));
    }
}